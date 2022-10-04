package com.jimmy.cryptocurrencies.data.repository.mapper

import com.jimmy.cryptocurrencies.data.local.entity.AsksBidsEntity
import com.jimmy.cryptocurrencies.data.local.entity.OrderBookEntity
import com.jimmy.cryptocurrencies.data.local.entity.RelationOrderBookWithAskBids
import com.jimmy.cryptocurrencies.data.network.model.response.orderBook.AsksBidsNetworkModelResponse
import com.jimmy.cryptocurrencies.data.network.model.response.orderBook.OrderBookNetworkModelResponse
import com.jimmy.cryptocurrencies.data.repository.model.AskBidsType
import com.jimmy.cryptocurrencies.data.repository.model.AsksBidsDataModel
import com.jimmy.cryptocurrencies.data.repository.model.OrderBookDataModel

internal fun OrderBookNetworkModelResponse.toDataModel(): OrderBookDataModel {
    return OrderBookDataModel(
        updatedAt = updatedAt,
        sequence = sequence,
        asks = asks.toDataModels(),
        bids = bids.toDataModels()
    )
}

private fun List<AsksBidsNetworkModelResponse>.toDataModels(): List<AsksBidsDataModel> {
    return map { it.toDataModel() }
}

private fun AsksBidsNetworkModelResponse.toDataModel(): AsksBidsDataModel {
    return AsksBidsDataModel(book = book, price = price, amount = amount)
}

internal fun OrderBookNetworkModelResponse.toEntity(bookSymbol: String): OrderBookEntity {
    return OrderBookEntity(
        name = bookSymbol,
        updatedAt = updatedAt,
        sequence = sequence
    )
}

internal fun List<AsksBidsNetworkModelResponse>.toEntities(
    orderBookId: String,
    type: AskBidsType
): List<AsksBidsEntity> {
    return map { it.toEntities(orderBookId, type.type) }
}

private fun AsksBidsNetworkModelResponse.toEntities(
    orderBookId: String,
    type: Int
): AsksBidsEntity {
    return AsksBidsEntity(
        orderBookId = orderBookId,
        book = book,
        price = price,
        amount = amount,
        type = type
    )
}

internal fun RelationOrderBookWithAskBids.toDataModel(): OrderBookDataModel {
    return OrderBookDataModel(
        updatedAt = orderBook.updatedAt,
        sequence = orderBook.sequence,
        asks = askAnBids.toDataModels(AskBidsType.ASK),
        bids = askAnBids.toDataModels(AskBidsType.Bids)
    )
}

private fun List<AsksBidsEntity>.toDataModels(
    type: AskBidsType
): List<AsksBidsDataModel> {
    return filter { it.type == type.type }.map { it.toDataModel() }
}

private fun AsksBidsEntity.toDataModel(): AsksBidsDataModel {
    return AsksBidsDataModel(book = book, price = price, amount = amount)
}
