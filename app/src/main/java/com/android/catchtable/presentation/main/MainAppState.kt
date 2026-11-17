package com.android.catchtable.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.android.catchtable.presentation.dining.navigation.navigateToDining
import com.android.catchtable.presentation.home.navigation.navigateToHome
import com.android.catchtable.presentation.main.model.BottomNavItem
import com.android.catchtable.presentation.my.navigation.navigateToMy
import com.android.catchtable.presentation.navigation.MainTabRoute
import com.android.catchtable.presentation.nearby.navigation.navigateToNearby
import com.android.catchtable.presentation.saved.navigation.navigateToSaved
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@Stable
class MainAppState(
    val navController: NavHostController,
    coroutineScope: CoroutineScope,
) {
    val startDestination = MainTabRoute.Home

    private val currentDestination = navController.currentBackStackEntryFlow
        .map { it.destination }
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null
        )

    val currentTab: StateFlow<BottomNavItem?> = currentDestination
        .map { destination ->
            BottomNavItem.find { tab ->
                destination?.hasRoute(tab::class) == true
            }
        }
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null
        )

    val isBottomBarVisible: StateFlow<Boolean> = currentDestination
        .map { destination ->
            BottomNavItem.contains { tab ->
                destination?.hasRoute(tab::class) == true
            }
        }
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = false
        )

    fun navigate(tab: BottomNavItem) {
        val navOptions = navOptions {
            navController.currentDestination?.route?.let {
                popUpTo(it) {
                    inclusive = true
                }
                launchSingleTop = true
            }
        }

        when (tab) {
            BottomNavItem.HOME -> navController.navigateToHome(navOptions = navOptions)
            BottomNavItem.SAVED -> navController.navigateToSaved(navOptions = navOptions)
            BottomNavItem.NEARBY -> navController.navigateToNearby(navOptions = navOptions)
            BottomNavItem.DINING -> navController.navigateToDining(navOptions = navOptions)
            BottomNavItem.MY -> navController.navigateToMy(navOptions = navOptions)
        }
    }
}

@Composable
fun rememberMainAppState(
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
): MainAppState = remember(navController, coroutineScope) {
    MainAppState(navController, coroutineScope)
}
