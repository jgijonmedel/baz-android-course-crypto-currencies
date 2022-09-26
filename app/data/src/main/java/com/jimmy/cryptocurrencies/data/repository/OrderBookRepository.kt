package com.jimmy.cryptocurrencies.data.repository

import com.jimmy.cryptocurrencies.data.network.api.CryptoCurrencyApiServices
import com.jimmy.cryptocurrencies.data.network.api.RetrofitClient
import com.jimmy.cryptocurrencies.data.repository.mapper.toDataModel
import com.jimmy.cryptocurrencies.data.repository.model.OrderBookDataModel

class OrderBookRepository {

    private val api: CryptoCurrencyApiServices = RetrofitClient.getApiService()

    suspend fun getOrderBook(bookSymbol: String): OrderBookDataModel {
        val response = api.getOrderBook(bookSymbol)
        val orderBook = response.result ?: throw NullPointerException("result is null")
        return orderBook.toDataModel()
    }

}