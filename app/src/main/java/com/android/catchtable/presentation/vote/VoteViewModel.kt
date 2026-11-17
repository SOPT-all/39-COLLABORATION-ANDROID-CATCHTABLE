package com.android.catchtable.presentation.vote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.catchtable.domain.usecase.vote.GetVoteDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class VoteViewModel @Inject constructor(
    private val getVoteDetailUseCase: GetVoteDetailUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(VoteUiState())
    val uiState = _uiState.asStateFlow()

    fun initVote(voteId: Long?) {
        if (voteId == null) {
            _uiState.value = VoteUiState()
            return
        }

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

    /**
     * 투표 제출 (POST /api/v1/votes/{voteId}/ballots/me)
     *
     * @param nickname 바텀시트에서 확정한 닉네임 (익명 선택 시 viewer.defaultNickname)
     * @param onSuccess 제출 성공 시 호출, 투표 완료 화면으로 이동할 때 사용
     */
    fun submitVote(
        nickname: String,
        onSuccess: (voteId: Long) -> Unit,
    ) {
        val state = _uiState.value
        val voteId = state.voteDetail?.voteId ?: return
        val candidateId = state.selectedCandidateId ?: return
        if (!state.canSubmitVote) return

        viewModelScope.launch {
            // TODO: 투표 제출 API 연동
            //  1. SubmitBallotUseCase(voteId, candidateId, nickname.trim()) 호출
            //  2. 성공 시 응답으로 오는 최신 투표 상세로 uiState 갱신 후 onSuccess(voteId) 호출
            //  3. 실패 시 ApiException.code로 분기
            //     - ALREADY_VOTED: 이미 투표함 / VOTE_CLOSED: 마감된 투표 / INVALID_NICKNAME: 닉네임 형식 오류
            Timber.d("투표 제출 voteId=$voteId, candidateId=$candidateId, nickname=$nickname")

            // 임시: API 연동 전까지 바로 투표 완료 화면으로 이동
            onSuccess(voteId)
        }
    }
}
