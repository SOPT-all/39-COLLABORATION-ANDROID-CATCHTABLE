package com.android.catchtable.presentation.common.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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

enum class BottomNavItem(
    val label: String,
    @DrawableRes val selectedIcon: Int,   // 선택됐을 때 (꽉 찬 아이콘)
    @DrawableRes val unselectedIcon: Int, // 선택 안 됐을 때 (테두리 아이콘)
) {
    HOME("홈", R.drawable.icon_nav_home_filled, R.drawable.icon_nav_home_outline),
    SAVED("저장", R.drawable.icon_nav_saved_filled, R.drawable.icon_nav_saved_outline),
    NEARBY("내 주변", R.drawable.icon_nav_nearby, R.drawable.icon_nav_nearby),
    DINING("마이다이닝", R.drawable.icon_nav_dining_filled, R.drawable.icon_nav_dining_outline),
    MY("my", R.drawable.icon_nav_account_filled, R.drawable.icon_nav_account_outline),
}

@Composable
private fun BottomNavTab(
    //탭 한 개
    item: BottomNavItem, //어떤 탭인지
    isSelected: Boolean, // 선택됐는지
    onClick: () -> Unit, // 선택됐을 때
) {
    Column(
        modifier = Modifier
            .size(44.dp)
            .noRippleClickable(onClick = onClick), //누를때 물결효과 x
        horizontalAlignment = Alignment.CenterHorizontally, // 가로로 정렬
        verticalArrangement = Arrangement.spacedBy(4.dp), //아이콘과 글자사이
    ) {
        Icon(
            painter = painterResource(
                id =
                    if (isSelected) item.selectedIcon
                    else item.unselectedIcon
            ),
            contentDescription = item.label,
        )
        Text(
            text = item.label,
            style =
                if (isSelected) CatchTableTheme.typography.captionB10
                else CatchTableTheme.typography.captionMD10,
            color = CatchTableTheme.colors.gray900,
        )
    }
}

@Composable
fun BottomNavigationBar(
    selectedItem: BottomNavItem, // 선택된 탭(밖에서 넘겨줌 : stateless)
    onItemClick: (BottomNavItem) -> Unit, // 선택됐을 때 어떤 탭인지 알려줌
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(CatchTableTheme.colors.white),
    ) {
        HorizontalDivider(thickness = 1.dp, color = CatchTableTheme.colors.gray200) //맨 위 회색 선

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 22.dp,
                    end = 22.dp,
                    top = 7.dp,
                    bottom = 24.dp
                ), //선이 1dp여서 top 7로 설정
            horizontalArrangement = Arrangement.SpaceBetween, //탭끼리 간격 벌리기
        ) {
            BottomNavItem.entries.forEach { item -> //각각의 탭에 접근
                BottomNavTab(
                    item = item,
                    isSelected = item == selectedItem, // 선택됐는지
                    onClick = { onItemClick(item) },
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 375)
@Composable
private fun BottomNavigationBarPreview() {
    CatchTableTheme {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) { // 바 5개 위아래로, 사이 8
            BottomNavItem.entries.forEach { item ->                // 탭 5개 하나씩 꺼내서
                BottomNavigationBar(
                    selectedItem = item,
                    onItemClick = {},
                )
            }
        }
    }
}
