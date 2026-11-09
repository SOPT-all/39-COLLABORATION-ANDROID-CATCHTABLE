package com.android.catchtable.presentation.store.model

data class RecommendStoreUiModel(
    val id: Int,
    val thumbnailUrl: String?,
    val name: String,
    val category: String,
    val region: String,
    val rating: String,
)
