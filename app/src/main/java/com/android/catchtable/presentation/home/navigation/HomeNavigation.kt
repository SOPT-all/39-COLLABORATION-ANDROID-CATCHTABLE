package com.android.catchtable.presentation.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.android.catchtable.presentation.home.HomeRoute
import com.android.catchtable.presentation.navigation.MainTabRoute.Home
import com.android.catchtable.presentation.store.navigation.navigateToStore
import com.android.catchtable.presentation.vote.navigation.navigateToVote

fun NavController.navigateToHome(
    navOptions: NavOptions? = null,
) {
    navigate(Home, navOptions)
}

fun NavGraphBuilder.homeNavGraph(
    navController: NavController,
    innerPadding: PaddingValues,
) {
    composable<Home> {
        HomeRoute(
            navigateToStore = { storeId -> navController.navigateToStore(storeId.toLong()) },
            navigateToVote = { navController.navigateToVote() },
            modifier = Modifier.padding(innerPadding),
        )
    }
}
