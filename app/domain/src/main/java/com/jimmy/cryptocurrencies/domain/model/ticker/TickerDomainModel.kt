package com.jimmy.cryptocurrencies.domain.model.ticker

data class TickerDomainModel(
    val book: String,
    val volume: String,
    val high: String,
    val last: String,
    val low: String,
    val vwap: String,
    val ask: String,
    val bid: String,
)