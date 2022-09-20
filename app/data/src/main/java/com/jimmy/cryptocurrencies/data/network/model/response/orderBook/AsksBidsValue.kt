package com.jimmy.cryptocurrencies.data.network.model.response.orderBook

import com.google.gson.annotations.SerializedName

data class AsksBidsValue(
    @SerializedName("book") val book: String,
    @SerializedName("price") val price: String,
    @SerializedName("amount") val amount: String,
)