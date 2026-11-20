package com.android.catchtable.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.catchtable.R
import com.android.catchtable.domain.usecase.vote.GetActiveVoteUseCase
import com.android.catchtable.presentation.home.model.HomeBadgeType
import com.android.catchtable.presentation.home.model.HomeCategoryUiModel
import com.android.catchtable.presentation.home.model.HomeLocationUiModel
import com.android.catchtable.presentation.home.model.HomeRecentUiModel
import com.android.catchtable.presentation.home.model.HomeTab
import com.android.catchtable.presentation.home.model.RecommendStoreUiModel
import com.android.catchtable.presentation.home.model.SimilarStoreUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getActiveVoteUseCase: GetActiveVoteUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getCategories()
        getLocations()
        getRecentStores()
        getSimilarStores()
        getRecommendStores()
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
                        HomeCategoryUiModel(
                            name = "2026미쉐린", imageRes = R.drawable.img_category_02
                        ),
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
                        HomeCategoryUiModel(
                            name = "선착순 1만원", imageRes = R.drawable.img_category_08
                        ),
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

    private fun getRecentStores() {
        _uiState.update {
            it.copy(
                recentStores = listOf(
                    HomeRecentUiModel(
                        id = 1,
                        imageRes = R.drawable.img_home_recent_01,
                        name = "하이디라오 서초점",
                        region = "강남",
                        category = "중식"
                    ),
                    HomeRecentUiModel(
                        id = 2,
                        imageRes = R.drawable.img_home_recent_02,
                        name = "와아",
                        region = "성수",
                        category = "와인"
                    ),
                )
            )
        }
    }

    private fun getSimilarStores() {
        _uiState.update {
            it.copy(
                similarStores = listOf(
                    SimilarStoreUiModel(
                        id = 1,
                        imageRes = R.drawable.img_home_similar_01,
                        name = "하이디라오 서초점",
                        category = "중식",
                        region = "강남",
                        rating = "4.7",
                        reviewCount = "6,139"
                    ),
                    SimilarStoreUiModel(
                        id = 3,
                        imageRes = R.drawable.img_home_similar_02,
                        name = "하이디라오 가산점",
                        category = "중식",
                        region = "가산디지털단지",
                        rating = "4.7",
                        reviewCount = "6,139"
                    ),
                    SimilarStoreUiModel(
                        id = 4,
                        imageRes = R.drawable.img_home_similar_01,
                        name = "징관청훠궈 가로수길",
                        category = "중식",
                        region = "가로수길",
                        rating = "4.6",
                        reviewCount = "18"
                    ),
                )
            )
        }
    }

    private fun getRecommendStores() {
        _uiState.update {
            it.copy(
                recommendStores = listOf(
                    RecommendStoreUiModel(
                        id = 5,
                        imageRes = R.drawable.img_home_recommend_01,
                        name = "만가타",
                        category = "유러피안음식",
                        region = "삼청",
                        rating = "4.8"
                    ),
                    RecommendStoreUiModel(
                        id = 6,
                        imageRes = R.drawable.img_home_recommend_02,
                        name = "만가타",
                        category = "유러피안음식",
                        region = "삼청",
                        rating = "4.8"
                    ),
                )
            )
        }
    }

    fun getActiveVote() {
        viewModelScope.launch {
            getActiveVoteUseCase().onSuccess { activeVote ->
                _uiState.update { it.copy(voteId = activeVote?.voteId) }
            }.onFailure { throwable ->
                Timber.e(throwable, "진행 중인 투표 조회 실패")
            }
        }
    }
}
