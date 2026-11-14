package com.android.catchtable.domain.model.vote

data class VoteStationResponseModel(
    val name: String,
    val lines: List<String>,
    val distanceMeters: Int
)
