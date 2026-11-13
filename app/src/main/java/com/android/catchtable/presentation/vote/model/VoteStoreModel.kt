package com.android.catchtable.presentation.vote.model


//Vote에서 사용하는 Store 정보만 Data class로 정의
data class VoteStoreModel(
    val storeId: Long,
    val name: String,
    val region: String,
    val intro: String,
    val rating: Float,
    val reviewCount: String,
    val station: StationModel,
    val priceRange: String,
    val imageUrls: String,
    val representativeMenu: List<RepresentativeMenusModel>,
    val aiSummary: AiSummaryModel?=null,
    val amenities: AmenitiesModel
)

data class StationModel(
    val name: String,
    val lines: List<String>,
    val distanceMeters: Int
)

data class RepresentativeMenusModel(
    val menuId: Long,
    val name: String,
    val price: Int,
    val isPriceFrom: Boolean,
    val imageUrl: String,
    val displayOrder: Int
)

data class AiSummaryModel(
    val title: String,
    val lines: String
)

data class AmenitiesModel(
    val category: String,
    val content: String
)
