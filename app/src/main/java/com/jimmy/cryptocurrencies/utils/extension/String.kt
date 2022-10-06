package com.jimmy.cryptocurrencies.utils.extension

import android.icu.text.NumberFormat
import android.icu.text.SimpleDateFormat
import com.jimmy.cryptocurrencies.data.utils.CryptoLog
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

fun String.toAmountFormat(
    locale: Locale = Locale.getDefault()
): String {
    val price = this.toDoubleOrNull() ?: 0.0
    val dollarFormat = NumberFormat.getCurrencyInstance(locale)
    return dollarFormat.format(price)
}

fun String.toDateFormat(
    stringDateFormat: String = "EEEE dd MMMM yyyy",
    locale: Locale = Locale.getDefault()
): String {
    return try {
        val formatDate = SimpleDateFormat("yyyy-mm-dd", Locale.US)
        val format = SimpleDateFormat(stringDateFormat, locale)
        val date = formatDate.parse(this)
        val dateString = format.format(date)
        dateString.firstUpper()
    } catch (ex: Exception) {
        CryptoLog.Ui.error(exception = ex, message = "Error_format_string_to_ate")
        this
    }
}
