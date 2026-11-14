package com.android.catchtable.data.remote.dto.vote.response

import kotlinx.serialization.Serializable

@Serializable
data class VoteStationResponseDto(
    val name: String,
    val lines: List<String>,
    val distanceMeters: Int
)
