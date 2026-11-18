package com.android.catchtable.presentation.vote

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun VoteRoute(
    voteId: Long?,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit = {},
    navigateToCreatedVote: (Long) -> Unit,
    navigateToVoteComplete: (Long) -> Unit,
    viewModel: VoteViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        viewModel.initVote(voteId)
    }

    VoteScreen(
        uiState = uiState,
        modifier = modifier,
        onBackClick = onBackClick,
        onShareClick = {},
        onVoteEndClick = {
            navigateToHome() // 홈 화면으로 이동
        },
        onStoreClick = viewModel::updateVoteSelection,
        onCreateVoteClick = {
            viewModel.createVote(onSuccess = navigateToCreatedVote)
        },
        onSubmitVoteClick = { nickname ->
            viewModel.submitVote(
                nickname = nickname,
                onSuccess = navigateToVoteComplete, // 제출 성공 시 투표 완료 화면으로 이동
            )
        },
    )
}
