package com.android.catchtable.presentation.store.model

data class StoreStationUiModel(
    val name: String,
    val lines: List<String>,
    val distanceMeters: Int,
)