package com.android.catchtable.presentation.store.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import com.android.catchtable.presentation.store.model.StoreTab

@Composable
fun StoreTabBar(
    selectedTab: StoreTab,
    onTabClick: (StoreTab) -> Unit,
    modifier: Modifier = Modifier,
    photoCount: String? = null,
    reviewCount: String? = null,
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
                .padding(horizontal = 21.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            StoreTab.entries.forEach { tab ->
                val count = when (tab) {
                    StoreTab.PHOTO -> photoCount
                    StoreTab.REVIEW -> reviewCount
                    else -> null
                }
                StoreTabItem(
                    tab = tab,
                    count = count,
                    isSelected = tab == selectedTab,
                    onClick = { onTabClick(tab) },
                )
            }
        }
    }
}

@Composable
private fun StoreTabItem(
    tab: StoreTab,
    count: String?,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val textStyle =
        if (isSelected) CatchTableTheme.typography.h1SB16 else CatchTableTheme.typography.h1RG16
    val textColor = if (isSelected) CatchTableTheme.colors.black else CatchTableTheme.colors.gray500

    Column(
        modifier = modifier
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
            count?.let {
                Text(
                    text = it,
                    style = CatchTableTheme.typography.h3MD14,
                    color = CatchTableTheme.colors.gray500,
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

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
        var selectedTab by remember { mutableStateOf(StoreTab.HOME) }
        StoreTabBar(
            selectedTab = selectedTab,
            onTabClick = { selectedTab = it },
            photoCount = "9,999+",
            reviewCount = "4,122",
        )
    }
}
