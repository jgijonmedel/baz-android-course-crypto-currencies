package com.jimmy.cryptocurrencies.data.network.model.response.orderBook

import com.google.gson.annotations.SerializedName

data class OrderBookResponseModel(
    @SerializedName("updated_at") val updatedAt: String,
    @SerializedName("sequence") val sequence: String,
    @SerializedName("asks") val asks: List<AsksBidsValue>,
    @SerializedName("bids") val bids: List<AsksBidsValue>,
)