package com.android.catchtable.presentation.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.android.catchtable.presentation.home.HomeRoute
import com.android.catchtable.presentation.navigation.MainTabRoute.Home

fun NavController.navigateToHome(
    navOptions: NavOptions? = null,
) {
    navigate(Home, navOptions)
}

fun NavGraphBuilder.homeNavGraph(
    navController: NavController,
) {
    composable<Home> {
        HomeRoute()
    }
}
