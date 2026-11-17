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
    viewModel: VoteViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    LaunchedEffect(voteId) {
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
            Toast.makeText(context, "투표가 생성됩니다.", Toast.LENGTH_SHORT).show()
            onBackClick()
        }
    )
}
