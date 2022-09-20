package com.jimmy.cryptocurrencies.data.network.model.response.availableBooks

import com.google.gson.annotations.SerializedName

internal data class FeesResponseModel (
    @SerializedName("flat_rate") val flatRate: List<FlatRateResponseModel>,
    @SerializedName("structure") val structure: List<StructureResponseModel>,
)