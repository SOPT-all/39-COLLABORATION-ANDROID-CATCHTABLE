package com.android.catchtable.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.home.model.HomeCategoryUiModel
import com.android.catchtable.presentation.home.model.HomeTab

@Composable
fun HomeCategorySection(
    modifier: Modifier = Modifier,
) {
    var selectedTab by remember { mutableStateOf(HomeTab.RANKING) }
    val categories = when (selectedTab) {
        HomeTab.RANKING -> rankingCategories
        HomeTab.RECOMMEND -> recommendCategories
        HomeTab.EXCLUSIVE -> exclusiveCategories
    }

    Column(
        modifier = modifier
    ) {
        HomeTabBar(
            selectedTab = selectedTab,
            onTabClick = { selectedTab = it },
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Row(
            modifier = Modifier
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

