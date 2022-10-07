package com.jimmy.cryptocurrencies.data.repository.model

import com.google.gson.annotations.SerializedName

data class TickerDataModel (
    val book: String,
    val volume: String,
    val high: String,
    val last: String,
    val low: String,
    val vwap: String,
    val ask: String,
    val bid: String,
    val createdAt: String
)