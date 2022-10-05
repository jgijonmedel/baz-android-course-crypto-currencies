package com.jimmy.cryptocurrencies.ui.cryptocurrencies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.jimmy.cryptocurrencies.data.core.Response
import com.jimmy.cryptocurrencies.domain.usecase.GetAllAvailableBooks
import com.jimmy.cryptocurrencies.mapper.toUiModel
import com.jimmy.cryptocurrencies.model.AvailableBookUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers

@HiltViewModel
class CryptocurrenciesViewModel @Inject constructor(
    val getAllAvailableBooks: GetAllAvailableBooks
) : ViewModel() {

    private val _books: MutableLiveData<List<AvailableBookUiModel>> by lazy {
        MutableLiveData(emptyList())
    }

    val books: LiveData<List<AvailableBookUiModel>> get() = _books

    fun getAvailableBooks() = liveData(Dispatchers.IO) {
        val response = getAllAvailableBooks()
        if (response is Response.Success) {
            _books.postValue(response.data.toUiModel().toList())
        }
        emit(response)
    }

    fun getFilterList(query: String): List<AvailableBookUiModel> {
        return books.value?.filter {
            it.name.uppercase().contains(query.uppercase()) || it.symbol.uppercase()
                .contains(query.uppercase()) || it.currency.uppercase().contains(query.uppercase())
        } ?: emptyList()
    }
}
