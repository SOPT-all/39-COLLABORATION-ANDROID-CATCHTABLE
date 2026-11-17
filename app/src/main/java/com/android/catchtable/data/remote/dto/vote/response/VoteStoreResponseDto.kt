package com.android.catchtable.data.remote.dto.vote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VoteStoreResponseDto(
    @SerialName("storeId") val storeId: Long,
    @SerialName("name") val name: String,
    @SerialName("rating") val rating: Float,
    @SerialName("reviewCount") val reviewCount: Int,
    @SerialName("imageUrls") val imageUrls: List<String>,
    @SerialName("station") val station: VoteStationResponseDto,
    @SerialName("aiSummary") val aiSummary: VoteAiSummaryResponseDto,
    @SerialName("priceRange") val priceRange: String,
    @SerialName("representativeMenus") val representativeMenus: List<VoteRepresentativeMenuResponseDto>,
    @SerialName("amenities") val amenities: List<VoteAmenityResponseDto>
)

@Serializable
data class VoteStationResponseDto(
    @SerialName("name") val name: String,
    @SerialName("lines") val lines: List<String>,
    @SerialName("distanceMeters") val distanceMeters: Int
)

@Serializable
data class VoteAiSummaryResponseDto(
    @SerialName("title") val title: String,
    @SerialName("lines") val lines: List<String>
)

@Serializable
data class VoteRepresentativeMenuResponseDto(
    @SerialName("menuId") val menuId: Long,
    @SerialName("name") val name: String,
    @SerialName("price") val price: Int,
    @SerialName("isPriceFrom") val isPriceFrom: Boolean,
    @SerialName("imageUrl") val imageUrl: String,
    @SerialName("displayOrder") val displayOrder: Int
)

@Serializable
data class VoteAmenityResponseDto(
    @SerialName("category") val category: String,
    @SerialName("content") val content: String
)
