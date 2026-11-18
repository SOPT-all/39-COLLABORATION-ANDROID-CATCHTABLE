package com.android.catchtable.presentation.vote.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import androidx.navigation.toRoute
import com.android.catchtable.presentation.home.navigation.navigateToHome
import com.android.catchtable.presentation.navigation.Route.Vote
import com.android.catchtable.presentation.navigation.MainTabRoute
import com.android.catchtable.presentation.vote.VoteRoute
import com.android.catchtable.presentation.votecomplete.navigation.navigateToVoteComplete

fun NavController.navigateToVote(
    voteId: Long?,
    isHost: Boolean? = null,
    navOptions: NavOptions? = null,
) {
    // Store는 null, Home은 기존 voteId로 진입
    navigate(Vote(voteId = voteId, isHost = isHost), navOptions)
}

fun NavGraphBuilder.voteNavGraph(
    navController: NavController,
    innerPadding: PaddingValues,
) {
    composable<Vote> { backStackEntry ->
        val route = backStackEntry.toRoute<Vote>()
        VoteRoute(
            voteId = route.voteId,
            isHost = route.isHost,
            onBackClick = navController::popBackStack,
            navigateToHome = {
                navController.navigateToHome(
                    navOptions = navOptions {
                        popUpTo<MainTabRoute.Home> { inclusive = false }
                        launchSingleTop = true
                    }
                )
            },
            navigateToCreatedVote = { createdVoteId ->
                navController.navigateToVote(
                    voteId = createdVoteId,
                    isHost = false,
                    navOptions = navOptions {
                        popUpTo<Vote> { inclusive = true }
                    }
                )
            },
            navigateToVoteComplete = { voteId ->
                navController.navigateToVoteComplete(
                    voteId = voteId,
                    navOptions = navOptions {
                        popUpTo<Vote> { inclusive = true }
                    },
                )
            },
            modifier = Modifier.padding(innerPadding),
        )
    }
}
