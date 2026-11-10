package com.android.catchtable.presentation.home.model

import androidx.annotation.DrawableRes
import com.android.catchtable.R

enum class StoreBottomBarItemType(
    val text: String,
    @DrawableRes val icon: Int,
) {
    BOOKMARK("6.3만", R.drawable.ic_bookmark),
    PHONE("전화", R.drawable.ic_phone),
}