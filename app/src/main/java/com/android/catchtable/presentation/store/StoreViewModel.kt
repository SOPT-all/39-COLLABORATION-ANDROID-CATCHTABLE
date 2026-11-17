package com.android.catchtable.presentation.store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.catchtable.domain.usecase.store.GetStoreDetailUseCase
import com.android.catchtable.presentation.store.model.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class StoreViewModel @Inject constructor(
    private val getStoreDetailUseCase: GetStoreDetailUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(StoreUiState())
    val uiState = _uiState.asStateFlow()

    fun getStoreDetail(storeId: Long) {
        viewModelScope.launch {
            getStoreDetailUseCase(storeId)
                .onSuccess { storeDetail ->
                    _uiState.update { state ->
                        state.copy(
                            store = storeDetail.toUiModel(),
                            userCount = 75,
                            maxReservationCount = 8,
                            photoTabCount = "9,999+",
                            reviewTabCount = "4,122",
                        )
                    }
                }
                .onFailure { throwable ->
                    Timber.e(throwable, "가게 상세 조회 실패")
                }
        }
    }
}