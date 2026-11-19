package com.android.catchtable.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun HomeRoute(
    navigateToStore: (Long) -> Unit,
    navigateToVote: (Long?) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    LifecycleEventEffect(Lifecycle.Event.ON_RESUME) {
        viewModel.getActiveVote()
    }

    HomeScreen(
        uiState = uiState,
        onTabClick = viewModel::onTabClick,
        onStoreClick = { storeId -> navigateToStore(storeId.toLong()) },
        onVoteClick = { navigateToVote(uiState.voteId) },
        modifier = modifier,
    )
}
