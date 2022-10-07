package com.jimmy.cryptocurrencies.data.core

sealed class Response<out T> {
    data class Success<out T>(val data: T) : Response<T>()
    data class Failure(val code: String, val message: String) : Response<Nothing>()
}
