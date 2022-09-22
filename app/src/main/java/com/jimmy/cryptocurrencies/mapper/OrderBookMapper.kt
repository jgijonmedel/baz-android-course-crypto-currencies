package com.jimmy.cryptocurrencies.mapper

import com.jimmy.cryptocurrencies.domain.model.orderBook.AsksBidsValueDomainModel
import com.jimmy.cryptocurrencies.domain.model.orderBook.OrderBookDomainModel
import com.jimmy.cryptocurrencies.model.AsksBidsValueUiModel
import com.jimmy.cryptocurrencies.model.OrderBookUiModel

fun OrderBookDomainModel.toUiModel(): OrderBookUiModel {
    return OrderBookUiModel(
        urlIcon = urlIcon,
        updatedAt = updatedAt,
        sequence = sequence,
        asks = asks.toUiModel().toList(),
        bids = bids.toUiModel().toList(),
    )
}

private fun AsksBidsValueDomainModel.toUiModel(): AsksBidsValueUiModel {
    val (name, currency) = book.split("_")

    return AsksBidsValueUiModel(
        name = name,
        currency = currency,
        price = price.toDoubleOrNull() ?: 0.0,
        amount = amount.toDoubleOrNull() ?: 0.0,
    )
}

private fun Collection<AsksBidsValueDomainModel>.toUiModel(): Collection<AsksBidsValueUiModel> {
    return map { it.toUiModel() }
}
