package com.jimmy.cryptocurrencies.model

data class AvailableBookUiModel (
    val name: String,
    val symbol: String,
    val currency: String,
    val urlIcon: String,
    val minimumPrice: Double,
    val maximumPrice: Double,
    val minimumAmount: Double,
    val maximumAmount: Double,
    val minimumValue: Double,
    val maximumValue: Double,
)