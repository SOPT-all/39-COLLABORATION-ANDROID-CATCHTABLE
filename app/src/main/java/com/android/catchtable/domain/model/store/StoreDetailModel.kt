package com.android.catchtable.domain.model.store

data class StoreDetailModel(
    val storeId: Long,
    val name: String,
    val category: String,
    val region: String,
    val intro: String,
    val rating: Double,
    val reviewCount: Int,
    val station: StoreStationModel,
    val priceRange: String,
    val businessHours: String,
    val phone: String?,
    val imageUrls: List<String>,
    val representativeMenus: List<StoreRepresentativeMenuModel>,
    val aiSummary: StoreAiSummaryModel?,
    val amenities: List<StoreAmenityModel>,
)

data class StoreStationModel(
    val name: String,
    val lines: List<String>,
    val distanceMeters: Int,
)

data class StoreRepresentativeMenuModel(
    val menuId: Long,
    val name: String,
    val price: Int,
    val isPriceFrom: Boolean,
    val imageUrl: String,
    val displayOrder: Int,
)

data class StoreAiSummaryModel(
    val title: String,
    val lines: List<String>,
)

data class StoreAmenityModel(
    val category: String,
    val content: String,
)