package com.jimmy.cryptocurrencies.domain.mapper

import com.jimmy.cryptocurrencies.data.network.model.response.orderBook.AsksBidsValue
import com.jimmy.cryptocurrencies.data.network.model.response.orderBook.OrderBookResponseModel
import com.jimmy.cryptocurrencies.domain.model.orderBook.AsksBidsValueDomainModel
import com.jimmy.cryptocurrencies.domain.model.orderBook.OrderBookDomainModel
import com.jimmy.cryptocurrencies.domain.utils.UrlImage

fun OrderBookResponseModel.toDomainModel(bookSymbol: String): OrderBookDomainModel {
    return OrderBookDomainModel(
        urlIcon = UrlImage.getUrl(bookSymbol),
        updatedAt = updatedAt,
        sequence = sequence,
        asks = asks.toDomainModel().toList(),
        bids = bids.toDomainModel().toList(),
    )
}

private fun AsksBidsValue.toDomainModel(): AsksBidsValueDomainModel {
    return AsksBidsValueDomainModel(
        book = book,
        price = price,
        amount = amount,
    )
}

private fun Collection<AsksBidsValue>.toDomainModel(): Collection<AsksBidsValueDomainModel> {
    return map { it.toDomainModel() }
}
