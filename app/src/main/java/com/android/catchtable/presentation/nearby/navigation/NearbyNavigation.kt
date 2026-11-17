package com.android.catchtable.presentation.nearby.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.android.catchtable.presentation.navigation.MainTabRoute.Nearby
import com.android.catchtable.presentation.nearby.NearbyRoute

fun NavController.navigateToNearby(
    navOptions: NavOptions? = null,
) {
    navigate(Nearby, navOptions)
}

fun NavGraphBuilder.nearbyNavGraph(
    navController: NavController,
) {
    composable<Nearby> {
        NearbyRoute()
    }
}
