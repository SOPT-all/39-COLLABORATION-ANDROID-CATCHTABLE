package com.android.catchtable.presentation.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.android.catchtable.presentation.dining.navigation.diningNavGraph
import com.android.catchtable.presentation.home.navigation.homeNavGraph
import com.android.catchtable.presentation.my.navigation.myNavGraph
import com.android.catchtable.presentation.nearby.navigation.nearbyNavGraph
import com.android.catchtable.presentation.saved.navigation.savedNavGraph
import com.android.catchtable.presentation.store.navigation.storeNavGraph
import com.android.catchtable.presentation.vote.navigation.voteNavGraph
import com.android.catchtable.presentation.votecomplete.navigation.voteCompleteNavGraph

@Composable
fun MainNavHost(
    appState: MainAppState,
    innerPadding: PaddingValues,
) {
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = appState.startDestination,
    ) {
        homeNavGraph(
            innerPadding = innerPadding,
        )
        savedNavGraph(
            innerPadding = innerPadding,
        )
        nearbyNavGraph(
            innerPadding = innerPadding,
        )
        diningNavGraph(
            innerPadding = innerPadding,
        )
        myNavGraph(
            innerPadding = innerPadding,
        )
        storeNavGraph(
            innerPadding = innerPadding,
        )
        voteNavGraph(
            innerPadding = innerPadding,
        )
        voteCompleteNavGraph(
            innerPadding = innerPadding,
        )
    }
}
