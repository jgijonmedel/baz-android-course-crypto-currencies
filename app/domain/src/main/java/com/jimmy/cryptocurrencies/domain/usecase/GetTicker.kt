package com.jimmy.cryptocurrencies.domain.usecase

import com.jimmy.cryptocurrencies.data.core.Response
import com.jimmy.cryptocurrencies.data.repository.TickerRepository
import com.jimmy.cryptocurrencies.data.utils.CryptoLog
import com.jimmy.cryptocurrencies.domain.mapper.toDomainModel
import com.jimmy.cryptocurrencies.domain.model.ticker.TickerDomainModel
import javax.inject.Inject

class GetTicker @Inject constructor(
    private val repository: TickerRepository
) {
    suspend operator fun invoke(bookSymbol: String): Response<TickerDomainModel> {
        return try {
            val repositoryResponse = repository.get(bookSymbol)
            val domainResponse = repositoryResponse.toDomainModel()
            Response.Success(domainResponse)
        } catch (ex: Exception) {
            CryptoLog.Domain.error(exception = ex, message = "GetTicker")
            Response.Failure(code = "", message = ex.message ?: "")
        }
    }
}
