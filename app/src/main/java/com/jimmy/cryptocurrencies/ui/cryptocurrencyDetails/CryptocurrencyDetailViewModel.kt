package com.jimmy.cryptocurrencies.ui.cryptocurrencyDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.jimmy.cryptocurrencies.data.core.Response
import com.jimmy.cryptocurrencies.data.utils.CryptoLog
import com.jimmy.cryptocurrencies.domain.model.orderBook.OrderBookDomainModel
import com.jimmy.cryptocurrencies.domain.model.ticker.TickerDomainModel
import com.jimmy.cryptocurrencies.domain.usecase.GetOrderBook
import com.jimmy.cryptocurrencies.domain.usecase.GetTicker
import com.jimmy.cryptocurrencies.mapper.createDetailsUiModel
import com.jimmy.cryptocurrencies.model.AsksBidsValueUiModel
import com.jimmy.cryptocurrencies.model.DetailsUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

@HiltViewModel
class CryptocurrencyDetailViewModel @Inject constructor(
    private val getOrderBook: GetOrderBook,
    private val getTicker: GetTicker
) : ViewModel() {

    private val _details = MutableLiveData<DetailsUiModel>()
    val details: LiveData<DetailsUiModel> = _details

    fun getDetails(bookSymbol: String) = liveData(Dispatchers.IO) {
        coroutineScope {
            val responseOrder = async { getOrderBook(bookSymbol) }.await()
            val responseTicker = async { getTicker(bookSymbol) }.await()

            val responseOrderIsCorrect = responseOrder is Response.Success
            val responseTickerIsCorrect = responseTicker is Response.Success

            when (responseOrderIsCorrect && responseTickerIsCorrect) {
                true -> {
                    val details = createDetailsUiModel(
                        (responseTicker as Response.Success<TickerDomainModel>).data,
                        (responseOrder as Response.Success<OrderBookDomainModel>).data
                    )
                    _details.postValue(details)
                    emit(Response.Success(details))
                }
                false -> {
                    CryptoLog.Ui.error(
                        message = "order: ${(responseOrder as Response.Failure).message}\n" +
                                "ticker: ${(responseTicker as Response.Failure).message}"
                    )
                    emit(Response.Failure(
                        code ="",
                        message = "order: ${responseOrder.message}\n" +
                                "ticker: ${responseTicker.message}"
                    ))
                }
            }
        }
    }

    fun getList(isAsk: Boolean): List<AsksBidsValueUiModel> {
        return when (isAsk) {
            true -> details.value?.asks ?: emptyList()
            false -> details.value?.bids ?: emptyList()
        }
    }
}
