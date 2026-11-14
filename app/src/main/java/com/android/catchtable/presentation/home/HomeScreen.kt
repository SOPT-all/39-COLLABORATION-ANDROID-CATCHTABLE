package com.android.catchtable.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.home.component.HomeCategoryItem
import com.android.catchtable.presentation.home.component.HomeHeader
import com.android.catchtable.presentation.home.component.HomeTabBar
import com.android.catchtable.presentation.home.model.HomeCategoryUiModel
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
        HomeHeader(modifier = Modifier.fillMaxWidth())

        Box(modifier = Modifier.weight(1f)) {
            LazyColumn(
                state = listState,
                modifier = Modifier.fillMaxSize(),
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
            .padding(start = 21.dp, top = 23.dp, end = 22.dp, bottom = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        categories.forEach { category ->
            HomeCategoryItem(
                name = category.name, imageRes = category.imageRes
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

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    CatchTableTheme {
        HomeScreen()
    }
}