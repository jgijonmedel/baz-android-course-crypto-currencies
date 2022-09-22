package com.jimmy.cryptocurrencies.data.network.model.response.orderBook

import com.google.gson.annotations.SerializedName

data class OrderBookNetworkModelResponse(
    @SerializedName("updated_at") val updatedAt: String,
    @SerializedName("sequence") val sequence: String,
    @SerializedName("asks") val asks: List<AsksBidsNetworkModelResponse>,
    @SerializedName("bids") val bids: List<AsksBidsNetworkModelResponse>,
)