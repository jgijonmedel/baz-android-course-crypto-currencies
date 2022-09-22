package com.jimmy.cryptocurrencies.model

data class OrderBookUiModel (
    val urlIcon: String,
    val updatedAt: String,
    val sequence: String,
    val asks: List<AsksBidsValueUiModel>,
    val bids: List<AsksBidsValueUiModel>,
)
