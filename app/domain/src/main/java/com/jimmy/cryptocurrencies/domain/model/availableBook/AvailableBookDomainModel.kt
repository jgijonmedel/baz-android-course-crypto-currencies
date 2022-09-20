package com.jimmy.cryptocurrencies.domain.model.availableBook

data class AvailableBookDomainModel(
    val name: String,
    val symbol: String,
    val currency: String,
    val urlIcon: String,
    val minimumPrice: String,
    val maximumPrice: String,
    val minimumAmount: String,
    val maximumAmount: String,
    val minimumValue: String,
    val maximumValue: String,
)