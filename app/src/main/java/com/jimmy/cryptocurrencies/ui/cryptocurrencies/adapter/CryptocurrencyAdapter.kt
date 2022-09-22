package com.jimmy.cryptocurrencies.ui.cryptocurrencies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.jimmy.cryptocurrencies.R
import com.jimmy.cryptocurrencies.model.AvailableBookUiModel
import com.jimmy.cryptocurrencies.ui.base.BaseDiffUtilCallback
import com.jimmy.cryptocurrencies.ui.base.BaseRecyclerAdapter
import com.jimmy.cryptocurrencies.ui.base.BaseViewHolder

class CryptocurrencyAdapter(
    private val onClick: (AvailableBookUiModel) -> Unit,
) : BaseRecyclerAdapter<AvailableBookUiModel>(DiffUtil) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BaseViewHolder<AvailableBookUiModel> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_cryptocurrency, parent, false)
        return AvailableBookViewHolder(view, onClick)
    }

    object DiffUtil : BaseDiffUtilCallback<AvailableBookUiModel>() {
        override fun areItemsTheSame(
            oldItem: AvailableBookUiModel,
            newItem: AvailableBookUiModel,
        ): Boolean = (oldItem.symbol == newItem.symbol)

        override fun areContentsTheSame(
            oldItem: AvailableBookUiModel,
            newItem: AvailableBookUiModel,
        ): Boolean = (oldItem == newItem)
    }
}