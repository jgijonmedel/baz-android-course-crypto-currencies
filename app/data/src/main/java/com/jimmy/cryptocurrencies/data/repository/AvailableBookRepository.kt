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

    suspend fun getAllAvailableBooks(): List<AvailableBookDataModel> {
        return try {
            val responseNetwork = getAllAvailableBooksFromNetwork()
            insertAllAvailableBooksToLocal(responseNetwork.toEntities())
            responseNetwork.toDataModels()
        } catch (ex: Exception) {
            CryptoLog.Data.error(exception = ex)
            val responseLocal = getAllAvailableBooksFromLocal()
            responseLocal.toDataModels()
        }
    }

    private suspend fun getAllAvailableBooksFromNetwork(): List<AvailableBookNetworkModelResponse> {
        val response = api.getAvailableBooks()
        CryptoLog.Data.success("get from network")
        return response.result ?: emptyList()
    }

    private suspend fun getAllAvailableBooksFromLocal(): List<AvailableBookEntity> {
        val dao = local.getAvailableBookDao()
        CryptoLog.Data.success("get from local")
        return dao.getAll()
    }

    private suspend fun insertAllAvailableBooksToLocal(books: List<AvailableBookEntity>) {
        val dao = local.getAvailableBookDao()
        deleteAllAvailableBooksToLocal()
        CryptoLog.Data.success("insert data")
        return dao.insertAll(books)
    }

    private suspend fun deleteAllAvailableBooksToLocal() {
        val dao = local.getAvailableBookDao()
        return dao.deleteAll()
    }

}