package com.jimmy.cryptocurrencies

import com.jimmy.cryptocurrencies.ui.cryptocurrencies.CryptocurrenciesViewModel
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private val myMock: CryptocurrenciesViewModel = mockk()
    private val myMock2: CryptocurrenciesViewModel = mockk {
        every { getFilterList("") } returns listOf()
    }

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }
}
