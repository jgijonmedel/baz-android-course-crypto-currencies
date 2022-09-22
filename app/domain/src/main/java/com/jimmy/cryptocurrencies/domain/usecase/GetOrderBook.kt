package com.jimmy.cryptocurrencies.domain.usecase

import com.jimmy.cryptocurrencies.common.core.Response
import com.jimmy.cryptocurrencies.data.repository.OrderBookRepository
import com.jimmy.cryptocurrencies.domain.mapper.toDomainModel
import com.jimmy.cryptocurrencies.domain.model.orderBook.OrderBookDomainModel

class GetOrderBook {

    private val repository = OrderBookRepository()

    suspend operator fun invoke(bookSymbol: String): Response<OrderBookDomainModel> {
        return try {
            val repositoryResponse = repository.getOrderBook(bookSymbol)
                ?: throw NullPointerException("response null")
            val domainResponse = repositoryResponse.toDomainModel(bookSymbol)
            Response.Success(domainResponse)
        } catch (ex: Exception) {
            Response.Failure(code = "", message = ex.message?: "")
        }
    }
}


