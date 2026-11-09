package com.android.catchtable.presentation.vote.model

data class VoteMenuUiModel(
    val id: Int,
    val storeId: Int,
    val imgUrl: String?,
    val name: String,
    val price: String,
    val isPriceFrom: Boolean,
)
