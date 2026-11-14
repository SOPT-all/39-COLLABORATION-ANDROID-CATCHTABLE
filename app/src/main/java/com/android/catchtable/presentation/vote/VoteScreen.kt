package com.android.catchtable.presentation.vote

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.vote.model.VoteRole
import com.android.catchtable.presentation.vote.model.VoteStatus
import com.android.catchtable.presentation.common.component.CatchTableButton
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.vote.component.VoteHeader
import com.android.catchtable.presentation.vote.component.VoteInfo
import com.android.catchtable.presentation.vote.model.createDummyVoteDetailResponseModel

@Composable
fun VoteScreen(
    uiState: VoteUiState,
    onBackClick: () -> Unit,
    onShareClick: () -> Unit,
    onVoteEndClick: () -> Unit,
    onStoreClick: (Long) -> Unit,
    onBottomButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val candidates = uiState.voteDetail?.candidates.orEmpty()
    val voterRowCount = candidates.maxOfOrNull { it.voters.size } ?: 0

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(CatchTableTheme.colors.white)
    ) {
        VoteHeader(
            onBackClick = onBackClick,
            modifier = Modifier.fillMaxWidth(),
            status = uiState.status,
            role = uiState.role,
            onShareClick = onShareClick,
            onVoteEndClick = onVoteEndClick
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(top = 20.dp, bottom = 24.dp, start = 12.dp, end = 12.dp)
        ) {
            candidates.take(MAX_VISIBLE_STORE_COUNT).forEachIndexed { index, candidate ->
                val store = candidate.store
                val voters = candidate.voters
                val backgroundColor = if (index % 2 == 0) {
                    CatchTableTheme.colors.white
                } else {
                    CatchTableTheme.colors.gray100
                }
                val strokeColor = if (index % 2 == 0) {
                    CatchTableTheme.colors.gray200
                } else {
                    CatchTableTheme.colors.white
                }

                VoteInfo(
                    store = store,
                    voters = voters,
                    voterRowCount = voterRowCount,
                    status = uiState.status,
                    isSelected = when (uiState.status) {
                        VoteStatus.CREATE -> true
                        VoteStatus.OPEN -> store.storeId == uiState.selectedStoreId
                    },
                    backgroundColor = backgroundColor,
                    strokeColor = strokeColor,
                    modifier = Modifier.weight(1f),
                    onCheckClick = { onStoreClick(store.storeId) }
                )
            }
        }

        uiState.buttonText?.let { buttonText ->
            CatchTableButton(
                text = buttonText,
                type = uiState.buttonType,
                onClick = onBottomButtonClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(CatchTableTheme.colors.white)
                    .padding(vertical = 12.dp, horizontal = 20.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "CREATE")
@Composable
private fun VoteCreateHostPreview() = VoteScreenPreviewContent(
    status = VoteStatus.CREATE,
    role = VoteRole.HOST
)

@Preview(showBackground = true, showSystemUi = true, name = "OPEN · HOST")
@Composable
private fun VoteOpenHostPreview() = VoteScreenPreviewContent(
    status = VoteStatus.OPEN,
    role = VoteRole.HOST
)

@Preview(showBackground = true, showSystemUi = true, name = "OPEN · GUEST · 미투표")
@Composable
private fun VoteOpenGuestPreview() = VoteScreenPreviewContent(
    status = VoteStatus.OPEN,
    role = VoteRole.GUEST
)

@Preview(showBackground = true, showSystemUi = true, name = "OPEN · GUEST · 투표완료")
@Composable
private fun VoteOpenGuestVotedPreview() = VoteScreenPreviewContent(
    status = VoteStatus.OPEN,
    role = VoteRole.GUEST,
    hasVoted = true
)

@Composable
private fun VoteScreenPreviewContent(
    status: VoteStatus,
    role: VoteRole,
    hasVoted: Boolean = false
) {
    CatchTableTheme {
        Scaffold {innerPadding ->
            VoteScreen(
                uiState = previewVoteState(status, role, hasVoted),
                onBackClick = {},
                onShareClick = {},
                onVoteEndClick = {},
                onStoreClick = {},
                onBottomButtonClick = {},
                modifier = Modifier.fillMaxSize().padding(innerPadding)
            )
        }
    }
}

private fun previewVoteState(
    status: VoteStatus,
    role: VoteRole,
    hasVoted: Boolean
): VoteUiState {
    val voteDetail = createDummyVoteDetailResponseModel()
    val firstCandidate = voteDetail.candidates.first()
    val selectedStoreId = when {
        hasVoted -> firstCandidate.store.storeId
        else -> null
    }
    val viewer = voteDetail.viewer.copy(
        isHost = role == VoteRole.HOST,
        hasVoted = hasVoted,
        selectedCandidateId = if (hasVoted) {
            firstCandidate.candidateId
        } else {
            null
        }
    )

    return VoteUiState(
        voteDetail = voteDetail.copy(
            status = status,
            viewer = viewer
        ),
        selectedStoreId = selectedStoreId
    )
}

private const val MAX_VISIBLE_STORE_COUNT = 2
