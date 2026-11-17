package com.android.catchtable.presentation.home

import com.android.catchtable.presentation.home.model.HomeCategoryUiModel
import com.android.catchtable.presentation.home.model.HomeLocationUiModel
import com.android.catchtable.presentation.home.model.HomeRecentUiModel
import com.android.catchtable.presentation.home.model.HomeTab
import com.android.catchtable.presentation.home.model.RecommendStoreUiModel
import com.android.catchtable.presentation.home.model.SimilarStoreUiModel

data class HomeUiState(
    val selectedTab: HomeTab = HomeTab.RANKING,
    val categories: List<HomeCategoryUiModel> = emptyList(),
    val locations: List<HomeLocationUiModel> = emptyList(),
    val recentStores: List<HomeRecentUiModel> = emptyList(),
    val similarStores: List<SimilarStoreUiModel> = emptyList(),
    val recommendStores: List<RecommendStoreUiModel> = emptyList(),
    val voteId: Long? = null,
) {
    val isVoting: Boolean
        get() = voteId != null
}