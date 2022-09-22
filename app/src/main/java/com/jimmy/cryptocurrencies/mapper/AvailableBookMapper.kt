package com.jimmy.cryptocurrencies.mapper

import com.jimmy.cryptocurrencies.domain.model.availableBook.AvailableBookDomainModel
import com.jimmy.cryptocurrencies.model.AvailableBookUiModel

fun Collection<AvailableBookDomainModel>.toUiModel(): Collection<AvailableBookUiModel> {
    return map { it.toUiModel() }
}

fun AvailableBookDomainModel.toUiModel(): AvailableBookUiModel {
    return AvailableBookUiModel(
        name = name,
        symbol = symbol,
        currency = currency,
        urlIcon = urlIcon,
        minimumPrice = minimumPrice.toDoubleOrNull()?: 0.0,
        maximumPrice = maximumPrice.toDoubleOrNull()?: 0.0,
        minimumAmount = minimumAmount.toDoubleOrNull()?: 0.0,
        maximumAmount = maximumAmount.toDoubleOrNull()?: 0.0,
        minimumValue = minimumValue.toDoubleOrNull()?: 0.0,
        maximumValue = maximumValue.toDoubleOrNull()?: 0.0,
    )
}
