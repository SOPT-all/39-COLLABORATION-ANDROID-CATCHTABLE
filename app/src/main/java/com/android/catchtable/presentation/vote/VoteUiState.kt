package com.android.catchtable.presentation.vote

import com.android.catchtable.domain.model.vote.VoteDetailModel
import com.android.catchtable.presentation.vote.model.VoteRole
import com.android.catchtable.domain.model.vote.VoteStatus
import com.android.catchtable.presentation.common.model.CatchTableButtonType
import com.android.catchtable.presentation.vote.model.VoteButtonType

data class VoteUiState(
    val voteDetail: VoteDetailModel? = null,
    val selectedCandidateId: Long? = null
) {
    val status: VoteStatus
        get() = voteDetail?.status ?: VoteStatus.CREATE

    val role: VoteRole
        get() = if (voteDetail == null || voteDetail.viewer.isHost) VoteRole.HOST else VoteRole.GUEST

    val hasVoted: Boolean
        get() = voteDetail?.viewer?.hasVoted == true

    val canSubmitVote: Boolean
        get() = status == VoteStatus.OPEN &&
            role == VoteRole.GUEST &&
            !hasVoted &&
            selectedCandidateId != null

    val canSelectStore: Boolean
        get() = when (status) {
            VoteStatus.CREATE -> role == VoteRole.HOST
            VoteStatus.OPEN -> role == VoteRole.GUEST && !hasVoted
        }

    val voteButtonType: VoteButtonType?
        get() = when {
            status == VoteStatus.CREATE -> VoteButtonType.CREATE_VOTE
            canSubmitVote -> VoteButtonType.CONFIRM_VOTE
            else -> null
        }

    val buttonType: CatchTableButtonType
        get() = if (voteButtonType != null) CatchTableButtonType.PRIMARY_ENABLED
        else CatchTableButtonType.PRIMARY_DISABLED_PRIMARY

    val buttonText: String?
        get() = when (status) {
            VoteStatus.CREATE -> voteDetail?.let { "${it.candidates.size}개 · 투표 생성하기" }
            VoteStatus.OPEN -> when {
                hasVoted && role == VoteRole.HOST -> null
                !hasVoted && selectedCandidateId != null -> "매장 선택 완료"
                else -> "가고 싶은 매장을 투표해주세요"
            }
        }
}
