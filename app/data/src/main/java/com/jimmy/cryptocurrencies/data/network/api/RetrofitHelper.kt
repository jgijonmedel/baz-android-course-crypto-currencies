package com.jimmy.cryptocurrencies.data.network.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object RetrofitHelper {
    private const val baseUrl = CryptoCurrenciesApiPaths.BASE_URL

    private fun getRetrofit(): Retrofit {
        return  Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getApiService(): CryptoCurrenciesApiServices {
        return getRetrofit().create(CryptoCurrenciesApiServices::class.java)
    }
}