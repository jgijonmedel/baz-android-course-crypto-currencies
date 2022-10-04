package com.jimmy.cryptocurrencies.data.repository.model

data class OrderBookDataModel(
    val updatedAt: String,
    val sequence: String,
    val asks: List<AsksBidsDataModel>,
    val bids: List<AsksBidsDataModel>
)
