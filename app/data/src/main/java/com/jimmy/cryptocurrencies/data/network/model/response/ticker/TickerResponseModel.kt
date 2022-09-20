package com.jimmy.cryptocurrencies.data.network.model.response.ticker

import com.google.gson.annotations.SerializedName

data class TickerResponseModel(
    @SerializedName("book") val book: String,
    @SerializedName("volume") val volume: String,
    @SerializedName("high") val high: String,
    @SerializedName("last") val last: String,
    @SerializedName("low") val low: String,
    @SerializedName("vwap") val vwap: String,
    @SerializedName("ask") val ask: String,
    @SerializedName("bid") val bid: String,
    @SerializedName("created_at") val createdAt: String,
)