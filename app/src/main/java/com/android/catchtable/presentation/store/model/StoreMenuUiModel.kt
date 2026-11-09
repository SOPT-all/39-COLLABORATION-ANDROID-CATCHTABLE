package com.android.catchtable.presentation.store.model

data class StoreMenuUiModel(
    val id : Int,
    val storeId: Int,
    val imgUrl: String?,
    val name: String,
    val price: String,
)
