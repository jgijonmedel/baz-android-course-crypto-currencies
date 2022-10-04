package com.jimmy.cryptocurrencies.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class RelationOrderBookWithAskBids(
    @Embedded val orderBook: OrderBookEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "order_book_id"
    )
    val askAnBids: List<AsksBidsEntity>
)
