package com.jimmy.cryptocurrencies.domain.mapper

import com.jimmy.cryptocurrencies.data.repository.model.AvailableBookDataModel
import com.jimmy.cryptocurrencies.domain.constants.CryptocurrencyDirectory
import com.jimmy.cryptocurrencies.domain.model.availableBook.AvailableBookDomainModel
import com.jimmy.cryptocurrencies.domain.utils.UrlImage

fun AvailableBookDataModel.toDomainModel(): AvailableBookDomainModel {
    val (symbol, currency) = book.split("_")

    return AvailableBookDomainModel(
        name = CryptocurrencyDirectory.getName(symbol.uppercase()),
        symbol = symbol,
        currency = currency,
        urlIcon = UrlImage.getUrl(symbol),
        maximumPrice = maximumPrice,
        maximumValue = maximumValue
    )
}

fun List<AvailableBookDataModel>.toDomainModel(): List<AvailableBookDomainModel> {
    return map { it.toDomainModel() }
}
