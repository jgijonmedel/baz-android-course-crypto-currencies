package com.jimmy.cryptocurrencies.utils.extension

import android.app.Activity
import com.jimmy.cryptocurrencies.ui.MainActivity
import com.jimmy.cryptocurrencies.ui.componet.ErrorDialog

fun Activity?.showError(
    textTitle: String? = null,
    textBody: String? = null,
    textNegativeButton: String? = null,
    textPositiveButton: String? = null,
    onPositiveCation: ((ErrorDialog) -> Unit)? = null
) {
    if (this is MainActivity) {
        this.showErrorDialog(
            textTitle = textTitle,
            textBody = textBody,
            textNegativeButton = textNegativeButton,
            textPositiveButton = textPositiveButton,
            onPositiveCation = onPositiveCation
        )
    }
}

fun Activity?.startLoading() {
    if (this is MainActivity) {
        this.startLoading()
    }
}

fun Activity?.finishLoading() {
    if (this is MainActivity) {
        this.finishLoading()
    }
}
