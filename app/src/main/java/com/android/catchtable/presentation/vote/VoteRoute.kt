package com.android.catchtable.presentation.vote

import android.widget.Toast
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.android.catchtable.presentation.vote.component.VoteBottomSheet
import com.android.catchtable.presentation.vote.model.VoteButtonType
import com.android.catchtable.presentation.vote.model.VoteRole

@OptIn(ExperimentalMaterial3Api::class)
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
    var isVoteBottomSheetVisible by remember { mutableStateOf(false) }

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
                    isVoteBottomSheetVisible = true
                null -> Unit
            }
        }
    )

    if (isVoteBottomSheetVisible) {
        VoteBottomSheet(
            onDismissRequest = { isVoteBottomSheetVisible = false }
        ) {
            Spacer(modifier = Modifier.height(120.dp))
        }
    }
}
