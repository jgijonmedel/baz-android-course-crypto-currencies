package com.jimmy.cryptocurrencies.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "available_book_table")
internal data class AvailableBookEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "book") val book: String,
    @ColumnInfo(name = "minimum_price") val minimumPrice: String,
    @ColumnInfo(name = "maximum_price") val maximumPrice: String,
    @ColumnInfo(name = "minimum_amount") val minimumAmount: String,
    @ColumnInfo(name = "maximum_amount") val maximumAmount: String,
    @ColumnInfo(name = "minimum_value") val minimumValue: String,
    @ColumnInfo(name = "maximum_value") val maximumValue: String,
)