package com.jimmy.cryptocurrencies.ui.cryptocurrencies

import com.jimmy.cryptocurrencies.ui.cryptocurrencies.adapter.CryptocurrencyAdapter
import io.mockk.clearAllMocks
import io.mockk.mockk
import org.junit.After
import org.junit.Before
import org.junit.Test

class CryptocurrenciesFragmentTest {

    private fun createFragment() =  CryptocurrenciesFragment()
    private val mockViewModel: CryptocurrenciesViewModel = mockk(relaxed = true)
    private val mockAdapter: CryptocurrencyAdapter = mockk(relaxed = true)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun onViewCreated() {

    }
}