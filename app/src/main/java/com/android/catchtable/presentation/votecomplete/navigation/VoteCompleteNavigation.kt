package com.android.catchtable.presentation.votecomplete.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.android.catchtable.presentation.navigation.Route.VoteComplete
import com.android.catchtable.presentation.votecomplete.VoteCompleteScreen

fun NavController.navigateToVoteComplete(
    navOptions: NavOptions? = null,
) {
    navigate(VoteComplete, navOptions)
}

fun NavGraphBuilder.voteCompleteNavGraph(
    innerPadding: PaddingValues,
) {
    composable<VoteComplete> {
        VoteCompleteScreen(
            modifier = Modifier.padding(innerPadding),
        )
    }
}
