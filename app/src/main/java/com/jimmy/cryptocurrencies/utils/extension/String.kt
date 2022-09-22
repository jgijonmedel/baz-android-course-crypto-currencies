package com.jimmy.cryptocurrencies.utils.extension

import android.icu.text.NumberFormat
import java.util.Locale

fun String.firstUpper(): String {
    return trim().replaceFirstChar { chart ->
        when (chart.isLowerCase()) {
            true -> chart.titlecase(Locale.getDefault())
            false -> chart.toString()
        }
    }
}

fun Double.toAmountFormat(
    locale: Locale = Locale.getDefault()
): String {
    val dollarFormat = NumberFormat.getCurrencyInstance(locale)
    return dollarFormat.format(this)
}