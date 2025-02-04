package com.jimmy.cryptocurrencies.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.jimmy.cryptocurrencies.data.local.entity.OrderBookEntity
import com.jimmy.cryptocurrencies.data.local.entity.RelationOrderBookWithAskBids

@Dao
interface OrderBookDao {

    @Transaction
    @Query("SELECT * FROM order_book_table WHERE name = :name")
    suspend fun getByName(name: String): RelationOrderBookWithAskBids

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(orderBook: OrderBookEntity): Long

    @Query("DELETE FROM order_book_table WHERE name = :name")
    suspend fun delete(name: String)
}
