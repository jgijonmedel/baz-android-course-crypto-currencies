package com.jimmy.cryptocurrencies.ui.cryptocurrencies

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jimmy.cryptocurrencies.R
import com.jimmy.cryptocurrencies.data.core.Response
import com.jimmy.cryptocurrencies.data.utils.CryptoLog
import com.jimmy.cryptocurrencies.databinding.FragmentCryptocurrenciesBinding
import com.jimmy.cryptocurrencies.model.AvailableBookUiModel
import com.jimmy.cryptocurrencies.ui.cryptocurrencies.adapter.CryptocurrencyAdapter
import com.jimmy.cryptocurrencies.ui.cryptocurrencyDetails.CryptocurrencyDetailsFragment
import com.jimmy.cryptocurrencies.utils.extension.finishLoading
import com.jimmy.cryptocurrencies.utils.extension.showError
import com.jimmy.cryptocurrencies.utils.extension.startLoading
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CryptocurrenciesFragment : Fragment(R.layout.fragment_cryptocurrencies) {

    private lateinit var binding: FragmentCryptocurrenciesBinding
    private val viewModel: CryptocurrenciesViewModel by viewModels()
    private lateinit var cryptocurrencyAdapter: CryptocurrencyAdapter
    private var firstLoad = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCryptocurrenciesBinding.bind(view)
        setUpRecycler()
        initObservers()
        setUpListeners()
        loadData()
    }

    private fun loadData() {
        if (viewModel.books.value.isNullOrEmpty()) {
            activity.startLoading()
            viewModel.getAvailableBooks().observe(viewLifecycleOwner) { response ->
                when (response) {
                    is Response.Failure -> showErrorDialog(response.message)
                    is Response.Success -> firstLoad = false
                }
            }
        }
    }

    private fun showErrorDialog(message: String) {
        activity.finishLoading()
        firstLoad = false
        setList(btnReloadIsVisible = true)
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

    private fun setUpListeners() {
        binding.apply {
            searchBar.doAfterTextChanged {
                val query = it.toString().trimEnd().trimStart()
                when (query.isBlank()) {
                    true -> setList(viewModel.books.value ?: emptyList())
                    false -> setList(viewModel.getFilterList(query))
                }
            }
        }
    }

    private fun initObservers() {
        viewModel.books.observe(viewLifecycleOwner) {
            CryptoLog.Ui.success("Observer")
            setList(it)
        }
    }

    private fun setList(
        books: List<AvailableBookUiModel> = emptyList(),
        btnReloadIsVisible: Boolean = false
    ) {
        val thereAreElements = books.isEmpty()
        cryptocurrencyAdapter.setList(books)
        binding.tvCountList.text = getString(R.string.count_list, books.size)
        binding.messageNotFound.btnReload.isVisible = (btnReloadIsVisible && thereAreElements)
        binding.messageNotFound.content.isVisible = if (firstLoad) false else thereAreElements
        binding.rvCryptocurrency.isVisible = thereAreElements.not()
        if (!thereAreElements) {
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
        findNavController().navigate(
            R.id.action_list_to_details,
            bundleOf(
                CryptocurrencyDetailsFragment.PARAM_BOOK to "${book.symbol}_${book.currency}",
                CryptocurrencyDetailsFragment.PARAM_NAME to book.name,
            )
        )
    }
}
