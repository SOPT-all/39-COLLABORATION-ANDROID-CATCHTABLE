package com.android.catchtable.presentation.home

import com.android.catchtable.presentation.home.model.HomeCategoryUiModel
import com.android.catchtable.presentation.home.model.HomeLocationUiModel
import com.android.catchtable.presentation.home.model.HomeTab

data class HomeUiState(
    val selectedTab: HomeTab = HomeTab.RANKING,
    val categories: List<HomeCategoryUiModel> = emptyList(),
    val locations: List<HomeLocationUiModel> = emptyList(),
    val isVoting: Boolean = false,
)