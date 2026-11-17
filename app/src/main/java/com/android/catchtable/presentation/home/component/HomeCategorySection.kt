package com.android.catchtable.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.home.model.HomeCategoryUiModel
import com.android.catchtable.presentation.home.model.HomeTab

@Composable
fun HomeCategorySection(
    selectedTab: HomeTab,
    categories: List<HomeCategoryUiModel>,
    onTabClick: (HomeTab) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        HomeTabBar(
            selectedTab = selectedTab,
            onTabClick = onTabClick,
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