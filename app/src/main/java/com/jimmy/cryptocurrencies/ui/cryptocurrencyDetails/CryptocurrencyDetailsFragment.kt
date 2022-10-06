package com.jimmy.cryptocurrencies.ui.cryptocurrencyDetails

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jimmy.cryptocurrencies.R
import com.jimmy.cryptocurrencies.data.core.Response
import com.jimmy.cryptocurrencies.data.utils.CryptoLog
import com.jimmy.cryptocurrencies.databinding.FragmentCryptocurrencyDetailsBinding
import com.jimmy.cryptocurrencies.ui.cryptocurrencyDetails.adapter.AskAndBidsAdapter
import com.jimmy.cryptocurrencies.utils.extension.finishLoading
import com.jimmy.cryptocurrencies.utils.extension.loadImage
import com.jimmy.cryptocurrencies.utils.extension.showError
import com.jimmy.cryptocurrencies.utils.extension.toAmountFormat
import com.jimmy.cryptocurrencies.utils.extension.toDateFormat
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CryptocurrencyDetailsFragment : Fragment(R.layout.fragment_cryptocurrency_details) {

    private lateinit var binding: FragmentCryptocurrencyDetailsBinding
    private val viewModel: CryptocurrencyDetailViewModel by viewModels()
    private lateinit var askAndBidsAdapter: AskAndBidsAdapter
    private var firstLoad = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCryptocurrencyDetailsBinding.bind(view)
        setUpRecycler()
        setUpListener()
        initObservers()
        setData()
    }

    private fun setData() {
        arguments?.let {
            binding.name.text = it.getString(PARAM_NAME) ?: ""
            loadData()
        }
    }

    private fun getBook(): String = arguments?.getString(PARAM_BOOK) ?: ""

    private fun setUpRecycler() {
        binding.rvAsksBids.apply {
            askAndBidsAdapter = AskAndBidsAdapter()
            this.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
            this.adapter = askAndBidsAdapter
        }
    }

    private fun initObservers() {
        viewModel.details.observe(viewLifecycleOwner) {
            val currency = getBook().split("_").last().uppercase()
            binding.ivCryptoImage.loadImage(it.urlIcon)
            binding.price.text = getString(R.string.label_price_with_currency, it.last.toAmountFormat(), currency)
            binding.tvUpdateAt.text = getString(R.string.label_last_update, it.updatedAt.toDateFormat())
            binding.volume.text = getString(R.string.label_volume, it.volume)
            binding.high.text = it.high.toAmountFormat().plus(" $currency")
            binding.low.text = it.low.toAmountFormat().plus(" $currency")
            binding.ask.text = it.ask.toAmountFormat().plus(" $currency")
            binding.bid.text = it.bid.toAmountFormat().plus(" $currency")
            val isAsk = binding.rbAsks.isChecked
            setList(isAsk = isAsk)
            activity.finishLoading()
        }
    }

    private fun setUpListener() {
        binding.rgAsksBids.setOnCheckedChangeListener { _, i ->
            val isAsk = (i == binding.rbAsks.id)
            setList(isAsk = isAsk)
        }
    }

    private fun loadData() {
        val book = getBook()
        if (book.isNotEmpty()) {
            viewModel.getDetails(book).observe(viewLifecycleOwner) { response ->
                when (response) {
                    is Response.Failure -> showErrorDialog(response.message)
                    is Response.Success -> firstLoad = false
                }
            }
        }
    }

    private fun setList(
        isAsk: Boolean,
        btnReloadIsVisible: Boolean = false
    ) {
        val list = viewModel.getList(isAsk)
        val thereAreElements = list.isEmpty()
        askAndBidsAdapter.setList(list)
        binding.messageNotFound.btnReload.isVisible = (btnReloadIsVisible && thereAreElements)
        binding.messageNotFound.content.isVisible = if (firstLoad) false else thereAreElements
        binding.messageNotFound.btnReload.setOnClickListener { loadData() }
        binding.rvAsksBids.isVisible = thereAreElements.not()
        if (!thereAreElements) {
            activity.finishLoading()
        }
    }

    private fun showErrorDialog(message: String) {
        activity.finishLoading()
        firstLoad = false
        val isAsk = binding.rbAsks.isChecked
        setList(isAsk = isAsk, btnReloadIsVisible = true)
        activity.showError(
            textBody = message,
            textPositiveButton = getString(R.string.label_retry),
            onPositiveCation = { errorDialog ->
                errorDialog.dismiss()
                CryptoLog.Ui.success("retry load data")
                loadData()
            }
        )
    }

    companion object {
        const val PARAM_BOOK = "param_cryptocurrency_book"
        const val PARAM_NAME = "param_cryptocurrency_name"
    }
}
