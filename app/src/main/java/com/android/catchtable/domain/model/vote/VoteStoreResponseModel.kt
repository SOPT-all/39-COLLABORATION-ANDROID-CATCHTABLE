package com.android.catchtable.domain.model.vote

data class VoteStoreResponseModel(
    val storeId: Long,
    val name: String,
    val rating: Float,
    val reviewCount: Int,
    val imageUrls: List<String>,
    val station: VoteStationResponseModel,
    val aiSummary: VoteAiSummaryModel,
    val priceRange: String,
    val representativeMenus: List<VoteRepresentativeMenuResponseModel>,
    val amenities: List<VoteAmenityResponseModel>
)

data class VoteStationResponseModel(
    val name: String,
    val lines: List<String>,
    val distanceMeters: Int
)

data class VoteAiSummaryModel(
    val title: String,
    val lines: List<String>
)

data class VoteRepresentativeMenuResponseModel(
    val menuId: Long,
    val name: String,
    val price: Int,
    val isPriceFrom: Boolean,
    val imageUrl: String,
    val displayOrder: Int
)

data class VoteAmenityResponseModel(
    val category: String,
    val content: String
)
