package com.jimmy.cryptocurrencies.model

data class DetailsUiModel(
    val urlIcon: String,
    val updatedAt: String,
    val sequence: String,
    val volume: String,
    val high: String,
    val last: String,
    val low: String,
    val ask: String,
    val bid: String,
    val asks: List<AsksBidsValueUiModel>,
    val bids: List<AsksBidsValueUiModel>
)

