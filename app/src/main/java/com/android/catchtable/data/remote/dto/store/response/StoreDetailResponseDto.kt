package com.android.catchtable.data.remote.dto.store.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StoreDetailResponseDto(
    @SerialName("storeId") val storeId: Long,
    @SerialName("name") val name: String,
    @SerialName("category") val category: String,
    @SerialName("region") val region: String,
    @SerialName("intro") val intro: String,
    @SerialName("rating") val rating: Double,
    @SerialName("reviewCount") val reviewCount: Int,
    @SerialName("station") val station: StoreStationResponseDto,
    @SerialName("priceRange") val priceRange: String,
    @SerialName("businessHours") val businessHours: String,
    @SerialName("phone") val phone: String? = null,
    @SerialName("imageUrls") val imageUrls: List<String>,
    @SerialName("representativeMenus") val representativeMenus: List<StoreRepresentativeMenuResponseDto>,
    @SerialName("aiSummary") val aiSummary: StoreAiSummaryResponseDto? = null,
    @SerialName("amenities") val amenities: List<StoreAmenityResponseDto>,
)

@Serializable
data class StoreStationResponseDto(
    @SerialName("name") val name: String,
    @SerialName("lines") val lines: List<String>,
    @SerialName("distanceMeters") val distanceMeters: Int,
)

@Serializable
data class StoreRepresentativeMenuResponseDto(
    @SerialName("menuId") val menuId: Long,
    @SerialName("name") val name: String,
    @SerialName("price") val price: Int,
    @SerialName("isPriceFrom") val isPriceFrom: Boolean,
    @SerialName("imageUrl") val imageUrl: String,
    @SerialName("displayOrder") val displayOrder: Int,
)

@Serializable
data class StoreAiSummaryResponseDto(
    @SerialName("title") val title: String,
    @SerialName("lines") val lines: List<String>,
)

@Serializable
data class StoreAmenityResponseDto(
    @SerialName("category") val category: String,
    @SerialName("content") val content: String,
)