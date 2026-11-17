package com.android.catchtable.data.remote.dto.vote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VoteDetailResponseDto(
    @SerialName("voteId") val voteId: Long,
    @SerialName("status") val status: String,
    @SerialName("participantCount") val participantCount: Int,
    @SerialName("candidates") val candidates: List<VoteCandidateResponseDto>,
    @SerialName("viewer") val viewer: VoteViewerResponseDto,
    @SerialName("createdAt") val createdAt: String,
    @SerialName("closedAt") val closedAt: String?
)

@Serializable
data class VoteViewerResponseDto(
    @SerialName("userId") val userId: Long,
    @SerialName("isHost") val isHost: Boolean,
    @SerialName("hasVoted") val hasVoted: Boolean,
    @SerialName("selectedCandidateId") val selectedCandidateId: Long?,
    @SerialName("displayName") val displayName: String?,
    @SerialName("defaultNickname") val defaultNickname: String
)

@Serializable
data class VoteCandidateResponseDto(
    @SerialName("candidateId") val candidateId: Long,
    @SerialName("displayOrder") val displayOrder: Int,
    @SerialName("voteCount") val voteCount: Int,
    @SerialName("voters") val voters: List<VoteVoterResponseDto>,
    @SerialName("store") val store: VoteStoreResponseDto
)

@Serializable
data class VoteVoterResponseDto(
    @SerialName("displayName") val displayName: String
)
