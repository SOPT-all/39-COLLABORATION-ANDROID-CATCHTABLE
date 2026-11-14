package com.android.catchtable.data.remote.dto.vote.response

import kotlinx.serialization.Serializable

@Serializable
data class VoteCandidateResponseDto(
    val candidateId: Long,
    val displayOrder: Int,
    val voteCount: Int,
    val voters: List<VoteVoterResponseDto>,
    val store: VoteDetailStoreResponseDto
)
