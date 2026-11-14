package com.android.catchtable.presentation.home

import android.R.attr.top
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.home.component.HomeBadge
import com.android.catchtable.presentation.home.component.HomeCategoryItem
import com.android.catchtable.presentation.home.component.HomeHeader
import com.android.catchtable.presentation.home.component.HomeSearchTextField
import com.android.catchtable.presentation.home.component.HomeTabBar
import com.android.catchtable.presentation.home.component.HomeVoteStatusButton
import com.android.catchtable.presentation.home.model.HomeBadgeType
import com.android.catchtable.presentation.home.model.HomeCategoryUiModel
import com.android.catchtable.presentation.home.model.HomeLocationUiModel
import com.android.catchtable.presentation.home.model.HomeTab
import com.android.catchtable.presentation.main.component.BottomNavigationBar
import com.android.catchtable.presentation.main.model.BottomNavItem

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()
    var selectedTab by remember { mutableStateOf(HomeTab.RANKING) }

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
                    .padding(start=49.dp, end=78.dp)
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
                            LazyRow() {}
                            LazyRow() {}
                        }
                    }

                }
            }
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
                painter = painterResource(id = R.drawable.ic_vote_next),
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
    CatchTableTheme {
        HomeScreen()
    }
}
