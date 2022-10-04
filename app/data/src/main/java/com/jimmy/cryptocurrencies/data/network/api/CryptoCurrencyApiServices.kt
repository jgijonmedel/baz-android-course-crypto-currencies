package com.jimmy.cryptocurrencies.data.network.api

import com.jimmy.cryptocurrencies.data.network.model.base.BaseResponseModel
import com.jimmy.cryptocurrencies.data.network.model.response.availableBooks.AvailableBookNetworkModelResponse
import com.jimmy.cryptocurrencies.data.network.model.response.orderBook.OrderBookNetworkModelResponse
import com.jimmy.cryptocurrencies.data.network.model.response.ticker.TickerResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

internal interface CryptoCurrencyApiServices {

    @GET(CryptoCurrenciesApiPaths.PATH_AVAILABLE_BOOKS)
    suspend fun getAvailableBooks(): BaseResponseModel<List<AvailableBookNetworkModelResponse>>

    @GET(CryptoCurrenciesApiPaths.PATH_ORDER_BOOKS)
    suspend fun getOrderBook(
        @Query("book") book: String,
        @Query("aggregate") aggregate: Boolean = true
    ): BaseResponseModel<OrderBookNetworkModelResponse>

    @GET(CryptoCurrenciesApiPaths.PATH_TICKER)
    suspend fun getTicker(): BaseResponseModel<TickerResponseModel>

}