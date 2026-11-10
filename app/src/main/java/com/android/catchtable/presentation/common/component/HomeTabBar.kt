package com.android.catchtable.presentation.common.component

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

val homeTabLabels = listOf("랭킹", "상황별 추천", "캐치단독")

@Composable
fun HomeTabBar(
    selectedTab: String, // 선택된 탭 글자 (밖에서 넘겨줌 : stateless)
    onTabClick: (String) -> Unit, // 눌린 탭 글자 알려줌
    modifier: Modifier = Modifier,
    tabList: List<String> = homeTabLabels,
) {
    // Box -> 바닥 회색선이랑 탭들을 같은 자리에 겹쳐 그리려고
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(CatchTableTheme.colors.white),
    ) {
        HorizontalDivider(
            modifier = Modifier.align(Alignment.BottomCenter), // Box 맨 아래 붙이기
            thickness = 1.dp,
            color = CatchTableTheme.colors.gray100,
        )

        // 탭 3개는 화면에 다 들어가서 스크롤 필요 없음 -> LazyRow 말고 Row + SpaceBetween (피그마처럼 쫙 벌어짐)
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
            .width(93.dp) // 피그마 탭 1칸(밑줄) 폭
            .noRippleClickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally, // 글자 가운데
        verticalArrangement = Arrangement.spacedBy(6.dp), // 글자-밑줄 사이 6
    ) {
        Text(
            text = text,
            style = textStyle,
            color = textColor,
            modifier = Modifier.height(18.dp),
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth() // 탭 폭(93)만큼 꽉
                .height(1.dp)
                // 선택 안 되면 지우지 말고 투명 -> 지우면 높이 1 줄어서 글자 들썩거림
                .background(if (isSelected) CatchTableTheme.colors.gray900 else Color.Transparent),
        )
    }
}

@Preview(showBackground = true, widthDp = 375)
@Composable
private fun HomeTabBarPreview() {
    CatchTableTheme {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            homeTabLabels.forEach { label -> // "랭킹", "상황별 추천", "캐치단독" 하나씩 선택된 버전
                HomeTabBar(
                    selectedTab = label,
                    onTabClick = {},
                )
            }
        }
    }
}
