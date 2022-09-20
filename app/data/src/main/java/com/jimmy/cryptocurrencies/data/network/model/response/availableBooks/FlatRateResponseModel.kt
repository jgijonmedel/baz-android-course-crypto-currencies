package com.jimmy.cryptocurrencies.data.network.model.response.availableBooks

import com.google.gson.annotations.SerializedName

internal data class FlatRateResponseModel (
    @SerializedName("maker") val maker: String,
    @SerializedName("taker") val taker: String,
)