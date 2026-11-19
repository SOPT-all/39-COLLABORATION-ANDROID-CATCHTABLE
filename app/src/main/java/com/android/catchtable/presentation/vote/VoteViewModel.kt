package com.android.catchtable.presentation.vote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.catchtable.domain.model.vote.SubmitBallotRequestModel
import com.android.catchtable.domain.usecase.vote.GetVoteDetailUseCase
import com.android.catchtable.domain.usecase.vote.PostSubmitBallotUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class VoteViewModel @Inject constructor(
    private val getVoteDetailUseCase: GetVoteDetailUseCase,
    private val postSubmitBallotUseCase: PostSubmitBallotUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(VoteUiState())
    val uiState = _uiState.asStateFlow()

    fun initVote(voteId: Long?) {
        viewModelScope.launch {
            getVoteDetailUseCase(voteId)
                .onSuccess { voteDetail ->
                    _uiState.value = VoteUiState(
                        voteDetail = voteDetail,
                        selectedCandidateId = voteDetail.viewer.selectedCandidateId
                    )
                }
                .onFailure { throwable ->
                    Timber.e(throwable, "투표 상세 조회 실패")
                }
            }
    }

    fun updateVoteSelection(candidateId: Long) {
        _uiState.update { state ->
            val candidateExists = state.voteDetail?.candidates
                ?.any { it.candidateId == candidateId } == true
            if (!state.canSelectStore || !candidateExists) {
                return@update state
            }

            val selectedCandidateId =
                if (state.selectedCandidateId == candidateId) null else candidateId
            state.copy(selectedCandidateId = selectedCandidateId)
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
