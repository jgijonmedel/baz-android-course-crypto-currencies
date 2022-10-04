package com.jimmy.cryptocurrencies.domain.mapper

import com.jimmy.cryptocurrencies.data.repository.model.AsksBidsDataModel
import com.jimmy.cryptocurrencies.data.repository.model.OrderBookDataModel
import com.jimmy.cryptocurrencies.domain.model.orderBook.AsksBidsValueDomainModel
import com.jimmy.cryptocurrencies.domain.model.orderBook.OrderBookDomainModel
import com.jimmy.cryptocurrencies.domain.utils.UrlImage

fun OrderBookDataModel.toDomainModel(bookSymbol: String): OrderBookDomainModel {
    val symbol = bookSymbol.split("_").first()
    return OrderBookDomainModel(
        urlIcon = UrlImage.getUrl(bookSymbol = symbol, isWithColor = true),
        updatedAt = updatedAt,
        sequence = sequence,
        asks = asks.toDomainModels().toList(),
        bids = bids.toDomainModels().toList()
    )
}

private fun AsksBidsDataModel.toDomainModel(): AsksBidsValueDomainModel {
    return AsksBidsValueDomainModel(
        book = book,
        price = price,
        amount = amount
    )
}

private fun Collection<AsksBidsDataModel>.toDomainModels(): Collection<AsksBidsValueDomainModel> {
    return map { it.toDomainModel() }
}
