package com.jimmy.cryptocurrencies.data.network.model.response.availableBooks

import com.google.gson.annotations.SerializedName

internal data class StructureResponseModel (
    @SerializedName("volume") val volume: String,
    @SerializedName("maker") val maker: String,
    @SerializedName("taker") val taker: String,
)