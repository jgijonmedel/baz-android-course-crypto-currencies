package com.jimmy.cryptocurrencies.ui.details.adapter

import android.view.View
import com.jimmy.cryptocurrencies.databinding.ItemAsksBidsBinding
import com.jimmy.cryptocurrencies.model.AsksBidsValueUiModel
import com.jimmy.cryptocurrencies.ui.base.BaseViewHolder
import com.jimmy.cryptocurrencies.utils.extension.toAmountFormat

class AskAndBidsViewHolder(
    view: View,
) : BaseViewHolder<AsksBidsValueUiModel>(view) {

    private val binding = ItemAsksBidsBinding.bind(view)

    override fun bind(
        item: AsksBidsValueUiModel,
    ) {
        binding.name.text = item.name.uppercase()
        binding.currency.text = item.currency.uppercase()
        binding.price.text = item.price.toAmountFormat()
        binding.amount.text = item.amount.toString()
    }
}

