package com.android.catchtable.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.home.component.HomeCategorySection
import com.android.catchtable.presentation.home.component.HomeLocationSection
import com.android.catchtable.presentation.home.component.HomeScrollUpButton
import com.android.catchtable.presentation.home.component.HomeStoreSection
import com.android.catchtable.presentation.home.component.HomeTopBar
import com.android.catchtable.presentation.home.component.HomeVoteStatusButton
import com.android.catchtable.presentation.home.model.HomeBadgeType
import com.android.catchtable.presentation.home.model.HomeCategoryUiModel
import com.android.catchtable.presentation.home.model.HomeLocationUiModel
import com.android.catchtable.presentation.home.model.HomeRecentUiModel
import com.android.catchtable.presentation.home.model.HomeTab
import com.android.catchtable.presentation.home.model.RecommendStoreUiModel
import com.android.catchtable.presentation.home.model.SimilarStoreUiModel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onTabClick: (HomeTab) -> Unit,
    onStoreClick: (Int) -> Unit,
    onVoteClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(CatchTableTheme.colors.white),
    ) {
        HomeTopBar()
        Box(modifier = Modifier.weight(1f)) {
            LazyColumn(
                state = listState, modifier = Modifier.fillMaxSize()
            ) {
                item {
                    Image(
                        painter = painterResource(id = R.drawable.img_home_banner),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(
                                horizontal = 20.dp, vertical = 16.dp
                            )
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                    )
                }

                item {
                    HomeCategorySection(
                        selectedTab = uiState.selectedTab,
                        categories = uiState.categories,
                        onTabClick = onTabClick,
                    )
                }
                item {
                    HorizontalDivider(
                        thickness = 20.dp, color = CatchTableTheme.colors.gray200
                    )
                }
                item {
                    HomeLocationSection(locations = uiState.locations)
                }
                item {
                    HomeStoreSection(
                        recentStores = uiState.recentStores,
                        similarStores = uiState.similarStores,
                        recommendStores = uiState.recommendStores,
                        onStoreClick = onStoreClick,
                    )
                }

            }
            if (uiState.isVoting) {
                HomeVoteStatusButton(
                    onClick = onVoteClick,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
                        .fillMaxWidth()
                )
            }

            HomeScrollUpButton(
                onClick = { coroutineScope.launch { listState.animateScrollToItem(0) } },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 20.dp, bottom = if (uiState.isVoting) 76.dp else 17.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreenPreviewContent(isVoting = false)
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenVotingPreview() {
    HomeScreenPreviewContent(isVoting = true)
}

@Composable
private fun HomeScreenPreviewContent(isVoting: Boolean) {
    CatchTableTheme {
        HomeScreen(
            uiState = HomeUiState(
                selectedTab = HomeTab.RANKING,
                categories = listOf(
                    HomeCategoryUiModel(name = "줄서기예약", imageRes = R.drawable.img_category_01),
                    HomeCategoryUiModel(name = "2026미쉐린", imageRes = R.drawable.img_category_02),
                    HomeCategoryUiModel(name = "블루리본", imageRes = R.drawable.img_category_05),
                    HomeCategoryUiModel(name = "웨이팅TOP", imageRes = R.drawable.img_category_14),
                    HomeCategoryUiModel(name = "예약핫플", imageRes = R.drawable.img_category_03),
                ),
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
                ),

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
                ),
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
                ),
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
                ),
                isVoting = isVoting,
            ),
            onTabClick = {},
            onStoreClick = {},
            onVoteClick = {},
        )
    }
}
