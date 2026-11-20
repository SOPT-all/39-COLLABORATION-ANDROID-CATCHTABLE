package com.android.catchtable.presentation.vote

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.android.catchtable.domain.model.vote.VoteStatus
import com.android.catchtable.presentation.vote.model.VoteRole

@Composable
fun VoteRoute(
    voteId: Long?,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    isHost: Boolean? = null,
    navigateToHome: () -> Unit = {},
    navigateToCreatedVote: (Long) -> Unit,
    navigateToVoteComplete: (Long) -> Unit,
    viewModel: VoteViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LifecycleEventEffect(Lifecycle.Event.ON_RESUME) {
        viewModel.initVote(voteId, isHost)
    }

    val backAction = if (uiState.status == VoteStatus.OPEN && uiState.role == VoteRole.GUEST) {
        navigateToHome
    } else {
        onBackClick
    }

    VoteScreen(
        uiState = uiState,
        modifier = modifier,
        onBackClick = backAction,
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
