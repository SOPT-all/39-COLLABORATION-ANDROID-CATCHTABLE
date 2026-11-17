package com.android.catchtable.presentation.my.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.android.catchtable.presentation.my.MyRoute
import com.android.catchtable.presentation.navigation.MainTabRoute.My

fun NavController.navigateToMy(
    navOptions: NavOptions? = null,
) {
    navigate(My, navOptions)
}

fun NavGraphBuilder.myNavGraph(
    navController: NavController,
) {
    composable<My> {
        MyRoute()
    }
}
