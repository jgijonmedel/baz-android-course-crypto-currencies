package com.jimmy.cryptocurrencies.domain.utils

internal object UrlImage {
    private const val REPLACE_CHAR: String = "[book]"
    private const val BASE_PATH: String = "https://raw.githubusercontent.com/spothq/cryptocurrency-icons/master"
    private const val URL_CRYPTOCURRENCY_ICON: String = "$BASE_PATH/32/black/$REPLACE_CHAR.png"
    private const val URL_CRYPTOCURRENCY_IMAGE_COLOR: String = "$BASE_PATH/128/color/$REPLACE_CHAR.png"

    fun getUrl(bookSymbol: String, isWithColor: Boolean = false): String {
        val path = when (isWithColor) {
            true -> URL_CRYPTOCURRENCY_IMAGE_COLOR
            false -> URL_CRYPTOCURRENCY_ICON
        }
        return path.replace(REPLACE_CHAR, bookSymbol)
    }
}
