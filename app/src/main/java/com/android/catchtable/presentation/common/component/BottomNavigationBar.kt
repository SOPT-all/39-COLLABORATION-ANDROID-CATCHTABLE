package com.android.catchtable.presentation.common.component

import android.R.attr.text
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.extension.noRippleClickable
import com.android.catchtable.presentation.common.theme.CatchTableTheme


@Composable
fun BottomNavigationBar(
    selectedItem: BottomNavItem,
    onItemClick: (BottomNavItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(CatchTableTheme.colors.white)
            .navigationBarsPadding(),
    ) {
        HorizontalDivider(
            thickness = 1.dp,
            color = CatchTableTheme.colors.gray200
        ) //맨 위 회색 선

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 22.dp,
                    end = 22.dp,
                    top = 7.dp,
                    bottom = 24.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            BottomNavItem.entries.forEach { item ->
                BottomNavTab(
                    item = item,
                    isSelected = item == selectedItem,
                    onClick = { onItemClick(item) },
                    modifier = Modifier.weight(1f),
                )
            }
        }
    }
}

@Composable
private fun BottomNavTab(
    item: BottomNavItem,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val style =
        if (isSelected) CatchTableTheme.typography.captionB10
        else CatchTableTheme.typography.captionMD10
    val icon = if (isSelected) item.selectedIcon else item.unselectedIcon


    Column(
        modifier = modifier
            .noRippleClickable(onClick = onClick),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
        )
        Text(
            text = item.label,
            style = style,
            color = CatchTableTheme.colors.gray900,
        )
    }
}

enum class BottomNavItem(
    val label: String,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
) {
    HOME(
        "홈",
        R.drawable.icon_nav_home_filled,
        R.drawable.icon_nav_home_outline
    ),
    SAVED(
        "저장",
        R.drawable.icon_nav_saved_filled,
        R.drawable.icon_nav_saved_outline
    ),
    NEARBY(
        "내 주변",
        R.drawable.icon_nav_nearby,
        R.drawable.icon_nav_nearby
    ),
    DINING(
        "마이다이닝",
        R.drawable.icon_nav_dining_filled,
        R.drawable.icon_nav_dining_outline
    ),
    MY(
        "my",
        R.drawable.icon_nav_account_filled,
        R.drawable.icon_nav_account_outline
    ),
}


@Preview(showBackground = true, widthDp = 375)
@Composable
private fun BottomNavigationBarPreview() {
    CatchTableTheme {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            BottomNavItem.entries.forEach { item ->
                BottomNavigationBar(
                    selectedItem = item,
                    onItemClick = {},
                )
            }
        }
    }
}
