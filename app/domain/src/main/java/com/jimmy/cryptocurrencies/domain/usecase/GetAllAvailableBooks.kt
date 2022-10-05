package com.jimmy.cryptocurrencies.domain.usecase

import android.content.Context
import com.jimmy.cryptocurrencies.common.core.Response
import com.jimmy.cryptocurrencies.common.utils.CryptoLog
import com.jimmy.cryptocurrencies.data.repository.AvailableBookRepository
import com.jimmy.cryptocurrencies.domain.mapper.toDomainModel
import com.jimmy.cryptocurrencies.domain.model.availableBook.AvailableBookDomainModel
import javax.inject.Inject

class GetAllAvailableBooks @Inject constructor(
    private val repository: AvailableBookRepository
) {
    suspend operator fun invoke(): Response<List<AvailableBookDomainModel>> {
        return try {
            val repositoryResponse = repository.getAll()
            if(repositoryResponse.isEmpty()) throw NullPointerException("list available book is empty")

            val domainResponse = repositoryResponse.toDomainModel()
            domainResponse.sortedBy(AvailableBookDomainModel::name)

            Response.Success(domainResponse)
        } catch (ex: Exception) {
            CryptoLog.Domain.error(exception = ex, message =  "error")
            Response.Failure(code = "", message = ex.message ?: "")
        }
    }
}
