package com.jimmy.cryptocurrencies.model

data class AvailableBookUiModel(
    val name: String,
    val symbol: String,
    val currency: String,
    val urlIcon: String,
    val maximumPrice: Double,
    val maximumValue: Double
)
