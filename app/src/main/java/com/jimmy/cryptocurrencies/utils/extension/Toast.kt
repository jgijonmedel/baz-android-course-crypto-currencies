package com.jimmy.cryptocurrencies.utils.extension

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.toast(msg: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this.requireContext(), msg, duration).show()
}
