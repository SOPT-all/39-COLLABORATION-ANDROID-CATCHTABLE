package com.android.catchtable.presentation.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.component.CatchTableAsyncImage
import com.android.catchtable.presentation.common.extension.noRippleClickable
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.home.component.HomeBadge
import com.android.catchtable.presentation.home.component.HomeCardRecommended
import com.android.catchtable.presentation.home.component.HomeCardSimilar
import com.android.catchtable.presentation.home.component.HomeCategoryItem
import com.android.catchtable.presentation.home.component.HomeHeader
import com.android.catchtable.presentation.home.component.HomeScrollUpButton
import com.android.catchtable.presentation.home.component.HomeSearchTextField
import com.android.catchtable.presentation.home.component.HomeTabBar
import com.android.catchtable.presentation.home.component.HomeVoteStatusButton
import com.android.catchtable.presentation.home.model.HomeBadgeType
import com.android.catchtable.presentation.home.model.HomeCategoryUiModel
import com.android.catchtable.presentation.home.model.HomeLocationUiModel
import com.android.catchtable.presentation.home.model.HomeRecentUiModel
import com.android.catchtable.presentation.home.model.HomeTab
import com.android.catchtable.presentation.home.model.RecommendStoreUiModel
import com.android.catchtable.presentation.home.model.SimilarStoreUiModel
import com.android.catchtable.presentation.main.component.BottomNavigationBar
import com.android.catchtable.presentation.main.model.BottomNavItem
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    recentStores: List<HomeRecentUiModel>,
    similarStores: List<SimilarStoreUiModel>,
    recommendStores: List<RecommendStoreUiModel>,
    modifier: Modifier = Modifier,
    isVoting: Boolean = false,
) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var selectedTab by remember { mutableStateOf(HomeTab.RANKING) }
    var selectedRecentId by remember { mutableIntStateOf(1) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(CatchTableTheme.colors.white),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp)
        ) {
            HomeHeader(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterStart)
            )
            HomeSearchTextField(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 49.dp, end = 78.dp)
                    .fillMaxWidth()
            )
        }

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
                    HomeTabBar(
                        selectedTab = selectedTab,
                        onTabClick = { selectedTab = it },
                        modifier = Modifier.padding(horizontal = 20.dp)
                    )
                }
                item {
                    HomeCategorySection(
                        categories = when (selectedTab) {
                            HomeTab.RANKING -> rankingCategories
                            HomeTab.RECOMMEND -> recommendCategories
                            HomeTab.EXCLUSIVE -> exclusiveCategories
                        },
                    )
                }
                item {
                    HorizontalDivider(
                        thickness = 20.dp, color = CatchTableTheme.colors.gray200
                    )
                }
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(CatchTableTheme.colors.gray200)
                            .background(
                                CatchTableTheme.colors.white,
                                RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
                            )
                            .padding(top = 38.dp, bottom = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        HomeSectionHeader(
                            title = "어디로 가시나요?",
                            actionText = "전체보기",
                            titleIcon = R.drawable.ic_home_destination,
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            locationList.forEach { location ->
                                HomeLocationItem(
                                    name = location.name,
                                    imageRes = location.imageRes,
                                    badge = location.badge
                                )
                            }
                        }
                    }
                }
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp, bottom = 28.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        HomeSectionHeader(
                            title = "최근 본 매장과 비슷한 곳",
                            actionText = "최근 본 매장",
                        )
                        Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                            LazyRow(
                                contentPadding = PaddingValues(horizontal = 20.dp),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                items(recentStores) { recent ->
                                    HomeRecentItem(
                                        recent = recent,
                                        isSelected = recent.id == selectedRecentId,
                                        onClick = { selectedRecentId = recent.id },
                                    )
                                }
                            }
                            LazyRow(
                                contentPadding = PaddingValues(horizontal = 20.dp),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                items(similarStores) { store ->
                                    HomeCardSimilar(
                                        store = store,
                                        onCardClick = {},
                                        modifier = Modifier.width(128.dp),
                                    )
                                }
                            }
                        }

                    }
                }
                item() {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp, bottom = 28.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                    ) {
                        HomeSectionHeader(
                            title = "윤린우님이 좋아할 맛집",
                            actionText = "전체보기",
                            subtitle = "마음에 들 만한 곳으로 모았어요",
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp),
                            horizontalArrangement = Arrangement.spacedBy(15.dp),
                        ) {
                            recommendStores.forEach { store ->
                                HomeCardRecommended(
                                    store = store,
                                    modifier = Modifier.weight(1f),
                                )
                            }
                        }
                    }
                }
            }
            if (isVoting) {
                HomeVoteStatusButton(
                    onClick = {},
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
                    .padding(end = 20.dp, bottom = if (isVoting) 76.dp else 17.dp)
            )
        }

        BottomNavigationBar(
            selectedItem = BottomNavItem.HOME,
            onItemClick = {},
        )
    }
}

