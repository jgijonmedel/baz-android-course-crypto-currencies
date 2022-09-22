package com.jimmy.cryptocurrencies.data.repository

import com.jimmy.cryptocurrencies.data.network.api.CryptoCurrenciesApiServices
import com.jimmy.cryptocurrencies.data.network.api.RetrofitHelper
import com.jimmy.cryptocurrencies.data.network.model.response.orderBook.OrderBookNetworkModelResponse

class OrderBookRepository {

    private val api: CryptoCurrenciesApiServices = RetrofitHelper.getApiService()

    suspend fun getOrderBook(bookSymbol: String): OrderBookNetworkModelResponse? {
        val response = api.getOrderBook(bookSymbol)
        return response.result
    }

}