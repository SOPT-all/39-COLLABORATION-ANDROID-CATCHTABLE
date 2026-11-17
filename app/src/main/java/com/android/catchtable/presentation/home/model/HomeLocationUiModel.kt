package com.android.catchtable.presentation.home.model

import androidx.annotation.DrawableRes

data class HomeLocationUiModel(
    val name: String,
    @DrawableRes val imageRes: Int,
    val badge: HomeBadgeType?,
)
