package com.android.catchtable.presentation.vote

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.android.catchtable.domain.model.vote.VoteStatus
import com.android.catchtable.presentation.common.component.CatchTableButton
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.vote.component.VoteHeader
import com.android.catchtable.presentation.vote.component.VoteInfoColumn
import com.android.catchtable.presentation.vote.component.bottomsheet.VoteBottomSheet
import com.android.catchtable.presentation.vote.component.bottomsheet.VoteBottomSheetContent
import com.android.catchtable.presentation.vote.model.VoteButtonType
import com.android.catchtable.presentation.vote.model.VoteMethod
import com.android.catchtable.presentation.vote.model.VoteRole
import com.android.catchtable.presentation.vote.model.createDummyVoteDetailModel

private const val MAX_VISIBLE_STORE_COUNT = 2

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VoteScreen(
    uiState: VoteUiState,
    onBackClick: () -> Unit,
    onShareClick: () -> Unit,
    onVoteEndClick: () -> Unit,
    onStoreClick: (Long) -> Unit,
    onCreateVoteClick: () -> Unit,
    onSubmitVoteClick: (nickname: String) -> Unit,
    modifier: Modifier = Modifier
) {
    var isVoteBottomSheetVisible by rememberSaveable { mutableStateOf(false) }
    var selectedMethod by rememberSaveable { mutableStateOf<VoteMethod?>(null) }
    var nickname by rememberSaveable("우수한 셀럽_12128") { mutableStateOf("우수한 셀럽_12128") }
    val candidates = uiState.voteDetail?.candidates.orEmpty()

    // voter가 있는 후보는 익명1 줄이 하나 더 보이므로 +1
    val voterRowCount = candidates.maxOfOrNull { candidate ->
        if (candidate.voters.isNotEmpty()) candidate.voters.size + 1 else 0
    } ?: 0

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

                VoteInfoColumn(
                    store = store,
                    voters = voters,
                    voterRowCount = voterRowCount,
                    status = uiState.status,
                    isSelected = when (uiState.status) {
                        VoteStatus.CREATE -> store.storeId in uiState.selectedStoreIds
                        VoteStatus.OPEN -> candidate.candidateId == uiState.selectedCandidateId
                    },
                    backgroundColor = backgroundColor,
                    strokeColor = strokeColor,
                    modifier = Modifier.weight(1f),
                    onCheckClick = {
                        onStoreClick(
                            when (uiState.status) {
                                VoteStatus.CREATE -> store.storeId
                                VoteStatus.OPEN -> candidate.candidateId
                            }
                        )
                    }
                )
            }
        }

        uiState.buttonText?.let { buttonText ->
            CatchTableButton(
                text = buttonText,
                type = uiState.buttonType,
                onClick = {
                    when (uiState.voteButtonType) {
                        VoteButtonType.CREATE_VOTE -> onCreateVoteClick()
                        VoteButtonType.CONFIRM_VOTE -> isVoteBottomSheetVisible = true
                        null -> Unit
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(CatchTableTheme.colors.white)
                    .padding(vertical = 12.dp, horizontal = 20.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
        }
    }

    if (isVoteBottomSheetVisible) {
        VoteBottomSheet(
            onDismissRequest = { isVoteBottomSheetVisible = false },
        ) {
            VoteBottomSheetContent(
                nickname = nickname,
                selectedMethod = selectedMethod,
                onMethodClick = { selectedMethod = it },
                onValueChange = { nickname = it },
                onButtonClick = {
                    isVoteBottomSheetVisible = false
                    onSubmitVoteClick(
                        if (selectedMethod == VoteMethod.ANONYMOUS) "익명1" else nickname
                    )
                },
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun VoteScreenPreview(
    @PreviewParameter(VoteUiStatePreviewProvider::class) uiState: VoteUiState
) {
    CatchTableTheme {
        Scaffold { innerPadding ->
            VoteScreen(
                uiState = uiState,
                onBackClick = {},
                onShareClick = {},
                onVoteEndClick = {},
                onStoreClick = {},
                onCreateVoteClick = {},
                onSubmitVoteClick = {},
                modifier = Modifier.fillMaxSize().padding(innerPadding)
            )
        }
    }
}

private class VoteUiStatePreviewProvider : PreviewParameterProvider<VoteUiState> {
    override val values = sequenceOf(
        previewVoteState(VoteStatus.CREATE, VoteRole.HOST, hasVoted = false),
        previewVoteState(VoteStatus.OPEN, VoteRole.HOST, hasVoted = false),
        previewVoteState(VoteStatus.OPEN, VoteRole.GUEST, hasVoted = false),
        previewVoteState(VoteStatus.OPEN, VoteRole.GUEST, hasVoted = true)
    )
}

private fun previewVoteState(
    status: VoteStatus,
    role: VoteRole,
    hasVoted: Boolean
): VoteUiState {
    val voteDetail = createDummyVoteDetailModel()
    val firstCandidate = voteDetail.candidates.first()
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
        selectedCandidateId = if (hasVoted) firstCandidate.candidateId else null
    )
}
