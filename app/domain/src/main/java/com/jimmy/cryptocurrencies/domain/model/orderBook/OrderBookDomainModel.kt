package com.jimmy.cryptocurrencies.domain.model.orderBook

data class OrderBookDomainModel(
    val urlIcon: String,
    val updatedAt: String,
    val sequence: String,
    val asks: List<AsksBidsValueDomainModel>,
    val bids: List<AsksBidsValueDomainModel>,
)
