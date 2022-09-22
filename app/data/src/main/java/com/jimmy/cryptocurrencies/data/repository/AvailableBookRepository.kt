package com.jimmy.cryptocurrencies.data.repository

import android.content.Context
import com.jimmy.cryptocurrencies.data.local.database.CryptocurrencyDataBase
import com.jimmy.cryptocurrencies.data.local.entity.AvailableBookEntity
import com.jimmy.cryptocurrencies.data.network.api.CryptoCurrenciesApiServices
import com.jimmy.cryptocurrencies.data.network.api.RetrofitHelper
import com.jimmy.cryptocurrencies.data.network.model.response.availableBooks.AvailableBookNetworkModelResponse

class AvailableBookRepository(context: Context) {

    private val api: CryptoCurrenciesApiServices = RetrofitHelper.getApiService()
    private val local: CryptocurrencyDataBase = CryptocurrencyDataBase.getDatabase(context)

    suspend fun getAllAvailableBooksFromNetwork(): List<AvailableBookNetworkModelResponse> {
        val response = api.getAvailableBooks()
        return response.result ?: emptyList()
    }

    private suspend fun getAllAvailableBooksFromLocal(): List<AvailableBookEntity> {
        val dao = local.getAvailableBookDao()
        return dao.getAll()
    }

}