package com.jimmy.cryptocurrencies.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jimmy.cryptocurrencies.data.local.entity.TickerEntity

@Dao
interface TickerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(ticker: TickerEntity)

    @Query("DELETE FROM ticker_table WHERE book = :book")
    suspend fun delete(book: String)

    @Query("SELECT * FROM ticker_table WHERE book = :book")
    suspend fun getByName(book: String): TickerEntity
}
