package com.jimmy.cryptocurrencies.ui.cryptocurrencies

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jimmy.cryptocurrencies.common.core.Response
import com.jimmy.cryptocurrencies.domain.usecase.GetAllAvailableBooks
import com.jimmy.cryptocurrencies.mapper.toUiModel
import com.jimmy.cryptocurrencies.model.AvailableBookUiModel
import kotlinx.coroutines.Dispatchers

class CryptocurrenciesViewModel : ViewModel() {

    private lateinit var getAllAvailableBooks: GetAllAvailableBooks
    private val _books: MutableLiveData<List<AvailableBookUiModel>> by lazy {
        MutableLiveData(emptyList())
    }

    val books: LiveData<List<AvailableBookUiModel>> get() = _books

    fun init(context: Context) {
        getAllAvailableBooks = GetAllAvailableBooks(context)
    }

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
