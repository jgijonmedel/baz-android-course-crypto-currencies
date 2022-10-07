package com.jimmy.cryptocurrencies.data.network.model.base

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BaseResponseModel<T>(
    @Expose
    @SerializedName("success")
    val success: Boolean,
    @Expose
    @SerializedName("payload")
    val result: T? = null,
    @Expose
    @SerializedName("error")
    val error: ErrorResponseModel? = null
)
