package com.android.catchtable.presentation.votecomplete.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import androidx.navigation.toRoute
import com.android.catchtable.presentation.navigation.Route.VoteComplete
import com.android.catchtable.presentation.vote.navigation.navigateToVote
import com.android.catchtable.presentation.votecomplete.VoteCompleteScreen

fun NavController.navigateToVoteComplete(
    voteId: Long,
    navOptions: NavOptions? = null,
) {
    navigate(VoteComplete(voteId = voteId), navOptions)
}

fun NavGraphBuilder.voteCompleteNavGraph(
    navController: NavController,
    innerPadding: PaddingValues,
) {
    composable<VoteComplete> { backStackEntry ->
        val route = backStackEntry.toRoute<VoteComplete>()

        VoteCompleteScreen(
            onButtonClick = {
                navController.navigateToVote(
                    voteId = route.voteId,
                    isHost = false,
                    navOptions = navOptions {
                        popUpTo<VoteComplete> { inclusive = true }
                    },
                )
            },
            modifier = Modifier.padding(innerPadding),
        )
    }
}
