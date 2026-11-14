package com.android.catchtable.data.remote.dto.vote.response

import kotlinx.serialization.Serializable

@Serializable
data class VoteAiSummaryResponseDto(
    val title: String,
    val lines: List<String>
)
