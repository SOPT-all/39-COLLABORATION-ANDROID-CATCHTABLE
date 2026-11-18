package com.android.catchtable.data.remote.dto.vote.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateVoteRequestDto(
    @SerialName("storeIds") val storeIds: List<Long>
)
