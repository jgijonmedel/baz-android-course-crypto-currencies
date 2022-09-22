package com.jimmy.cryptocurrencies.ui.cryptocurrencies

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jimmy.cryptocurrencies.common.core.Response
import com.jimmy.cryptocurrencies.domain.usecase.GetAllAvailableBooks
import com.jimmy.cryptocurrencies.mapper.toUiModel
import com.jimmy.cryptocurrencies.model.AvailableBookUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CryptocurrenciesViewModel: ViewModel() {

    private lateinit var getAllAvailableBooks: GetAllAvailableBooks
    private val _books: MutableLiveData<List<AvailableBookUiModel>> by lazy {
        MutableLiveData(emptyList())
    }

    val books: LiveData<List<AvailableBookUiModel>> get() = _books

    fun init(context: Context) {
        getAllAvailableBooks = GetAllAvailableBooks(context)

    }

    fun getAvailableBooks() {
        viewModelScope.launch(Dispatchers.IO) {
            when(val response = getAllAvailableBooks()) {
                is Response.Failure -> {}
                is Response.Success -> {
                    _books.postValue(response.data.toUiModel().toList())
                }
            }
        }
    }

    fun getFilterList(query: String): List<AvailableBookUiModel> {
        return books.value?.filter {
            it.name.uppercase().contains(query.uppercase()) ||
                    it.symbol.uppercase().contains(query.uppercase()) ||
                    it.currency.uppercase().contains(query.uppercase())
        } ?: emptyList()
    }
}