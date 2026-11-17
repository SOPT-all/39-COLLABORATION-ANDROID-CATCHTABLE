package com.android.catchtable.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.common.extension.noRippleClickable
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.home.model.HomeRecentUiModel
import com.android.catchtable.presentation.home.model.RecommendStoreUiModel
import com.android.catchtable.presentation.home.model.SimilarStoreUiModel

@Composable
fun HomeStoreSection(
    recentStores: List<HomeRecentUiModel>,
    similarStores: List<SimilarStoreUiModel>,
    recommendStores: List<RecommendStoreUiModel>,
    onStoreClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    var selectedRecentId by remember {
        mutableIntStateOf(1)
    }
    Column(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 28.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            HomeSectionHeader(
                title = "최근 본 매장과 비슷한 곳",
                actionText = "최근 본 매장",
            )
            Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(recentStores) { recent ->
                        HomeStoreItem(
                            recent = recent,
                            isSelected = recent.id == selectedRecentId,
                            onClick = { selectedRecentId = recent.id },
                        )
                    }
                }
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(similarStores) { store ->
                        HomeCardSimilar(
                            store = store,
                            onCardClick = onStoreClick,
                            modifier = Modifier.width(128.dp),
                        )
                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 28.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            HomeSectionHeader(
                title = "윤린우님이 좋아할 맛집",
                actionText = "전체보기",
                subtitle = "마음에 들 만한 곳으로 모았어요",
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(15.dp),
            ) {
                recommendStores.forEach { store ->
                    HomeCardRecommended(
                        store = store,
                        modifier = Modifier.weight(1f),
                    )
                }
            }
        }
    }
}

@Composable
private fun HomeStoreItem(
    recent: HomeRecentUiModel,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .width(222.dp)
            .border(
                width = 1.dp,
                color = if (isSelected) CatchTableTheme.colors.gray500 else CatchTableTheme.colors.gray100,
                shape = RoundedCornerShape(12.dp)
            )
            .noRippleClickable(onClick = onClick)
            .padding(horizontal = 9.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Image(
            painter = painterResource(id = recent.imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(8.dp)),
        )
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(
                text = recent.name,
                style = CatchTableTheme.typography.h3SB14,
                color = CatchTableTheme.colors.gray900,
            )
            Text(
                text = recent.region,
                style = CatchTableTheme.typography.bodyRG12,
                color = CatchTableTheme.colors.gray500,
            )
        }
    }
}
