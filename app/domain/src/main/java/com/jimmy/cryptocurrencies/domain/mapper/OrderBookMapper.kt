package com.jimmy.cryptocurrencies.domain.mapper

import com.jimmy.cryptocurrencies.data.network.model.response.orderBook.AsksBidsNetworkModelResponse
import com.jimmy.cryptocurrencies.data.network.model.response.orderBook.OrderBookNetworkModelResponse
import com.jimmy.cryptocurrencies.domain.model.orderBook.AsksBidsValueDomainModel
import com.jimmy.cryptocurrencies.domain.model.orderBook.OrderBookDomainModel
import com.jimmy.cryptocurrencies.domain.utils.UrlImage

fun OrderBookNetworkModelResponse.toDomainModel(bookSymbol: String): OrderBookDomainModel {
    val symbol = bookSymbol.split("_").first()
    return OrderBookDomainModel(
        urlIcon = UrlImage.getUrl(bookSymbol = symbol, isWithColor = true),
        updatedAt = updatedAt,
        sequence = sequence,
        asks = asks.toDomainModel().toList(),
        bids = bids.toDomainModel().toList(),
    )
}

private fun AsksBidsNetworkModelResponse.toDomainModel(): AsksBidsValueDomainModel {
    return AsksBidsValueDomainModel(
        book = book,
        price = price,
        amount = amount,
    )
}

private fun Collection<AsksBidsNetworkModelResponse>.toDomainModel(): Collection<AsksBidsValueDomainModel> {
    return map { it.toDomainModel() }
}
