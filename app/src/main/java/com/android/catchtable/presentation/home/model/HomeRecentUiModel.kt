package com.android.catchtable.presentation.home.model

import androidx.annotation.DrawableRes

data class HomeRecentUiModel(
    val id: Int,
    @DrawableRes val imageRes: Int,
    val name: String,
    val region: String,
    val category: String,
)