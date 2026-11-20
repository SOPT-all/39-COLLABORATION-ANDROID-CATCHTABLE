package com.android.catchtable.data.remote.dto.vote.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SubmitBallotRequestDto(
    @SerialName("candidateId") val candidateId: Long,
    @SerialName("nickname") val nickname: String,
)
