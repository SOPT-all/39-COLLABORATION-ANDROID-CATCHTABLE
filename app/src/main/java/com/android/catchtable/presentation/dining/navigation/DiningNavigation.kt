package com.android.catchtable.presentation.dining.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
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
    innerPadding: PaddingValues,
) {
    composable<Dining> {
        DiningRoute(
            modifier = Modifier.padding(innerPadding),
        )
    }
}
