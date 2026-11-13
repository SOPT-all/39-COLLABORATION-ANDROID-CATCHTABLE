package com.android.catchtable.presentation.vote.model

data class VoteMenuUiModel(
    val menuId: Long,
    val storeId: Long,
    val menuImageUrl: String?,
    val name: String,
    val price: String,
    val isPriceFrom: Boolean,
)
