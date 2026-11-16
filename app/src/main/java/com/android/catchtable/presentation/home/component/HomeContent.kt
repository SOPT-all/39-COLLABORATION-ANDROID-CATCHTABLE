package com.android.catchtable.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.home.model.HomeRecentUiModel
import com.android.catchtable.presentation.home.model.RecommendStoreUiModel
import com.android.catchtable.presentation.home.model.SimilarStoreUiModel
import kotlinx.coroutines.launch


@Composable
fun HomeContent(
    recentStores: List<HomeRecentUiModel>,
    similarStores: List<SimilarStoreUiModel>,
    recommendStores: List<RecommendStoreUiModel>,
    isVoting: Boolean,
    modifier: Modifier = Modifier
) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()


    Box(modifier = modifier) {
        LazyColumn(
            state = listState, modifier = Modifier.fillMaxSize()
        ) {
            item {
                Image(
                    painter = painterResource(id = R.drawable.img_home_banner),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(
                            horizontal = 20.dp, vertical = 16.dp
                        )
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                )
            }

            item {
                HomeCategorySection()
            }
            item {
                HorizontalDivider(
                    thickness = 20.dp, color = CatchTableTheme.colors.gray200
                )
            }
            item {
                HomeLocationSection(
                )
            }
            item {
                HomeStoreSection(
                    recentStores = recentStores,
                    similarStores = similarStores,
                    recommendStores = recommendStores
                )
            }

        }
        if (isVoting) {
            HomeVoteStatusButton(
                onClick = {},
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
                    .fillMaxWidth()
            )
        }

        HomeScrollUpButton(
            onClick = { coroutineScope.launch { listState.animateScrollToItem(0) } },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 20.dp, bottom = if (isVoting) 76.dp else 17.dp)
        )
    }
}