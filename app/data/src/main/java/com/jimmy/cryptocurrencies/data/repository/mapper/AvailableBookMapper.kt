package com.jimmy.cryptocurrencies.data.repository.mapper

import com.jimmy.cryptocurrencies.data.local.entity.AvailableBookEntity
import com.jimmy.cryptocurrencies.data.network.model.response.availableBooks.AvailableBookNetworkModelResponse
import com.jimmy.cryptocurrencies.data.repository.model.AvailableBookDataModel

internal fun AvailableBookEntity.toDataModel(): AvailableBookDataModel {
    return AvailableBookDataModel(
        book = book,
        maximumPrice = maximumPrice,
        maximumValue = maximumValue
    )
}

@JvmName("AvailableBookEntityToDataModels")
internal fun Collection<AvailableBookEntity>.toDataModels(): List<AvailableBookDataModel> {
    return map { it.toDataModel() }
}

internal fun AvailableBookNetworkModelResponse.toDataModel(): AvailableBookDataModel {
    return AvailableBookDataModel(
        book = book,
        maximumPrice = maximumPrice,
        maximumValue = maximumValue
    )
}

@JvmName("AvailableBookNetworkModelResponseToDataModels")
internal fun Collection<AvailableBookNetworkModelResponse>.toDataModels(): List<AvailableBookDataModel> {
    return map { it.toDataModel() }
}

internal fun AvailableBookNetworkModelResponse.toEntity(): AvailableBookEntity {
    return AvailableBookEntity(
        book = book,
        minimumPrice = minimumPrice,
        maximumPrice = maximumPrice,
        minimumAmount = minimumAmount,
        maximumAmount = maximumAmount,
        minimumValue = minimumValue,
        maximumValue = maximumValue,
    )
}

@JvmName("AvailableBookNetworkModelResponseToEntities")
internal fun Collection<AvailableBookNetworkModelResponse>.toEntities(): List<AvailableBookEntity> {
    return map { it.toEntity() }
}