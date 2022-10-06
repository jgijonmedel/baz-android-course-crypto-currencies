package com.jimmy.cryptocurrencies.mapper

import com.jimmy.cryptocurrencies.domain.model.orderBook.AsksBidsValueDomainModel
import com.jimmy.cryptocurrencies.domain.model.orderBook.OrderBookDomainModel
import com.jimmy.cryptocurrencies.domain.model.ticker.TickerDomainModel
import com.jimmy.cryptocurrencies.model.AsksBidsValueUiModel
import com.jimmy.cryptocurrencies.model.DetailsUiModel

private fun AsksBidsValueDomainModel.toUiModel(): AsksBidsValueUiModel {
    val (name, currency) = book.split("_")

    return AsksBidsValueUiModel(
        name = name,
        currency = currency,
        price = price.toDoubleOrNull() ?: 0.0,
        amount = amount.toDoubleOrNull() ?: 0.0
    )
}

private fun Collection<AsksBidsValueDomainModel>.toUiModel(): Collection<AsksBidsValueUiModel> {
    return map { it.toUiModel() }
}

fun createDetailsUiModel(ticker: TickerDomainModel, orderBook: OrderBookDomainModel) : DetailsUiModel {
    return DetailsUiModel(
        urlIcon = orderBook.urlIcon,
        updatedAt = orderBook.updatedAt,
        sequence = orderBook.sequence,
        volume = ticker.volume,
        high = ticker.high,
        last = ticker.last,
        low = ticker.low,
        ask = ticker.ask,
        bid = ticker.bid,
        asks = orderBook.asks.toUiModel().toList(),
        bids = orderBook.bids.toUiModel().toList()
    )
}