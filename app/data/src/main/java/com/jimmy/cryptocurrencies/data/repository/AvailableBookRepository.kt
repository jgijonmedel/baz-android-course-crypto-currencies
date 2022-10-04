package com.jimmy.cryptocurrencies.data.repository

import android.content.Context
import com.jimmy.cryptocurrencies.common.utils.CryptoLog
import com.jimmy.cryptocurrencies.data.local.database.CryptocurrencyDataBase
import com.jimmy.cryptocurrencies.data.local.entity.AvailableBookEntity
import com.jimmy.cryptocurrencies.data.network.api.CryptoCurrencyApiServices
import com.jimmy.cryptocurrencies.data.network.api.RetrofitClient
import com.jimmy.cryptocurrencies.data.network.model.response.availableBooks.AvailableBookNetworkModelResponse
import com.jimmy.cryptocurrencies.data.repository.mapper.toDataModels
import com.jimmy.cryptocurrencies.data.repository.mapper.toEntities
import com.jimmy.cryptocurrencies.data.repository.model.AvailableBookDataModel

class AvailableBookRepository(context: Context) {

    private val api: CryptoCurrencyApiServices = RetrofitClient.getApiService()
    private val local: CryptocurrencyDataBase = CryptocurrencyDataBase.getDatabase(context)

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
            responseLocal.toDataModels()
        }
    }

    private suspend fun getAllFromNetwork(): List<AvailableBookNetworkModelResponse> {
        val response = api.getAvailableBooks()
        return response.result ?: emptyList()
    }

    private suspend fun getAllFromLocal(): List<AvailableBookEntity> {
        val dao = local.getAvailableBookDao()
        CryptoLog.Data.success("get from local")
        return dao.getAll()
    }

    private suspend fun insertAllToLocal(books: List<AvailableBookEntity>) {
        try {
            val dao = local.getAvailableBookDao()
            deleteAllToLocal()
            return dao.insertAll(books)
        } catch (ex: Exception) {
            CryptoLog.Data.error(message = "insertAllToLocal method ", exception = ex)
        }
    }

    private suspend fun deleteAllToLocal() {
        val dao = local.getAvailableBookDao()
        return dao.deleteAll()
    }
}
