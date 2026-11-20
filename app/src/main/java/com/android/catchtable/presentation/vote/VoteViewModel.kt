package com.android.catchtable.presentation.vote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.catchtable.domain.model.vote.SubmitBallotRequestModel
import com.android.catchtable.domain.model.vote.CreateVoteRequestModel
import com.android.catchtable.domain.model.vote.VoteStatus
import com.android.catchtable.domain.usecase.vote.GetVoteDetailUseCase
import com.android.catchtable.domain.usecase.vote.PostSubmitBallotUseCase
import com.android.catchtable.domain.usecase.vote.PostCreateVoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class VoteViewModel @Inject constructor(
    private val postSubmitBallotUseCase: PostSubmitBallotUseCase,
    private val getVoteDetailUseCase: GetVoteDetailUseCase,
    private val postCreateVoteUseCase: PostCreateVoteUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(VoteUiState())
    val uiState = _uiState.asStateFlow()

    fun initVote(voteId: Long?, isHost: Boolean? = null) {
        viewModelScope.launch {
            getVoteDetailUseCase(voteId)
                .onSuccess { voteDetail ->
                    val displayedVoteDetail = isHost?.let { host ->
                        voteDetail.copy(viewer = voteDetail.viewer.copy(isHost = host))
                    } ?: voteDetail
                    _uiState.value = VoteUiState(
                        voteDetail = displayedVoteDetail,
                        selectedCandidateId = displayedVoteDetail.viewer.selectedCandidateId
                    )
                }
                .onFailure { Timber.e(it, "투표 상세 조회 실패") }
        }
    }

    fun updateVoteSelection(id: Long) {
        _uiState.update { currentState ->
            if (currentState.status != VoteStatus.OPEN || !currentState.canSelectStore) {
                currentState
            } else {
                val candidateExists = currentState.voteDetail
                    ?.candidates
                    ?.any { candidate -> candidate.candidateId == id } == true

                if (!candidateExists) {
                    currentState
                } else {
                    val updatedCandidateId =
                        if (currentState.selectedCandidateId == id) null else id
                    currentState.copy(selectedCandidateId = updatedCandidateId)
                }
            }
        }
    }

    fun createVote(onSuccess: (Long) -> Unit) {
        val state = _uiState.value
        if (state.status != VoteStatus.CREATE || !state.canSelectStore) return
        val storeIds = state.voteDetail?.candidates?.map { it.store.storeId }.orEmpty()
        if (storeIds.isEmpty()) return

        viewModelScope.launch {
            postCreateVoteUseCase(CreateVoteRequestModel(storeIds))
                .onSuccess {
                    Timber.d("투표 생성 성공 (voteId=${it.voteId})")
                    onSuccess(it.voteId)
                }
                .onFailure { Timber.e(it, "투표 생성 실패") }
        }
    }

    fun submitVote(
        nickname: String,
        onSuccess: (voteId: Long) -> Unit,
    ) {
        val state = _uiState.value
        val voteId = state.voteDetail?.voteId ?: return
        val candidateId = state.selectedCandidateId ?: return
        if (!state.canSubmitVote) return

        viewModelScope.launch {
            postSubmitBallotUseCase(
                voteId = voteId,
                request = SubmitBallotRequestModel(
                    candidateId = candidateId,
                    nickname = nickname.trim(),
                ),
            )
                .onSuccess { onSuccess(voteId) }
                .onFailure { Timber.e(it, "투표 제출 실패") }
        }
    }
}
