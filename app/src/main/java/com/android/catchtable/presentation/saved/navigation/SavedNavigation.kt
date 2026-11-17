package com.android.catchtable.presentation.saved.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.android.catchtable.presentation.navigation.MainTabRoute.Saved
import com.android.catchtable.presentation.saved.SavedRoute

fun NavController.navigateToSaved(
    navOptions: NavOptions? = null,
) {
    navigate(Saved, navOptions)
}

fun NavGraphBuilder.savedNavGraph(
    navController: NavController,
) {
    composable<Saved> {
        SavedRoute()
    }
}
