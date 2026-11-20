package com.android.catchtable.presentation.store.model

data class StoreUiModel(
    val storeId: Long,
    val name: String,
    val category: String,
    val region: String,
    val intro: String,
    val rating: Double,
    val reviewCount: Int,
    val station: StoreStationUiModel,
    val priceRange: String,
    val businessHours: String,
    val phone: String?,
    val imageUrls: List<String>,
    val menus: List<StoreMenuUiModel>,
    val aiSummary: StoreAiSummaryUiModel?,
    val amenities: List<StoreAmenityUiModel>,
    val isOpen: Boolean,
)
