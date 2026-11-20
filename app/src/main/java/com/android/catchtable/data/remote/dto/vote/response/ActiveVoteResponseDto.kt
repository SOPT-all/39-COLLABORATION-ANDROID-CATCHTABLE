package com.android.catchtable.data.remote.dto.vote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ActiveVoteResponseDto(
    @SerialName("vote") val vote: ActiveVoteInfoResponseDto? = null,
)

@Serializable
data class ActiveVoteInfoResponseDto(
    @SerialName("voteId") val voteId: Long,
    @SerialName("candidateCount") val candidateCount: Int,
    @SerialName("createdAt") val createdAt: String,
)
