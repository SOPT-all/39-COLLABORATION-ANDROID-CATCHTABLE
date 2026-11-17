package com.android.catchtable.presentation.home

import androidx.lifecycle.ViewModel
import com.android.catchtable.R
import com.android.catchtable.presentation.home.model.HomeBadgeType
import com.android.catchtable.presentation.home.model.HomeCategoryUiModel
import com.android.catchtable.presentation.home.model.HomeLocationUiModel
import com.android.catchtable.presentation.home.model.HomeTab
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getCategories()
        getLocations()
        getActiveVote()
    }

    fun onTabClick(tab: HomeTab) {
        _uiState.update { it.copy(selectedTab = tab) }
        getCategories(tab)
    }

    private fun getCategories(tab: HomeTab = HomeTab.RANKING) {
        _uiState.update {
            it.copy(
                categories = when (tab) {
                    HomeTab.RANKING -> listOf(
                        HomeCategoryUiModel(name = "줄서기예약", imageRes = R.drawable.img_category_01),
                        HomeCategoryUiModel(name = "2026미쉐린", imageRes = R.drawable.img_category_02),
                        HomeCategoryUiModel(name = "블루리본", imageRes = R.drawable.img_category_05),
                        HomeCategoryUiModel(name = "웨이팅TOP", imageRes = R.drawable.img_category_14),
                        HomeCategoryUiModel(name = "예약핫플", imageRes = R.drawable.img_category_03),
                    )

                    HomeTab.RECOMMEND -> listOf(
                        HomeCategoryUiModel(name = "데이트맛집", imageRes = R.drawable.img_category_04),
                        HomeCategoryUiModel(name = "신상오픈맛집", imageRes = R.drawable.img_category_11),
                        HomeCategoryUiModel(name = "혼밥맛집", imageRes = R.drawable.img_category_15),
                        HomeCategoryUiModel(name = "야장지도", imageRes = R.drawable.img_category_12),
                        HomeCategoryUiModel(name = "웨이팅맛집", imageRes = R.drawable.img_category_09),
                    )

                    HomeTab.EXCLUSIVE -> listOf(
                        HomeCategoryUiModel(name = "오늘 예약", imageRes = R.drawable.img_category_07),
                        HomeCategoryUiModel(name = "케이크픽업", imageRes = R.drawable.img_category_10),
                        HomeCategoryUiModel(name = "꽃주문", imageRes = R.drawable.img_category_06),
                        HomeCategoryUiModel(name = "선착순 1만원", imageRes = R.drawable.img_category_08),
                        HomeCategoryUiModel(name = "브랜드혜택존", imageRes = R.drawable.img_category_13),
                    )
                }
            )
        }
    }

    private fun getLocations() {
        _uiState.update {
            it.copy(
                locations = listOf(
                    HomeLocationUiModel(
                        name = "청담",
                        imageRes = R.drawable.img_area_cheongdam,
                        badge = HomeBadgeType.TOP
                    ),
                    HomeLocationUiModel(
                        name = "부산", imageRes = R.drawable.img_area_busan, badge = null
                    ),
                    HomeLocationUiModel(
                        name = "강남·역삼",
                        imageRes = R.drawable.img_area_gangnam_yeoksam,
                        badge = HomeBadgeType.TOP
                    ),
                    HomeLocationUiModel(
                        name = "용산·삼각지",
                        imageRes = R.drawable.img_area_yongsan,
                        badge = HomeBadgeType.HOT
                    ),
                )
            )
        }
    }

    private fun getActiveVote() {
        _uiState.update { it.copy(isVoting = true) }
    }
}