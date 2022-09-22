package com.jimmy.cryptocurrencies.utils.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.jimmy.cryptocurrencies.R

fun ImageView.loadImage(url: String) {
    Glide
        .with(this.context)
        .load(url)
        .centerCrop()
        .placeholder(R.drawable.view_circle_separator)
        .error(R.drawable.ic_error_icon)
        .into(this)
}