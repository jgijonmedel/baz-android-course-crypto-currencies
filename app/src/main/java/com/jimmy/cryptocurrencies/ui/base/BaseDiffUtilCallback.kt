package com.jimmy.cryptocurrencies.ui.base

import androidx.recyclerview.widget.DiffUtil

abstract class BaseDiffUtilCallback<T : Any> : DiffUtil.ItemCallback<T>() {
    abstract override fun areItemsTheSame(oldItem: T, newItem: T): Boolean
    abstract override fun areContentsTheSame(oldItem: T, newItem: T): Boolean
}
