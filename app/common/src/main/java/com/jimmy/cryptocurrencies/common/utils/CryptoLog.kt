package com.jimmy.cryptocurrencies.common.utils

import android.util.Log

sealed class CryptoLog(private val tag: TagModule) {

    companion object {
        enum class TagModule(val value: String) {
            Data(value =  "data_"),
            DOMAIN(value =  "domain_"),
            UI( value = "ui_")
        }
    }

    fun error(exception: Exception) {
        Log.e(
            "Weemelp_Error_${tag.value}",
            "message: ${exception.message}\ncause: ${exception.cause?.message}"
        )
    }

    fun error(message: String, exception: Exception) {
        Log.e(
            "Weemelp_Error_${tag.value}",
            "message: $message" + "\nerror_message: ${exception.message}\nerror_cause: ${exception.cause?.message}"
        )
    }

    fun error(message: String) {
        Log.e("Weemelp_Error_${tag.value}", message)
    }

    fun warning(message: String) {
        Log.w("Weemelp_Warning_${tag.value}", message)
    }

    fun success(message: String) {
        Log.d("Weemelp_Success_${tag.value}", message)
    }

    object Ui: CryptoLog(TagModule.UI)
    object Data: CryptoLog(TagModule.Data)
    object Domain: CryptoLog(TagModule.DOMAIN)
}
