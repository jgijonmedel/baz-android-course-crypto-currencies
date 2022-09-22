package com.jimmy.cryptocurrencies.ui.cryptocurrencies.adapter

import android.util.Log
import android.view.View
import com.jimmy.cryptocurrencies.databinding.ItemCryptocurrencyBinding
import com.jimmy.cryptocurrencies.model.AvailableBookUiModel
import com.jimmy.cryptocurrencies.ui.base.BaseViewHolder
import com.jimmy.cryptocurrencies.utils.extension.firstUpper
import com.jimmy.cryptocurrencies.utils.extension.loadImage
import com.jimmy.cryptocurrencies.utils.extension.toAmountFormat

class AvailableBookViewHolder(
    view: View,
    private val onClick: (AvailableBookUiModel) -> Unit,
) : BaseViewHolder<AvailableBookUiModel>(view) {

    private val binding = ItemCryptocurrencyBinding.bind(view)

    override fun bind(
        item: AvailableBookUiModel,
    ) {
        Log.w("AvailableBookUiModel", "${item.name} (${item.maximumPrice})")
        binding.name.text = item.name.firstUpper()
        binding.symbol.text = item.symbol.uppercase()
        binding.currency.text = item.currency.uppercase()
        binding.price.text = item.maximumPrice.toAmountFormat()
        binding.percentageDifference.text = item.minimumValue.toString()
        binding.image.loadImage(item.urlIcon)
        binding.card.setOnClickListener { onClick(item) }
    }
}