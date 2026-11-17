package com.android.catchtable.presentation.store.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.android.catchtable.presentation.navigation.Route.Store
import com.android.catchtable.presentation.store.StoreRoute

fun NavController.navigateToStore(
    storeId: Long,
    navOptions: NavOptions? = null,
) {
    navigate(Store(storeId = storeId), navOptions)
}

fun NavGraphBuilder.storeNavGraph(
    navController: NavController,
    innerPadding: PaddingValues,
) {
    composable<Store> {
        StoreRoute(
            storeId = 1,
            onBackClick = {},
            onTogetherClick = {},
            modifier = Modifier.padding(innerPadding),
        )
    }
}
