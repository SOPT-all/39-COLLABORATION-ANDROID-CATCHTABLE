package com.android.catchtable.domain.model.vote

data class VoteStoreModel(
    val storeId: Long,
    val name: String,
    val rating: Float,
    val reviewCount: Int,
    val imageUrls: List<String>,
    val station: VoteStationModel,
    val aiSummary: VoteAiSummaryModel?,
    val priceRange: String,
    val representativeMenus: List<VoteRepresentativeMenuModel>,
    val amenities: List<VoteAmenityModel>
)

data class VoteStationModel(
    val name: String,
    val lines: List<String>,
    val distanceMeters: Int
)

data class VoteAiSummaryModel(
    val title: String,
    val lines: List<String>
)

data class VoteRepresentativeMenuModel(
    val menuId: Long,
    val name: String,
    val price: Int,
    val isPriceFrom: Boolean,
    val imageUrl: String,
    val displayOrder: Int
)

data class VoteAmenityModel(
    val category: String,
    val content: String
)
