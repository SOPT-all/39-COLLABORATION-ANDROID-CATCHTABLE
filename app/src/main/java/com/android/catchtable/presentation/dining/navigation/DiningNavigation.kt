package com.android.catchtable.presentation.dining.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.android.catchtable.presentation.dining.DiningRoute
import com.android.catchtable.presentation.navigation.MainTabRoute.Dining

fun NavController.navigateToDining(
    navOptions: NavOptions? = null,
) {
    navigate(Dining, navOptions)
}

fun NavGraphBuilder.diningNavGraph(
    navController: NavController,
) {
    composable<Dining> {
        DiningRoute()
    }
}
