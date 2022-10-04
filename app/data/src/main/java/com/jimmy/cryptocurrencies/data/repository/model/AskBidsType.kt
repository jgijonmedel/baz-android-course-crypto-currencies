package com.jimmy.cryptocurrencies.data.repository.model

enum class AskBidsType(val type: Int) {
    ASK(type = 0), Bids(type = 1);

    companion object {
        fun getFromType(intType: Int): AskBidsType = values().find { it.type == intType } ?: ASK
    }
}
