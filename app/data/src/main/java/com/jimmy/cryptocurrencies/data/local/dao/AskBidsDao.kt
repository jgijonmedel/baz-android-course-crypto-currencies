package com.jimmy.cryptocurrencies.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jimmy.cryptocurrencies.data.local.entity.AsksBidsEntity

@Dao
interface AskBidsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(askBids: AsksBidsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(askBidsList: List<AsksBidsEntity>)

    @Query("DELETE FROM ask_bids_table WHERE book = :book AND order_book_id = :OrderBookId")
    suspend fun deleteAll(book: String, OrderBookId: String)
}
