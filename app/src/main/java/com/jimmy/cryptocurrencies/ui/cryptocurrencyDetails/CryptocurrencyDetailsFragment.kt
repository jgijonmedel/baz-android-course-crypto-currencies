package com.jimmy.cryptocurrencies.ui.cryptocurrencyDetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jimmy.cryptocurrencies.databinding.FragmentCryptocurrencyDetailsBinding
import com.jimmy.cryptocurrencies.ui.cryptocurrencyDetails.adapter.AskAndBidsAdapter
import com.jimmy.cryptocurrencies.utils.extension.finishLoading
import com.jimmy.cryptocurrencies.utils.extension.toAmountFormat
import com.jimmy.cryptocurrencies.R
import com.jimmy.cryptocurrencies.utils.extension.loadImage

class CryptocurrencyDetailsFragment : Fragment(R.layout.fragment_cryptocurrency_details) {

    private lateinit var binding: FragmentCryptocurrencyDetailsBinding
    private val viewModel = CryptocurrencyDetailViewModel()
    private lateinit var askAndBidsAdapter: AskAndBidsAdapter

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
            val book = it.getString(PARAM_BOOK) ?: ""
            binding.name.text = it.getString(PARAM_NAME) ?: ""
            binding.price.text = it.getDouble(PARAM_PRICE).toAmountFormat()

            if (book.isNotEmpty()) {
                viewModel.getOrderBook(book)
            }
        }
    }

    private fun setUpRecycler() {
        binding.rvAsksBids.apply {
            askAndBidsAdapter = AskAndBidsAdapter()
            this.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
            this.adapter = askAndBidsAdapter
        }
    }

    private fun initObservers() {
        viewModel.orderBook.observe(viewLifecycleOwner) {
            binding.tvUpdateAt.text = it.updatedAt
            binding.tvCryptoImage.loadImage(it.urlIcon)
            val isAsk = binding.rbAsks.isChecked
            setList(isAsk)
            activity.finishLoading()
        }
    }

    private fun setUpListener() {
        binding.rgAsksBids.setOnCheckedChangeListener { _, i ->
            val isAsk = (i == binding.rbAsks.id)
            setList(isAsk)
        }
    }

    private fun setList(isAsk: Boolean) {
        val list = viewModel.getList(isAsk)
        askAndBidsAdapter.setList(list)
    }

    companion object {
        const val PARAM_BOOK = "param_cryptocurrency_book"
        const val PARAM_NAME = "param_cryptocurrency_name"
        const val PARAM_PRICE = "param_cryptocurrency_price"
    }
}