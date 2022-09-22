package com.jimmy.cryptocurrencies.data.network.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object RetrofitHelper {
    private const val baseUrl = CryptoCurrenciesApiPaths.BASE_URL

    private val loggingInterceptor = HttpLoggingInterceptor().also {
        it.level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()
    
    private fun getRetrofit(): Retrofit {
        return  Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getApiService(): CryptoCurrenciesApiServices {
        return getRetrofit().create(CryptoCurrenciesApiServices::class.java)
    }
}