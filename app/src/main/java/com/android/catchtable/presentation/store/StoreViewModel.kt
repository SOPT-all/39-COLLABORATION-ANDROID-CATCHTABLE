package com.android.catchtable.presentation.store

import androidx.lifecycle.ViewModel
import com.android.catchtable.presentation.store.model.dummyStoreUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class StoreViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(StoreUiState())
    val uiState = _uiState.asStateFlow()

    fun getStoreDetail(storeId: Long) {
        _uiState.update { state ->
            state.copy(
                store = dummyStoreUiModel,
                userCount = 75,
                maxReservationCount = 8,
                photoTabCount = "9,999+",
                reviewTabCount = "4,122",
            )
        }
    }
}