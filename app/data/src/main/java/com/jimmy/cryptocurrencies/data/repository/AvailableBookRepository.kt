package com.jimmy.cryptocurrencies.data.repository

import com.jimmy.cryptocurrencies.data.network.api.CryptoCurrenciesApiServices
import com.jimmy.cryptocurrencies.data.network.api.RetrofitHelper
import com.jimmy.cryptocurrencies.data.network.model.response.availableBooks.AvailableBookResponseModel

class AvailableBookRepository {

    private val api: CryptoCurrenciesApiServices = RetrofitHelper.getApiService()

    suspend fun getAllAvailableBooksFromNetwork(): List<AvailableBookResponseModel> {
        val response = api.getAvailableBooks()
        return response.result ?: emptyList()
    }

}