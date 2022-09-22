package com.jimmy.cryptocurrencies.ui.cryptocurrencies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jimmy.cryptocurrencies.R
import com.jimmy.cryptocurrencies.databinding.FragmentCryptocurrenciesBinding
import com.jimmy.cryptocurrencies.model.AvailableBookUiModel
import com.jimmy.cryptocurrencies.ui.cryptocurrencies.adapter.CryptocurrencyAdapter
import com.jimmy.cryptocurrencies.utils.extension.finishLoading
import com.jimmy.cryptocurrencies.utils.extension.startLoading

class CryptocurrenciesFragment : Fragment(R.layout.fragment_cryptocurrencies) {

    private lateinit var binding: FragmentCryptocurrenciesBinding
    private val viewModel: CryptocurrenciesViewModel by lazy { CryptocurrenciesViewModel() }
    private lateinit var cryptocurrencyAdapter: CryptocurrencyAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCryptocurrenciesBinding.bind(view)
        setUpRecycler()
        initObservers()
        setUpListeners()
        loadData()
    }

    private fun loadData() {
        if (viewModel.books.value.isNullOrEmpty()){
            activity.startLoading()
            viewModel.getAvailableBooks()
        }
    }

    private fun setUpListeners() {
        binding.apply {
            searchBar.doAfterTextChanged {
                val query = it.toString().trimEnd().trimStart()
                when(query.isBlank()) {
                    true -> setList(viewModel.books.value?: emptyList())
                    false -> setList(viewModel.getFilterList(query))
                }
            }
        }
    }

    private fun initObservers() {
        viewModel.books.observe(viewLifecycleOwner) { setList(it) }
    }

    private fun setList(books: List<AvailableBookUiModel>){
        cryptocurrencyAdapter.setList(books)
        binding.tvCountList.text = getString(R.string.count_list, books.size)
        if(books.isNotEmpty()) {
            activity.finishLoading()
        }
    }

    private fun setUpRecycler() {
        binding.rvCryptocurrency.apply {
            cryptocurrencyAdapter = CryptocurrencyAdapter { cryptocurrencyOnClick(it) }
            this.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
            this.adapter = cryptocurrencyAdapter
        }
    }
    
    private fun cryptocurrencyOnClick(book: AvailableBookUiModel) {
        activity.startLoading()
    }
}