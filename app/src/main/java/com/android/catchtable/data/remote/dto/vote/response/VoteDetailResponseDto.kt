package com.android.catchtable.data.remote.dto.vote.response

import kotlinx.serialization.Serializable

@Serializable
data class VoteDetailResponseDto(
    val voteId: Long,
    val status: String,
    val participantCount: Int,
    val candidates: List<VoteCandidateResponseDto>,
    val viewer: VoteViewerResponseDto,
    val createdAt: String,
    val closedAt: String?
)

