package com.android.catchtable.presentation.vote.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.android.catchtable.presentation.navigation.Route.Vote
import com.android.catchtable.presentation.vote.VoteRoute

fun NavController.navigateToVote(
    navOptions: NavOptions? = null,
) {
    navigate(Vote, navOptions)
}

fun NavGraphBuilder.voteNavGraph(
    innerPadding: PaddingValues,
) {
    composable<Vote> {
        VoteRoute(
            modifier = Modifier.padding(innerPadding),
        )
    }
}
