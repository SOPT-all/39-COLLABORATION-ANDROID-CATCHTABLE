package com.android.catchtable.presentation.vote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.catchtable.presentation.vote.model.VoteRole
import com.android.catchtable.presentation.vote.model.VoteStatus
import com.android.catchtable.domain.usecase.vote.GetVoteDetailUseCase
import com.android.catchtable.presentation.vote.model.VoteButtonType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VoteViewModel @Inject constructor(
    private val getVoteDetailUseCase: GetVoteDetailUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(VoteUiState())
    val uiState = _uiState.asStateFlow()

    fun initVote(voteId: Long, role: VoteRole) {
        _uiState.update { it.copy(isLoading = true, errorMessage = null) }
        viewModelScope.launch {
            try {
                val voteDetail = getVoteDetailUseCase(voteId, role)
                _uiState.value = VoteUiState(
                    voteDetail = voteDetail,
                    selectedStoreId = voteDetail.candidates
                        .firstOrNull { it.candidateId == voteDetail.viewer.selectedCandidateId }
                        ?.store?.storeId
                )
            } catch (exception: CancellationException) {
                throw exception
            }
        }
    }

    fun updateVoteSelection(storeId: Long) {
        _uiState.update { state ->
            val storeExists = state.voteDetail?.candidates
                ?.any { it.store.storeId == storeId } == true
            if (!state.canSelectStore() || !storeExists) {
                return@update state
            }

            val selectedStoreId = if (state.selectedStoreId == storeId) null else storeId
            state.copy(selectedStoreId = selectedStoreId)
        }
    }

    fun getVoteButtonType(): VoteButtonType? {
        val state = _uiState.value
        return when {
            state.status == VoteStatus.CREATE && state.role == VoteRole.HOST ->
                VoteButtonType.CREATE_VOTE
            state.canSubmitVote -> VoteButtonType.CONFIRM_VOTE
            else -> null
        }
    }

    fun updateVoteStatusToClosed() {
        _uiState.update { state ->
            if (state.status != VoteStatus.OPEN || state.role != VoteRole.HOST) {
                return@update state
            }
            state.copy(voteDetail = state.voteDetail?.copy(status = VoteStatus.CLOSED))
        }
    }

    private fun VoteUiState.canSelectStore(): Boolean = when (status) {
        VoteStatus.CREATE -> role == VoteRole.HOST
        VoteStatus.OPEN -> role == VoteRole.GUEST && !hasVoted
        VoteStatus.CLOSED -> false
    }
}
