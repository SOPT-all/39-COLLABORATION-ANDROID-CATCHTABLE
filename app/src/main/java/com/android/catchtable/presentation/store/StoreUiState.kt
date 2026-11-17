package com.android.catchtable.presentation.store

import com.android.catchtable.presentation.store.model.StoreUiModel

data class StoreUiState(
    val store: StoreUiModel? = null,
    val userCount: Int = 0,
    val maxReservationCount: Int = 0,
    val photoTabCount: String = "",
    val reviewTabCount: String = "",
)