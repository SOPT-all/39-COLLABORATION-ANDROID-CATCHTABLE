package com.android.catchtable.presentation.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.common.extension.noRippleClickable
import com.android.catchtable.presentation.common.theme.CatchTableTheme

data class StoreTab(
    val label: String,
    val count: String? = null,
)

val storeTabList = listOf(
    StoreTab("홈"),
    StoreTab("소식"),
    StoreTab("메뉴"),
    StoreTab("사진", "9,999+"),
    StoreTab("리뷰", "4,122"),
    StoreTab("방송"),
)

@Composable
fun StoreTabBar(
    selectedTab: String,
    onTabClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    tabList: List<StoreTab> = storeTabList,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(44.dp)
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
                .fillMaxHeight()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            tabList.forEach { tab ->
                StoreTabItem(
                    tab = tab,
                    isSelected = tab.label == selectedTab,
                    onClick = { onTabClick(tab.label) },
                )
            }
        }
    }
}

@Composable
private fun StoreTabItem(
    tab: StoreTab,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val textStyle =
        if (isSelected) CatchTableTheme.typography.h1SB16 else CatchTableTheme.typography.h1RG16
    val textColor = if (isSelected) CatchTableTheme.colors.black else CatchTableTheme.colors.gray500

    Column(
        modifier = modifier
            .fillMaxHeight()
            .width(IntrinsicSize.Max)
            .noRippleClickable(onClick = onClick),
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = tab.label,
                style = textStyle,
                color = textColor,
            )
            tab.count?.let { count ->
                Text(
                    text = count,
                    style = CatchTableTheme.typography.h3MD14,
                    color = CatchTableTheme.colors.gray500,
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(if (isSelected) CatchTableTheme.colors.black else Color.Transparent),
        )
    }
}

@Preview(showBackground = true, widthDp = 375)
@Composable
private fun StoreTabBarPreview() {
    CatchTableTheme {
        var selectedTab by remember { mutableStateOf("홈") }
        StoreTabBar(
            selectedTab = selectedTab,
            onTabClick = { selectedTab = it },
        )
    }
}
