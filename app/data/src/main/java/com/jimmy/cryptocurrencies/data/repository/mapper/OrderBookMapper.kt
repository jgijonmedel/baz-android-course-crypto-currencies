package com.jimmy.cryptocurrencies.data.repository.mapper

import com.jimmy.cryptocurrencies.data.network.model.response.orderBook.AsksBidsNetworkModelResponse
import com.jimmy.cryptocurrencies.data.network.model.response.orderBook.OrderBookNetworkModelResponse
import com.jimmy.cryptocurrencies.data.repository.model.AsksBidsDataModel
import com.jimmy.cryptocurrencies.data.repository.model.OrderBookDataModel

internal fun OrderBookNetworkModelResponse.toDataModel(): OrderBookDataModel {
    return OrderBookDataModel(
        updatedAt = updatedAt,
        sequence = sequence,
        asks = asks.toDataModels(),
        bids = bids.toDataModels(),
    )
}

private fun List<AsksBidsNetworkModelResponse>.toDataModels(): List<AsksBidsDataModel> {
    return map { it.toDataModel() }
}

private fun AsksBidsNetworkModelResponse.toDataModel(): AsksBidsDataModel {
    return AsksBidsDataModel(book = book, price = price, amount = amount)
}
