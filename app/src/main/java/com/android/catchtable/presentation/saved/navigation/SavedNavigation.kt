package com.android.catchtable.presentation.saved.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.android.catchtable.presentation.saved.SavedRoute
import com.android.catchtable.presentation.navigation.MainTabRoute.Saved

fun NavController.navigateToSaved(
    navOptions: NavOptions? = null,
) {
    navigate(Saved, navOptions)
}

fun NavGraphBuilder.savedNavGraph(
    innerPadding: PaddingValues,
) {
    composable<Saved> {
        SavedRoute(
            modifier = Modifier.padding(innerPadding),
        )
    }
}
