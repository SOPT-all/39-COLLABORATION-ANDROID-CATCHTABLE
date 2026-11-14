package com.android.catchtable.data.remote.dto.vote.response

import kotlinx.serialization.Serializable

@Serializable
data class VoteAmenityResponseDto(
    val category: String,
    val content: String
)
