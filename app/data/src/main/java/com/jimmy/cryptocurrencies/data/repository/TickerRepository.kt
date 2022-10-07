package com.jimmy.cryptocurrencies.data.repository

import com.jimmy.cryptocurrencies.data.local.dao.TickerDao
import com.jimmy.cryptocurrencies.data.local.entity.TickerEntity
import com.jimmy.cryptocurrencies.data.network.api.CryptoCurrencyApiServices
import com.jimmy.cryptocurrencies.data.network.model.response.ticker.TickerResponseModel
import com.jimmy.cryptocurrencies.data.repository.mapper.toDataModel
import com.jimmy.cryptocurrencies.data.repository.mapper.toEntity
import com.jimmy.cryptocurrencies.data.repository.model.TickerDataModel
import com.jimmy.cryptocurrencies.data.utils.CryptoLog
import javax.inject.Inject

class TickerRepository @Inject constructor(
    private val api: CryptoCurrencyApiServices,
    private val dao: TickerDao
) {
    suspend fun get(bookSymbol: String): TickerDataModel {
        return try {
            val responseNetwork = getFromNetwork(bookSymbol)
            CryptoLog.Data.success("ticker get from network, response: $responseNetwork")
            insertToLocal(responseNetwork.toEntity())
            responseNetwork.toDataModel()
        } catch (ex: Exception) {
            CryptoLog.Data.error(exception = ex)
            val responseLocal = getFromLocal(bookSymbol)
            responseLocal.toDataModel()
        }
    }

    private suspend fun getFromNetwork(bookSymbol: String): TickerResponseModel {
        val response = api.getTicker(bookSymbol)
        return response.result ?: throw NullPointerException("order book is null")
    }

    private suspend fun getFromLocal(book: String): TickerEntity {
        return dao.getByName(book)
    }

    private suspend fun insertToLocal(ticker: TickerEntity) {
        dao.delete(ticker.book)
        dao.insert(ticker)
    }
}
