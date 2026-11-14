package com.android.catchtable.data.remote.dto.vote.response

import kotlinx.serialization.Serializable

@Serializable
data class VoteViewerResponseDto(
    val userId: Long,
    val isHost: Boolean,
    val hasVoted: Boolean,
    val selectedCandidateId: Long?,
    val displayName: String,
    val defaultNickname: String
)
