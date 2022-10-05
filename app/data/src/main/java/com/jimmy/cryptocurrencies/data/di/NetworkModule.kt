package com.jimmy.cryptocurrencies.data.di

import com.jimmy.cryptocurrencies.data.network.api.CryptoCurrenciesApiPaths.BASE_URL
import com.jimmy.cryptocurrencies.data.network.api.CryptoCurrencyApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    private const val TIME_OUT_MINUTES = 1L

    @Singleton @Provides
    internal fun provideRetrofit(): Retrofit {
        val loggingInterceptor = HttpLoggingInterceptor().also {
            it.level = HttpLoggingInterceptor.Level.BODY
        }

        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(TIME_OUT_MINUTES, TimeUnit.MINUTES)
            .connectTimeout(TIME_OUT_MINUTES, TimeUnit.MINUTES)
            .addInterceptor(loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton @Provides
    internal fun provideCryptoCurrencyApiServices(retrofit: Retrofit): CryptoCurrencyApiServices {
        return retrofit.create(CryptoCurrencyApiServices::class.java)
    }
}
