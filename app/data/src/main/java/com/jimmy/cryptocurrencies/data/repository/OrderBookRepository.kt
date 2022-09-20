package com.jimmy.cryptocurrencies.data.repository

import com.jimmy.cryptocurrencies.data.network.api.CryptoCurrenciesApiServices
import com.jimmy.cryptocurrencies.data.network.api.RetrofitHelper
import com.jimmy.cryptocurrencies.data.network.model.response.orderBook.OrderBookResponseModel

class OrderBookRepository {

    private val api: CryptoCurrenciesApiServices = RetrofitHelper.getApiService()

    suspend fun getOrderBook(bookSymbol: String): OrderBookResponseModel? {
        val response = api.getOrderBook(bookSymbol)
        return response.result
    }

}