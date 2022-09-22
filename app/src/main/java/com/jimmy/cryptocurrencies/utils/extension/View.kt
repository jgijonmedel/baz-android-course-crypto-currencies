package com.jimmy.cryptocurrencies.utils.extension

import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.annotation.AnimRes
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

fun View.initAnimation(@AnimRes idAnimation: Int) {
    val anim: Animation = AnimationUtils.loadAnimation(this.context, idAnimation)
    this.startAnimation(anim)
}