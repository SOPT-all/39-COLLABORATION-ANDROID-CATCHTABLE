package com.android.catchtable.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.common.extension.noRippleClickable
import com.android.catchtable.presentation.common.theme.CatchTableTheme

private val homeTabLabels = listOf("랭킹", "상황별 추천", "캐치단독")

@Composable
fun HomeTabBar(
    selectedTab: String,
    onTabClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    tabList: List<String> = homeTabLabels,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(CatchTableTheme.colors.white),
    ) {
        HorizontalDivider(
            modifier = Modifier.align(Alignment.BottomCenter),
            thickness = 1.dp,
            color = CatchTableTheme.colors.gray100,
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 27.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            tabList.forEach { item ->
                HomeTab(
                    text = item,
                    isSelected = item == selectedTab,
                    onClick = { onTabClick(item) },
                )
            }
        }
    }
}

@Composable
private fun HomeTab(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val textStyle = CatchTableTheme.typography.h3MD14
    val textColor = if (isSelected) CatchTableTheme.colors.gray900 else CatchTableTheme.colors.gray500

    Column(
        modifier = modifier
            .width(93.dp)
            .noRippleClickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        Text(
            text = text,
            style = textStyle,
            color = textColor,
            modifier = Modifier.height(18.dp),
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(if (isSelected) CatchTableTheme.colors.gray900 else Color.Transparent),
        )
    }
}

@Preview(showBackground = true, widthDp = 375)
@Composable
private fun HomeTabBarPreview() {
    CatchTableTheme {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            homeTabLabels.forEach { label ->
                HomeTabBar(
                    selectedTab = label,
                    onTabClick = {},
                )
            }
        }
    }
}
