package com.jimmy.cryptocurrencies.data.network.api

import com.jimmy.cryptocurrencies.data.network.model.base.BaseResponseModel
import com.jimmy.cryptocurrencies.data.network.model.response.availableBooks.AvailableBookResponseModel
import com.jimmy.cryptocurrencies.data.network.model.response.orderBook.OrderBookResponseModel
import com.jimmy.cryptocurrencies.data.network.model.response.ticker.TickerResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

internal interface CryptoCurrenciesApiServices {

    @GET(CryptoCurrenciesApiPaths.PATH_AVAILABLE_BOOKS)
    suspend fun getAvailableBooks(): BaseResponseModel<List<AvailableBookResponseModel>>

    @GET(CryptoCurrenciesApiPaths.PATH_ORDER_BOOKS)
    suspend fun getOrderBook(
        @Query("book") book: String,
    ): BaseResponseModel<OrderBookResponseModel>

    @GET(CryptoCurrenciesApiPaths.PATH_TICKER)
    suspend fun getTicker(): BaseResponseModel<TickerResponseModel>

}