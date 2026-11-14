package com.android.catchtable.presentation.vote

import com.android.catchtable.domain.model.vote.VoteDetailResponseModel
import com.android.catchtable.presentation.vote.model.VoteRole
import com.android.catchtable.presentation.vote.model.VoteStatus
import com.android.catchtable.presentation.common.model.CatchTableButtonType

data class VoteUiState(
    val voteDetail: VoteDetailResponseModel? = null,
    val selectedStoreId: Long? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null
) {
    val status: VoteStatus
        get() = voteDetail?.status ?: VoteStatus.CLOSED

    val role: VoteRole
        get() = if (voteDetail?.viewer?.isHost == true) VoteRole.HOST else VoteRole.GUEST

    val hasVoted: Boolean
        get() = voteDetail?.viewer?.hasVoted == true

    val canSubmitVote: Boolean
        get() = status == VoteStatus.OPEN &&
            role == VoteRole.GUEST &&
            !hasVoted &&
            selectedStoreId != null

    val buttonType: CatchTableButtonType
        get() = when {
            (status == VoteStatus.CREATE && role == VoteRole.HOST) || canSubmitVote ->
                CatchTableButtonType.PRIMARY_ENABLED
            else -> CatchTableButtonType.PRIMARY_DISABLED_PRIMARY
        }

    val buttonText: String
        get() = when (status) {
            VoteStatus.CREATE -> "${voteDetail?.candidates?.size ?: 0}개 · 투표 링크 공유하기"
            VoteStatus.OPEN -> when {
                hasVoted && role == VoteRole.GUEST -> "투표 완료"
                !hasVoted && selectedStoreId != null -> "매장 선택 완료"
                else -> "가고 싶은 매장을 투표해주세요"
            }
            VoteStatus.CLOSED -> "투표가 종료되었어요"
        }
}
