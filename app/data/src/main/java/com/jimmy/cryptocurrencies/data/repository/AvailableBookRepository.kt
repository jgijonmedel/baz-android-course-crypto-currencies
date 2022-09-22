package com.jimmy.cryptocurrencies.data.repository

import com.jimmy.cryptocurrencies.data.network.api.CryptoCurrenciesApiServices
import com.jimmy.cryptocurrencies.data.network.api.RetrofitHelper
import com.jimmy.cryptocurrencies.data.network.model.response.availableBooks.AvailableBookNetworkModelResponse

class AvailableBookRepository {

    private val api: CryptoCurrenciesApiServices = RetrofitHelper.getApiService()

    suspend fun getAllAvailableBooksFromNetwork(): List<AvailableBookNetworkModelResponse> {
        val response = api.getAvailableBooks()
        return response.result ?: emptyList()
    }

}