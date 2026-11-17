package com.android.catchtable.presentation.main.model

import androidx.annotation.DrawableRes
import com.android.catchtable.R
import com.android.catchtable.presentation.navigation.MainTabRoute
import com.android.catchtable.presentation.navigation.MainTabRoute.Dining
import com.android.catchtable.presentation.navigation.MainTabRoute.Home
import com.android.catchtable.presentation.navigation.MainTabRoute.My
import com.android.catchtable.presentation.navigation.MainTabRoute.Nearby
import com.android.catchtable.presentation.navigation.MainTabRoute.Saved
import com.android.catchtable.presentation.navigation.Route

enum class BottomNavItem(
    val label: String,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    val route: MainTabRoute,
) {
    HOME(
        label = "홈",
        selectedIcon = R.drawable.icon_nav_home_filled,
        unselectedIcon = R.drawable.icon_nav_home_outline,
        route = Home,
    ),
    SAVED(
        label = "저장",
        selectedIcon = R.drawable.icon_nav_saved_filled,
        unselectedIcon = R.drawable.icon_nav_saved_outline,
        route = Saved,
    ),
    NEARBY(
        label = "내 주변",
        selectedIcon = R.drawable.icon_nav_nearby,
        unselectedIcon = R.drawable.icon_nav_nearby,
        route = Nearby,
    ),
    DINING(
        label = "마이다이닝",
        selectedIcon = R.drawable.icon_nav_dining_filled,
        unselectedIcon = R.drawable.icon_nav_dining_outline,
        route = Dining,
    ),
    MY(
        label = "my",
        selectedIcon = R.drawable.icon_nav_account_filled,
        unselectedIcon = R.drawable.icon_nav_account_outline,
        route = My,
    );

    companion object {
        fun find(predicate: (MainTabRoute) -> Boolean): BottomNavItem? {
            return BottomNavItem.entries.find { predicate(it.route) }
        }

        fun contains(predicate: (Route) -> Boolean): Boolean {
            return BottomNavItem.entries.map { it.route }.any { predicate(it) }
        }
    }
}
