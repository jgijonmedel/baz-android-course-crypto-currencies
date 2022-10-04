package com.jimmy.cryptocurrencies.data.repository

import android.content.Context
import com.jimmy.cryptocurrencies.common.utils.CryptoLog
import com.jimmy.cryptocurrencies.data.local.database.CryptocurrencyDataBase
import com.jimmy.cryptocurrencies.data.local.entity.AsksBidsEntity
import com.jimmy.cryptocurrencies.data.local.entity.OrderBookEntity
import com.jimmy.cryptocurrencies.data.local.entity.RelationOrderBookWithAskBids
import com.jimmy.cryptocurrencies.data.network.api.CryptoCurrencyApiServices
import com.jimmy.cryptocurrencies.data.network.api.RetrofitClient
import com.jimmy.cryptocurrencies.data.network.model.response.orderBook.OrderBookNetworkModelResponse
import com.jimmy.cryptocurrencies.data.repository.mapper.toDataModel
import com.jimmy.cryptocurrencies.data.repository.mapper.toEntities
import com.jimmy.cryptocurrencies.data.repository.mapper.toEntity
import com.jimmy.cryptocurrencies.data.repository.model.AskBidsType
import com.jimmy.cryptocurrencies.data.repository.model.OrderBookDataModel
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlin.math.absoluteValue

class OrderBookRepository(context: Context) {

    private val api: CryptoCurrencyApiServices = RetrofitClient.getApiService()
    private val local: CryptocurrencyDataBase = CryptocurrencyDataBase.getDatabase(context)

    suspend fun getOrderBook(bookSymbol: String): OrderBookDataModel {
        return try {
            val responseNetwork = getFromNetwork(bookSymbol)
            CryptoLog.Data.success("get from network, response: $responseNetwork")
            coroutineScope {
                val deferredIdeOrderBook = async { insertOrderBookToLocal(responseNetwork.toEntity(bookSymbol)) }
                val idOrderBook = deferredIdeOrderBook.await().absoluteValue.toString()
                CryptoLog.Data.success("insert orderBook")

                val askResponseNetwork = responseNetwork.asks.toEntities(idOrderBook, AskBidsType.ASK)
                val bidsResponseNetwork = responseNetwork.bids.toEntities(idOrderBook, AskBidsType.Bids)
                val askAndBids = askResponseNetwork.plus(bidsResponseNetwork)
                val book = bookSymbol.split("_")[0]

                insertAskBidsToLocal(askAndBids, book, idOrderBook)
                CryptoLog.Data.success("insert askAndBids")
            }
            responseNetwork.toDataModel()
        } catch (ex: Exception) {
            CryptoLog.Data.error(exception = ex)
            val responseLocal = getOrderBookFromLocal(bookSymbol)
            responseLocal.toDataModel()
        }
    }

    private suspend fun getFromNetwork(bookSymbol: String): OrderBookNetworkModelResponse {
        val response = api.getOrderBook(bookSymbol)
        return response.result ?: throw NullPointerException("order book is null")
    }

    private suspend fun getOrderBookFromLocal(name: String): RelationOrderBookWithAskBids {
        val dao = local.getOrderBookDao()
        CryptoLog.Data.success("get from local")
        return dao.getByName(name)
    }

    private suspend fun insertOrderBookToLocal(book: OrderBookEntity): Long {
        val dao = local.getOrderBookDao()
        deleteOrderBookToLocal(book.name)
        return dao.insert(book)
    }

    private suspend fun deleteOrderBookToLocal(name: String) {
        val dao = local.getOrderBookDao()
        dao.delete(name)
    }

    private suspend fun insertAskBidsToLocal(
        askAndBids: List<AsksBidsEntity>,
        book: String,
        OrderBookId: String
    ) {
        val dao = local.getAsksBidsDao()
        deleteAskBidsToLocal(book, OrderBookId)
        dao.insertAll(askAndBids)
    }

    private suspend fun deleteAskBidsToLocal(
        book: String,
        OrderBookId: String
    ) {
        val dao = local.getAsksBidsDao()
        dao.deleteAll(book, OrderBookId)
    }
}
