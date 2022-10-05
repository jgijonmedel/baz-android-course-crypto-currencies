package com.jimmy.cryptocurrencies.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jimmy.cryptocurrencies.data.local.dao.AskBidsDao
import com.jimmy.cryptocurrencies.data.local.dao.AvailableBookDao
import com.jimmy.cryptocurrencies.data.local.dao.OrderBookDao
import com.jimmy.cryptocurrencies.data.local.entity.AsksBidsEntity
import com.jimmy.cryptocurrencies.data.local.entity.AvailableBookEntity
import com.jimmy.cryptocurrencies.data.local.entity.OrderBookEntity

@Database(
    entities = [AvailableBookEntity::class, OrderBookEntity::class, AsksBidsEntity::class],
    version = 1,
    exportSchema = false
)
abstract class CryptocurrencyDataBase : RoomDatabase() {
    internal abstract fun getAvailableBookDao(): AvailableBookDao
    internal abstract fun getOrderBookDao(): OrderBookDao
    internal abstract fun getAsksBidsDao(): AskBidsDao
}
