package com.jimmy.cryptocurrencies.data.network.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

internal object RetrofitClient {
    private const val baseUrl = CryptoCurrenciesApiPaths.BASE_URL
    private const val TIME_OUT_MINUTES = 1L

    private val loggingInterceptor = HttpLoggingInterceptor().also {
        it.level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .readTimeout(TIME_OUT_MINUTES, TimeUnit.MINUTES)
        .connectTimeout(TIME_OUT_MINUTES, TimeUnit.MINUTES)
        .addInterceptor(loggingInterceptor)
        .build()
    
    private fun getRetrofit(): Retrofit {
        return  Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    fun getApiService(): CryptoCurrencyApiServices {
        return getRetrofit().create(CryptoCurrencyApiServices::class.java)
    }
}