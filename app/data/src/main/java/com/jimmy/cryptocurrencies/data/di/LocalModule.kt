package com.jimmy.cryptocurrencies.data.di

import android.content.Context
import androidx.room.Room
import com.jimmy.cryptocurrencies.data.local.database.CryptocurrencyDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object LocalModule {

    private const val DATABASE_NAME = "cryptocurrency_database"

    @Singleton
    @Provides
    internal fun provideRoom(@ApplicationContext context: Context): CryptocurrencyDataBase {
        return Room.databaseBuilder(context, CryptocurrencyDataBase::class.java, DATABASE_NAME).build()
    }

    @Singleton
    @Provides
    internal fun getOrderBookDao(db: CryptocurrencyDataBase) = db.getOrderBookDao()

    @Singleton
    @Provides
    internal fun getAvailableBookDao(db: CryptocurrencyDataBase) = db.getAvailableBookDao()

    @Singleton
    @Provides
    internal fun getAsksBidsDao(db: CryptocurrencyDataBase) = db.getAsksBidsDao()

    @Singleton
    @Provides
    internal fun getTickerDao(db: CryptocurrencyDataBase) = db.getTickerDao()
}
