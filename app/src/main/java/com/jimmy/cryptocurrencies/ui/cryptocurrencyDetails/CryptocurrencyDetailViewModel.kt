package com.jimmy.cryptocurrencies.ui.cryptocurrencyDetails

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.MutableLiveData
import com.jimmy.cryptocurrencies.common.core.Response
import com.jimmy.cryptocurrencies.common.utils.CryptoLog
import com.jimmy.cryptocurrencies.domain.usecase.GetOrderBook
import com.jimmy.cryptocurrencies.mapper.toUiModel
import com.jimmy.cryptocurrencies.model.AsksBidsValueUiModel
import com.jimmy.cryptocurrencies.model.OrderBookUiModel
import kotlinx.coroutines.Dispatchers

class CryptocurrencyDetailViewModel : ViewModel() {

    private lateinit var getOrderBook: GetOrderBook

    private val _orderBook = MutableLiveData<OrderBookUiModel>()
    val orderBook: LiveData<OrderBookUiModel> = _orderBook

    fun init(context: Context) {
        getOrderBook = GetOrderBook(context)
    }

    fun getDetails(bookSymbol: String) = liveData(Dispatchers.IO) {
        val response = getOrderBook(bookSymbol)
        when (response) {
            is Response.Failure -> CryptoLog.Ui.error(response.message)
            is Response.Success -> _orderBook.postValue(response.data.toUiModel())
        }
        emit(response)
    }

    fun getList(isAsk: Boolean): List<AsksBidsValueUiModel> {
        return when (isAsk) {
            true -> orderBook.value?.asks ?: emptyList()
            false -> orderBook.value?.bids ?: emptyList()
        }
    }
}
