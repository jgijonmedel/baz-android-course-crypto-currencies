package com.jimmy.cryptocurrencies.data.repository

import com.jimmy.cryptocurrencies.data.local.dao.AskBidsDao
import com.jimmy.cryptocurrencies.data.local.dao.OrderBookDao
import com.jimmy.cryptocurrencies.data.local.entity.AsksBidsEntity
import com.jimmy.cryptocurrencies.data.local.entity.OrderBookEntity
import com.jimmy.cryptocurrencies.data.local.entity.RelationOrderBookWithAskBids
import com.jimmy.cryptocurrencies.data.network.api.CryptoCurrencyApiServices
import com.jimmy.cryptocurrencies.data.network.model.response.orderBook.OrderBookNetworkModelResponse
import com.jimmy.cryptocurrencies.data.repository.mapper.toDataModel
import com.jimmy.cryptocurrencies.data.repository.mapper.toEntities
import com.jimmy.cryptocurrencies.data.repository.mapper.toEntity
import com.jimmy.cryptocurrencies.data.repository.model.AskBidsType
import com.jimmy.cryptocurrencies.data.repository.model.OrderBookDataModel
import com.jimmy.cryptocurrencies.data.utils.CryptoLog
import javax.inject.Inject
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlin.math.absoluteValue

class OrderBookRepository @Inject constructor(
    private val api: CryptoCurrencyApiServices,
    private val orderBookDao: OrderBookDao,
    private val askBidsDao: AskBidsDao
) {
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
        CryptoLog.Data.success("get from local")
        return orderBookDao.getByName(name)
    }

    private suspend fun insertOrderBookToLocal(book: OrderBookEntity): Long {
        orderBookDao.delete(book.name)
        return orderBookDao.insert(book)
    }

    private suspend fun insertAskBidsToLocal(
        askAndBids: List<AsksBidsEntity>,
        book: String,
        OrderBookId: String
    ) {
        deleteAskBidsToLocal(book, OrderBookId)
        askBidsDao.insertAll(askAndBids)
    }

    private suspend fun deleteAskBidsToLocal(
        book: String,
        OrderBookId: String
    ) {
        askBidsDao.deleteAll(book, OrderBookId)
    }
}
