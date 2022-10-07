package com.jimmy.cryptocurrencies.data.repository

import com.jimmy.cryptocurrencies.data.local.dao.AvailableBookDao
import com.jimmy.cryptocurrencies.data.local.entity.AvailableBookEntity
import com.jimmy.cryptocurrencies.data.network.api.CryptoCurrencyApiServices
import com.jimmy.cryptocurrencies.data.network.model.response.availableBooks.AvailableBookNetworkModelResponse
import com.jimmy.cryptocurrencies.data.repository.mapper.toDataModels
import com.jimmy.cryptocurrencies.data.repository.mapper.toEntities
import com.jimmy.cryptocurrencies.data.repository.model.AvailableBookDataModel
import com.jimmy.cryptocurrencies.data.utils.CryptoLog
import javax.inject.Inject

class AvailableBookRepository @Inject constructor(
    private val api: CryptoCurrencyApiServices,
    private val dao: AvailableBookDao
) {

    suspend fun getAll(): List<AvailableBookDataModel> {
        return try {
            val responseNetwork = getAllFromNetwork()
            CryptoLog.Data.success("get AvailableBooks from network")

            insertAllToLocal(responseNetwork.toEntities())
            CryptoLog.Data.success("insert AvailableBook in room")

            responseNetwork.toDataModels()
        } catch (ex: Exception) {
            CryptoLog.Data.error(exception = ex)
            val responseLocal = getAllFromLocal()
            CryptoLog.Data.success("get from local")
            responseLocal.toDataModels()
        }
    }

    private suspend fun getAllFromNetwork(): List<AvailableBookNetworkModelResponse> {
        val response = api.getAvailableBooks()
        return response.result ?: emptyList()
    }

    private suspend fun getAllFromLocal(): List<AvailableBookEntity> {
        return dao.getAll()
    }

    private suspend fun insertAllToLocal(books: List<AvailableBookEntity>) {
        try {
            deleteAllToLocal()
            return dao.insertAll(books)
        } catch (ex: Exception) {
            CryptoLog.Data.error(message = "insertAllToLocal method ", exception = ex)
        }
    }

    private suspend fun deleteAllToLocal() {
        return dao.deleteAll()
    }
}
