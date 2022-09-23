package com.jimmy.cryptocurrencies.data.repository

import com.jimmy.cryptocurrencies.data.network.api.CryptoCurrencyApiServices
import com.jimmy.cryptocurrencies.data.network.api.RetrofitClient
import com.jimmy.cryptocurrencies.data.network.model.response.orderBook.OrderBookNetworkModelResponse

class OrderBookRepository {

    private val api: CryptoCurrencyApiServices = RetrofitClient.getApiService()

    suspend fun getOrderBook(bookSymbol: String): OrderBookNetworkModelResponse? {
        val response = api.getOrderBook(bookSymbol)
        return response.result
    }

}