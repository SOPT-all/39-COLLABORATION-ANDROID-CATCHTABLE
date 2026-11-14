package com.android.catchtable.data.remote.dto.vote.response

import kotlinx.serialization.Serializable

@Serializable
data class VoteDetailStoreResponseDto(
    val storeId: Long,
    val name: String,
    val rating: Float,
    val reviewCount: Int,
    val imageUrls: List<String>,
    val station: VoteStationResponseDto,
    val aiSummary: VoteAiSummaryResponseDto,
    val priceRange: String,
    val representativeMenus: List<VoteRepresentativeMenuResponseDto>,
    val amenities: List<VoteAmenityResponseDto>
)
