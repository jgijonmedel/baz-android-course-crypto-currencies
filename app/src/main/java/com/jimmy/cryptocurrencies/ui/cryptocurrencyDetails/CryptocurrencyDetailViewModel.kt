package com.jimmy.cryptocurrencies.ui.cryptocurrencyDetails

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jimmy.cryptocurrencies.common.core.Response
import com.jimmy.cryptocurrencies.domain.usecase.GetOrderBook
import com.jimmy.cryptocurrencies.mapper.toUiModel
import com.jimmy.cryptocurrencies.model.AsksBidsValueUiModel
import com.jimmy.cryptocurrencies.model.OrderBookUiModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CryptocurrencyDetailViewModel: ViewModel() {

    private val _orderBook: MutableLiveData<OrderBookUiModel> by lazy {
        MutableLiveData()
    }

    val orderBook: LiveData<OrderBookUiModel> get() = _orderBook

    fun getOrderBook(bookSymbol: String) {
        val getOrderBook = GetOrderBook()
        viewModelScope.launch(Dispatchers.IO) {
            when(val response = getOrderBook(bookSymbol)) {
                is Response.Failure -> { Log.e("error_getOrderBook", "error: ${response.message}") }
                is Response.Success -> _orderBook.postValue(response.data.toUiModel())
            }
        }
    }

    fun getList(isAsk: Boolean): List<AsksBidsValueUiModel> {
        return when(isAsk) {
            true -> orderBook.value?.asks ?: emptyList()
            false -> orderBook.value?.bids ?: emptyList()
        }
    }

}