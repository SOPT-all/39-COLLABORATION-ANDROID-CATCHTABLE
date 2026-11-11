package com.android.catchtable.presentation.main.model

import androidx.annotation.DrawableRes
import com.android.catchtable.R

enum class BottomNavItem(
    val label: String,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
) {
    HOME(
        "홈", R.drawable.icon_nav_home_filled, R.drawable.icon_nav_home_outline
    ),
    SAVED(
        "저장", R.drawable.icon_nav_saved_filled, R.drawable.icon_nav_saved_outline
    ),
    NEARBY(
        "내 주변", R.drawable.icon_nav_nearby, R.drawable.icon_nav_nearby
    ),
    DINING(
        "마이다이닝", R.drawable.icon_nav_dining_filled, R.drawable.icon_nav_dining_outline
    ),
    MY(
        "MY", R.drawable.icon_nav_account_filled, R.drawable.icon_nav_account_outline
    ),
}