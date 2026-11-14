package com.android.catchtable.presentation.vote

import android.widget.Toast
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.android.catchtable.presentation.vote.model.VoteRole
import com.android.catchtable.presentation.vote.model.VoteButtonType

@Composable
fun VoteRoute(
    voteId: Long,
    role: VoteRole,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    onShareClick: () -> Unit = {},
    onVoteEndClick: () -> Unit = {},
    viewModel: VoteViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    LaunchedEffect(voteId, role) {
        viewModel.initVote(voteId, role)
    }

    VoteScreen(
        uiState = uiState,
        modifier = modifier,
        onBackClick = onBackClick,
        onShareClick = onShareClick,
        onVoteEndClick = {
            viewModel.updateVoteStatusToClosed()
            onVoteEndClick()
        },
        onStoreClick = viewModel::updateVoteSelection,
        onBottomButtonClick = {
            when (viewModel.getVoteButtonType()) {
                VoteButtonType.CREATE_VOTE -> {
                    Toast.makeText(context, "투표가 생성됩니다.", Toast.LENGTH_SHORT).show()
                    onBackClick()
                }
                VoteButtonType.CONFIRM_VOTE ->
                    Toast.makeText(context, "BottomSheet가 올라옵니다.", Toast.LENGTH_SHORT).show()
                null -> Unit
            }
        }
    )
}
