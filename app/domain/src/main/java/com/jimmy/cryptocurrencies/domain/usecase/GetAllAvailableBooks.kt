package com.jimmy.cryptocurrencies.domain.usecase

import com.jimmy.cryptocurrencies.common.core.Response
import com.jimmy.cryptocurrencies.data.repository.AvailableBookRepository
import com.jimmy.cryptocurrencies.domain.mapper.toDomainModel
import com.jimmy.cryptocurrencies.domain.model.availableBook.AvailableBookDomainModel

class GetAllAvailableBooks {

    private val repository = AvailableBookRepository()

    suspend operator fun invoke(): Response<List<AvailableBookDomainModel>> {
        return try {
            val repositoryResponse = repository.getAllAvailableBooksFromNetwork()
            if(repositoryResponse.isEmpty()) throw NullPointerException("list available book is empty")
            val domainResponse = repositoryResponse.toDomainModel()
            Response.Success(domainResponse.toList())
        } catch (ex: Exception) {
            Response.Failure(code = "", message = ex.message?: "")
        }
    }

}