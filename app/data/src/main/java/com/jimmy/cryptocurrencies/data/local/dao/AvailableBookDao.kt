package com.jimmy.cryptocurrencies.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jimmy.cryptocurrencies.data.local.entity.AvailableBookEntity

@Dao
internal interface AvailableBookDao {

    @Query("SELECT * FROM available_book_table ORDER BY id DESC")
    suspend fun getAll(): List<AvailableBookEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(books: List<AvailableBookEntity>)

    @Query("DELETE FROM available_book_table")
    suspend fun deleteAll()

}