@Composable
private fun HomeCategorySection(
    categories: List<HomeCategoryUiModel>,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(CatchTableTheme.colors.gray200)
            .background(
                CatchTableTheme.colors.white,
                RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
            )
            .padding(start = 21.dp, top = 23.dp, end = 22.dp, bottom = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        categories.forEach { category ->
            HomeCategoryItem(
                name = category.name, imageRes = category.imageRes
            )
        }
    }
}

@Composable
private fun HomeSectionHeader(
    title: String,
    actionText: String,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
    @DrawableRes titleIcon: Int? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    text = title,
                    style = CatchTableTheme.typography.displayB18,
                    color = CatchTableTheme.colors.gray900,
                )
                if (titleIcon != null) {
                    Icon(
                        painter = painterResource(id = titleIcon),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        tint = Color.Unspecified,
                    )
                }
            }
            if (subtitle != null) {
                Text(
                    text = subtitle,
                    style = CatchTableTheme.typography.h3RG14,
                    color = CatchTableTheme.colors.gray500,
                )
            }
        }
        Row(
            modifier = Modifier.padding(top = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(
                text = actionText,
                style = CatchTableTheme.typography.h3MD14,
                color = CatchTableTheme.colors.gray800,
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_home_next),
                contentDescription = null,
                modifier = Modifier.size(12.dp),
                tint = CatchTableTheme.colors.gray800,
            )
        }
    }
}

@Composable
private fun HomeLocationItem(
    name: String,
    @DrawableRes imageRes: Int,
    modifier: Modifier = Modifier,
    badge: HomeBadgeType? = null,
) {
    Column(
        modifier = modifier.width(64.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Box {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(20.dp)),
            )
            if (badge != null) {
                HomeBadge(
                    type = badge,
                    modifier = Modifier.align(Alignment.BottomStart),
                )
            }
        }
        Text(
            text = name,
            style = CatchTableTheme.typography.bodyMD12,
            color = CatchTableTheme.colors.gray900,
        )
    }
}

@Composable
private fun HomeRecentItem(
    recent: HomeRecentUiModel,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .width(222.dp)
            .border(
                width = 1.dp,
                color = if (isSelected) CatchTableTheme.colors.gray500 else CatchTableTheme.colors.gray100,
                shape = RoundedCornerShape(12.dp)

            )
            .noRippleClickable(onClick = onClick)
            .padding(horizontal = 9.dp, vertical = 8.dp),

        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        CatchTableAsyncImage(
            imgUrl = recent.thumbnailUrl,
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(
                text = recent.name,
                style = CatchTableTheme.typography.h3SB14,
                color = CatchTableTheme.colors.gray900,
            )
            Text(
                text = recent.region,
                style = CatchTableTheme.typography.bodyRG12,
                color = CatchTableTheme.colors.gray500,
            )
        }
    }
}

private val rankingCategories = listOf(
    HomeCategoryUiModel(name = "줄서기예약", imageRes = R.drawable.img_category_01),
    HomeCategoryUiModel(name = "2026미쉐린", imageRes = R.drawable.img_category_02),
    HomeCategoryUiModel(name = "블루리본", imageRes = R.drawable.img_category_05),
    HomeCategoryUiModel(name = "웨이팅TOP", imageRes = R.drawable.img_category_14),
    HomeCategoryUiModel(name = "예약핫플", imageRes = R.drawable.img_category_03),
)

private val recommendCategories = listOf(
    HomeCategoryUiModel(name = "데이트맛집", imageRes = R.drawable.img_category_04),
    HomeCategoryUiModel(name = "신상오픈맛집", imageRes = R.drawable.img_category_11),
    HomeCategoryUiModel(name = "혼밥맛집", imageRes = R.drawable.img_category_15),
    HomeCategoryUiModel(name = "야장지도", imageRes = R.drawable.img_category_12),
    HomeCategoryUiModel(name = "웨이팅맛집", imageRes = R.drawable.img_category_09),
)

private val exclusiveCategories = listOf(
    HomeCategoryUiModel(name = "오늘 예약", imageRes = R.drawable.img_category_07),
    HomeCategoryUiModel(name = "케이크픽업", imageRes = R.drawable.img_category_10),
    HomeCategoryUiModel(name = "꽃주문", imageRes = R.drawable.img_category_06),
    HomeCategoryUiModel(name = "선착순 1만원", imageRes = R.drawable.img_category_08),
    HomeCategoryUiModel(name = "브랜드혜택존", imageRes = R.drawable.img_category_13),
)

private val locationList = listOf(
    HomeLocationUiModel(
        name = "청담", imageRes = R.drawable.img_area_cheongdam, badge = HomeBadgeType.TOP
    ),
    HomeLocationUiModel(name = "부산", imageRes = R.drawable.img_area_busan, badge = null),
    HomeLocationUiModel(
        name = "강남·역삼", imageRes = R.drawable.img_area_gangnam_yeoksam, badge = HomeBadgeType.TOP
    ),
    HomeLocationUiModel(
        name = "용산·삼각지", imageRes = R.drawable.img_area_yongsan, badge = HomeBadgeType.HOT
    ),
)

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
