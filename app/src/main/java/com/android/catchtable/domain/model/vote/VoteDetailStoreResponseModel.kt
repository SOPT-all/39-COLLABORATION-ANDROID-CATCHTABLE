package com.android.catchtable.domain.model.vote

data class VoteDetailStoreResponseModel(
    val storeId: Long,
    val name: String,
    val rating: Float,
    val reviewCount: Int,
    val imageUrls: List<String>,
    val station: VoteStationResponseModel,
    val aiSummary: VoteAiSummaryResponseModel,
    val priceRange: String,
    val representativeMenus: List<VoteRepresentativeMenuResponseModel>,
    val amenities: List<VoteAmenityResponseModel>
)
