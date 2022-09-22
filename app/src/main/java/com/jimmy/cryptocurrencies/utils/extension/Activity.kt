package com.jimmy.cryptocurrencies.utils.extension

import android.app.Activity
import com.jimmy.cryptocurrencies.ui.MainActivity

fun Activity?.startLoading() {
    if(this is MainActivity) {
        this.startLoading()
    }
}

fun Activity?.finishLoading() {
    if(this is MainActivity) {
        this.finishLoading()
    }
}