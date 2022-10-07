package com.jimmy.cryptocurrencies.domain.mapper

import com.jimmy.cryptocurrencies.data.repository.model.TickerDataModel
import com.jimmy.cryptocurrencies.domain.model.ticker.TickerDomainModel

fun TickerDataModel.toDomainModel(): TickerDomainModel {
    return TickerDomainModel(
        book = book,
        volume = volume,
        high = high,
        last = last,
        low = low,
        vwap = vwap,
        ask = ask,
        bid = bid,
    )
}
