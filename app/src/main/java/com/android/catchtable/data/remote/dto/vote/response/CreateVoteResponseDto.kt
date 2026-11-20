package com.android.catchtable.data.remote.dto.vote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateVoteResponseDto(
    @SerialName("voteId") val voteId: Long,
    @SerialName("status") val status: String,
    @SerialName("hostUserId") val hostUserId: Long,
    @SerialName("candidates") val candidates: List<CreateVoteCandidateResponseDto>,
    @SerialName("createdAt") val createdAt: String
)

@Serializable
data class CreateVoteCandidateResponseDto(
    @SerialName("candidateId") val candidateId: Long,
    @SerialName("storeId") val storeId: Long,
    @SerialName("displayOrder") val displayOrder: Int
)