package com.jimmy.cryptocurrencies.domain.model.availableBook

data class AvailableBookDomainModel(
    val name: String,
    val symbol: String,
    val currency: String,
    val urlIcon: String,
    val maximumPrice: String,
    val maximumValue: String
)