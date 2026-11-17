package com.android.catchtable.presentation.nearby.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.android.catchtable.presentation.nearby.NearbyRoute
import com.android.catchtable.presentation.navigation.MainTabRoute.Nearby

fun NavController.navigateToNearby(
    navOptions: NavOptions? = null,
) {
    navigate(Nearby, navOptions)
}

fun NavGraphBuilder.nearbyNavGraph(
    innerPadding: PaddingValues,
) {
    composable<Nearby> {
        NearbyRoute(
            modifier = Modifier.padding(innerPadding),
        )
    }
}
