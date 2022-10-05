package com.jimmy.cryptocurrencies.data.network.model.base

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ErrorResponseModel(
    @Expose
    @SerializedName("code")
    val code: String,
    @Expose
    @SerializedName("message")
    val message: String
)
