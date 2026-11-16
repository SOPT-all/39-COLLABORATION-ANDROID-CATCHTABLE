package com.android.catchtable.presentation.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.home.model.HomeBadgeType
import com.android.catchtable.presentation.home.model.HomeLocationUiModel

@Composable
fun HomeLocationSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(CatchTableTheme.colors.gray200)
            .background(
                CatchTableTheme.colors.white, RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
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
                    name = location.name, imageRes = location.imageRes, badge = location.badge
                )
            }
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