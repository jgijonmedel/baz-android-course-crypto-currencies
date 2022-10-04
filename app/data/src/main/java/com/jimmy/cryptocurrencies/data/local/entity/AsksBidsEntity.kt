package com.jimmy.cryptocurrencies.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "ask_bids_table")
data class AsksBidsEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "order_book_id") val orderBookId: String,
    @ColumnInfo(name = "book") val book: String,
    @ColumnInfo(name = "price") val price: String,
    @ColumnInfo(name = "amount") val amount: String,
    @ColumnInfo(name = "type") val type: Int
)
