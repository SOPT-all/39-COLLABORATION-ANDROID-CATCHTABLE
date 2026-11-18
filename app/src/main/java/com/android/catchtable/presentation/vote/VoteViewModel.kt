package com.android.catchtable.presentation.vote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.catchtable.domain.model.vote.CreateVoteRequestModel
import com.android.catchtable.domain.model.vote.VoteStatus
import com.android.catchtable.domain.usecase.vote.GetVoteDetailUseCase
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
    private val getVoteDetailUseCase: GetVoteDetailUseCase,
    private val postCreateVoteUseCase: PostCreateVoteUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(VoteUiState())
    val uiState = _uiState.asStateFlow()

    fun initVote(voteId: Long?, isHost: Boolean? = null) {
        viewModelScope.launch {
            getVoteDetailUseCase(1, voteId)
                .onSuccess { voteDetail ->
                    val displayedVoteDetail = isHost?.let { host ->
                        voteDetail.copy(viewer = voteDetail.viewer.copy(isHost = host))
                    } ?: voteDetail
                    _uiState.value = VoteUiState(
                        voteDetail = displayedVoteDetail,
                        selectedCandidateId = displayedVoteDetail.viewer.selectedCandidateId,
                        selectedStoreIds = if (displayedVoteDetail.status == VoteStatus.CREATE) {
                            displayedVoteDetail.candidates.map { it.store.storeId }.toSet()
                        } else emptySet()
                    )
                }
                .onFailure { Timber.e(it, "투표 상세 조회 실패") }
        }
    }

    fun updateVoteSelection(id: Long) {
        _uiState.update { state ->
            if (!state.canSelectStore) return@update state

            if (state.status == VoteStatus.CREATE) {
                val exists = state.voteDetail?.candidates?.any { it.store.storeId == id } == true
                if (!exists) return@update state
                val selected = state.selectedStoreIds.toMutableSet()
                if (!selected.add(id)) selected.remove(id)
                state.copy(selectedStoreIds = selected)
            } else {
                val exists = state.voteDetail?.candidates?.any { it.candidateId == id } == true
                if (!exists) return@update state
                state.copy(selectedCandidateId = if (state.selectedCandidateId == id) null else id)
            }
        }
    }

    fun createVote(onSuccess: (Long) -> Unit) {
        val state = _uiState.value
        if (state.status != VoteStatus.CREATE || !state.canSelectStore || state.selectedStoreIds.isEmpty()) return

        viewModelScope.launch {
            postCreateVoteUseCase(1, CreateVoteRequestModel(state.selectedStoreIds.toList()))
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
            Timber.d("투표 제출 voteId=$voteId, candidateId=$candidateId, nickname=$nickname")
            onSuccess(voteId)
        }
    }
}
