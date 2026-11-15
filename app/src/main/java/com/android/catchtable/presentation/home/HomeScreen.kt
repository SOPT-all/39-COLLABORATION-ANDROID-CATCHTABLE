package com.android.catchtable.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.home.component.HomeContent
import com.android.catchtable.presentation.home.component.HomeTopBar
import com.android.catchtable.presentation.home.model.HomeRecentUiModel
import com.android.catchtable.presentation.home.model.RecommendStoreUiModel
import com.android.catchtable.presentation.home.model.SimilarStoreUiModel
import com.android.catchtable.presentation.main.component.BottomNavigationBar
import com.android.catchtable.presentation.main.model.BottomNavItem

@Composable
fun HomeRoute(modifier: Modifier = Modifier) {
    HomeScreen(
        recentStores = emptyList(),
        similarStores = emptyList(),
        recommendStores = emptyList(),
        modifier = modifier,
    )
}

@Composable
fun HomeScreen(
    recentStores: List<HomeRecentUiModel>,
    similarStores: List<SimilarStoreUiModel>,
    recommendStores: List<RecommendStoreUiModel>,
    modifier: Modifier = Modifier,
    isVoting: Boolean = false,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(CatchTableTheme.colors.white),
    ) {
        HomeTopBar()

        HomeContent(
            recentStores = recentStores,
            similarStores = similarStores,
            recommendStores = recommendStores,
            isVoting = isVoting,
            modifier = Modifier.weight(1f)
        )

        BottomNavigationBar(
            selectedItem = BottomNavItem.HOME,
            onItemClick = {},
        )
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
            recentStores = listOf(
                HomeRecentUiModel(
                    id = 1, thumbnailUrl = null, name = "하이디라오 서초점", region = "강남", category = "중식"
                ),
                HomeRecentUiModel(
                    id = 2, thumbnailUrl = null, name = "와아", region = "성수", category = "와인"
                ),
            ),
            similarStores = listOf(
                SimilarStoreUiModel(
                    id = 1,
                    thumbnailUrl = null,
                    name = "하이디라오 서초점",
                    category = "중식",
                    region = "강남",
                    rating = "4.7",
                    reviewCount = "6,139"
                ),
                SimilarStoreUiModel(
                    id = 3,
                    thumbnailUrl = null,
                    name = "하이디라오 가산점",
                    category = "중식",
                    region = "가산디지털단지",
                    rating = "4.7",
                    reviewCount = "6,139"
                ),
                SimilarStoreUiModel(
                    id = 4,
                    thumbnailUrl = null,
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
                    thumbnailUrl = null,
                    name = "만가타",
                    category = "유러피안음식",
                    region = "삼청",
                    rating = "4.8"
                ),
                RecommendStoreUiModel(
                    id = 6,
                    thumbnailUrl = null,
                    name = "만가타",
                    category = "유러피안음식",
                    region = "삼청",
                    rating = "4.8"
                ),
            ),
            isVoting = isVoting,
        )
    }
}
