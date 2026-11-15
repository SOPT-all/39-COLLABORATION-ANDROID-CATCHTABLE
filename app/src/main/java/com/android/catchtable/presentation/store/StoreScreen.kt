package com.android.catchtable.presentation.store

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.store.component.StoreBottomBar
import com.android.catchtable.presentation.store.component.StoreHeader
import com.android.catchtable.presentation.store.component.StoreTabBar
import com.android.catchtable.presentation.store.model.StoreAiSummaryUiModel
import com.android.catchtable.presentation.store.model.StoreMenuUiModel
import com.android.catchtable.presentation.store.model.StoreStationUiModel
import com.android.catchtable.presentation.store.model.StoreTab
import com.android.catchtable.presentation.store.model.StoreUiModel
import com.android.catchtable.presentation.store.section.StoreAiSummarySection
import com.android.catchtable.presentation.store.section.StoreChipSection
import com.android.catchtable.presentation.store.section.StoreInfoSection
import com.android.catchtable.presentation.store.section.StoreMenuSection
import com.android.catchtable.presentation.store.section.StorePhotoSection
import com.android.catchtable.presentation.store.section.StoreTitleSection

@Composable
fun StoreScreen(
    store: StoreUiModel,
    userCount: Int,
    maxReservationCount: Int,
    photoTabCount: String,
    reviewTabCount: String,
    onBackClick: () -> Unit,
    onTogetherClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var selectedTab by remember { mutableStateOf(StoreTab.HOME) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = CatchTableTheme.colors.white),
    ) {
        StoreHeader(
            onBackClick = onBackClick,
            modifier = Modifier.fillMaxWidth(),
        )

        LazyColumn(
            modifier = Modifier.weight(1f),
        ) {
            item {
                StorePhotoSection(
                    photoUrls = store.imageUrls,
                    userCount = userCount,
                    modifier = Modifier.padding(top = 12.dp),
                )
            }

            item {
                StoreTitleSection(
                    storeName = store.name,
                    rating = store.rating,
                    reviewCount = store.reviewCount,
                    area = store.region,
                    category = store.category,
                    description = store.intro,
                    onTogetherClick = onTogetherClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp, top = 16.dp),
                )
            }

            item {
                HorizontalDivider(
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 16.dp),
                    thickness = 1.dp,
                    color = CatchTableTheme.colors.gray200,
                )
            }

            item {
                StoreInfoSection(
                    station = store.station,
                    priceRange = store.priceRange,
                    businessHours = store.businessHours,
                    phone = store.phone,
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 16.dp),
                )
            }

            item {
                StoreChipSection(
                    maxReservationCount = maxReservationCount,
                    facilities = store.amenities,
                    modifier = Modifier.padding(top = 16.dp),
                )
            }

            item {
                HorizontalDivider(
                    modifier = Modifier.padding(top = 12.dp),
                    thickness = 8.dp,
                    color = CatchTableTheme.colors.gray100,
                )
            }

            stickyHeader {
                StoreTabBar(
                    selectedTab = selectedTab,
                    onTabClick = { tab -> selectedTab = tab },
                    photoCount = photoTabCount,
                    reviewCount = reviewTabCount,
                )
            }

            item {
                StoreMenuSection(
                    menus = store.menus,
                    modifier = Modifier.padding(top = 20.dp),
                )
            }

            item {
                HorizontalDivider(
                    modifier = Modifier.padding(top = 22.dp),
                    thickness = 8.dp,
                    color = CatchTableTheme.colors.gray100,
                )
            }

            store.aiSummary?.let { aiSummary ->
                item {
                    StoreAiSummarySection(
                        summaryTitle = aiSummary.title,
                        summaries = aiSummary.lines,
                        modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 28.dp, bottom = 75.dp),
                    )
                }
            }
        }

        StoreBottomBar(
            onButtonClick = {},
            enabled = false,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun StoreScreenPreview() {
    CatchTableTheme {
        StoreScreen(
            store = StoreUiModel(
                storeId = 1,
                name = "하이디라오 서초점",
                category = "중식",
                region = "강남",
                intro = "중국에서 시작해 전 세계에서 사랑받는 훠궈 브랜드, 하이디라오 훠궈",
                rating = "4.7",
                reviewCount = "6,204",
                station = StoreStationUiModel(
                    name = "신논현역",
                    lines = listOf("9", "신분당"),
                    distanceMeters = 221,
                ),
                priceRange = "점심 저녁 동일가 3 - 5만원",
                businessHours = "매일 10:00 - 07:00",
                phone = "0507-1350-8260",
                imageUrls = listOf("", ""),
                menus = listOf(
                    StoreMenuUiModel(
                        id = 1,
                        storeId = 1,
                        imgUrl = null,
                        name = "소기름훠궈",
                        price = "9,000",
                        isPriceFrom = true,
                    ),
                    StoreMenuUiModel(
                        id = 2,
                        storeId = 1,
                        imgUrl = null,
                        name = "청유마라훠궈",
                        price = "9,000",
                        isPriceFrom = true,
                    ),
                    StoreMenuUiModel(
                        id = 3,
                        storeId = 1,
                        imgUrl = null,
                        name = "토마토탕훠궈",
                        price = "9,000",
                        isPriceFrom = true,
                    ),
                ),
                aiSummary = StoreAiSummaryUiModel(
                    title = "중국 본토의 맛 그대로, 차원이 다른 훠궈 전문점",
                    lines = listOf(
                        "다양한 재료를 취향대로 골라 먹을 수 있는 중국 본토 스타일의 훠궈 전문점이에요.",
                        "소스바에서 입맛에 맞게 소스를 만들어 즐길 수 있으며, 달콤한 케이크도 맛볼 수 있어요.",
                        "자리에서 화려한 면 퍼포먼스를 감상할 수 있고, 생일이나 기념일에 방문하기 좋은 곳이에요.",
                    ),
                ),
                amenities = listOf("주류·콜키지"),
            ),
            userCount = 75,
            maxReservationCount = 8,
            photoTabCount = "9,999+",
            reviewTabCount = "4,122",
            onBackClick = {},
            onTogetherClick = {},
        )
    }
}