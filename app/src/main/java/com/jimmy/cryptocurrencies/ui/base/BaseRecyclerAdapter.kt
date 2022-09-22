package com.jimmy.cryptocurrencies.ui.base

import androidx.recyclerview.widget.ListAdapter

abstract class BaseRecyclerAdapter<T : Any>(
    callback: BaseDiffUtilCallback<T>,
) : ListAdapter<T, BaseViewHolder<T>>(callback) {

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    fun setList(list: List<T>) {
        submitList(list)
    }

}