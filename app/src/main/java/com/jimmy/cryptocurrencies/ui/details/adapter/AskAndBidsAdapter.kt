package com.jimmy.cryptocurrencies.ui.details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.jimmy.cryptocurrencies.R
import com.jimmy.cryptocurrencies.model.AsksBidsValueUiModel
import com.jimmy.cryptocurrencies.ui.base.BaseDiffUtilCallback
import com.jimmy.cryptocurrencies.ui.base.BaseRecyclerAdapter
import com.jimmy.cryptocurrencies.ui.base.BaseViewHolder

class AskAndBidsAdapter : BaseRecyclerAdapter<AsksBidsValueUiModel>(DiffUtil) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BaseViewHolder<AsksBidsValueUiModel> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_asks_bids, parent, false)
        return AskAndBidsViewHolder(view)
    }

    object DiffUtil : BaseDiffUtilCallback<AsksBidsValueUiModel>() {
        override fun areItemsTheSame(
            oldItem: AsksBidsValueUiModel,
            newItem: AsksBidsValueUiModel,
        ): Boolean = (oldItem.name == newItem.name)

        override fun areContentsTheSame(
            oldItem: AsksBidsValueUiModel,
            newItem: AsksBidsValueUiModel,
        ): Boolean = (oldItem == newItem)
    }

}