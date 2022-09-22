package com.jimmy.cryptocurrencies.domain.mapper

import com.jimmy.cryptocurrencies.data.network.model.response.availableBooks.AvailableBookResponseModel
import com.jimmy.cryptocurrencies.domain.constants.CryptocurrencyDirectory
import com.jimmy.cryptocurrencies.domain.model.availableBook.AvailableBookDomainModel
import com.jimmy.cryptocurrencies.domain.utils.UrlImage

fun AvailableBookResponseModel.toDomainModel(): AvailableBookDomainModel {
    val (symbol, currency) = book.split("_")

    return AvailableBookDomainModel(
        name = CryptocurrencyDirectory.getName(symbol.uppercase()),
        symbol = symbol,
        currency = currency,
        urlIcon = UrlImage.getUrl(symbol),
        minimumPrice = minimumPrice,
        maximumPrice = maximumPrice,
        minimumAmount = minimumAmount,
        maximumAmount = maximumAmount,
        minimumValue = minimumValue,
        maximumValue = maximumValue,
    )
}

fun Collection<AvailableBookResponseModel>.toDomainModel(): Collection<AvailableBookDomainModel> {
    return map { it.toDomainModel() }
}