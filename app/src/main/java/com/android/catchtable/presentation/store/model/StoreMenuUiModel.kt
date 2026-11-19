package com.android.catchtable.presentation.store.model

data class StoreMenuUiModel(
    val id: Long,
    val storeId: Long,
    val imgUrl: String?,
    val name: String,
    val price: String,
    val isPriceFrom: Boolean,
)
