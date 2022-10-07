package com.jimmy.cryptocurrencies.data.repository.mapper

import com.jimmy.cryptocurrencies.data.local.entity.TickerEntity
import com.jimmy.cryptocurrencies.data.network.model.response.ticker.TickerResponseModel
import com.jimmy.cryptocurrencies.data.repository.model.TickerDataModel

fun TickerResponseModel.toEntity(): TickerEntity {
    return TickerEntity(
        book = book,
        volume = volume,
        high = high,
        last = last,
        low = low,
        vwap = vwap,
        ask = ask,
        bid = bid,
        createdAt = createdAt,
    )
}

fun TickerEntity.toDataModel(): TickerDataModel {
    return TickerDataModel(
        book = book,
        volume = volume,
        high = high,
        last = last,
        low = low,
        vwap = vwap,
        ask = ask,
        bid = bid,
        createdAt = createdAt
    )
}

fun TickerResponseModel.toDataModel(): TickerDataModel {
    return TickerDataModel(
        book = book,
        volume = volume,
        high = high,
        last = last,
        low = low,
        vwap = vwap,
        ask = ask,
        bid = bid,
        createdAt = createdAt
    )
}