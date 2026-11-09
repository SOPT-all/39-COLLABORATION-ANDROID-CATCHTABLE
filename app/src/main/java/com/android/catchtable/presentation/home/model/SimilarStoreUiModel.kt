package com.android.catchtable.presentation.home.model

data class SimilarStoreUiModel(
    val id: Int,
    val thumbnailUrl: String?,
    val name: String,
    val category: String,
    val region: String,
    val rating: String,
    val reviewCount: String,
)
