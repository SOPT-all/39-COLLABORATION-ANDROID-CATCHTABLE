package com.android.catchtable.presentation.home.model

import androidx.annotation.DrawableRes

data class RecommendStoreUiModel(
    val id: Int,
    @DrawableRes val imageRes: Int,
    val name: String,
    val category: String,
    val region: String,
    val rating: String,
)
