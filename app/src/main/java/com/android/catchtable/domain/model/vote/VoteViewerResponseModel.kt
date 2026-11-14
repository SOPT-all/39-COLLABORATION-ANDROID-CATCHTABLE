package com.android.catchtable.domain.model.vote

data class VoteViewerResponseModel(
    val userId: Long,
    val isHost: Boolean,
    val hasVoted: Boolean,
    val selectedCandidateId: Long?,
    val displayName: String,
    val defaultNickname: String
)
