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
import com.android.catchtable.presentation.store.model.StoreMenuUiModel
import com.android.catchtable.presentation.store.model.StoreTab
import com.android.catchtable.presentation.store.section.StoreAiSummarySection
import com.android.catchtable.presentation.store.section.StoreChipSection
import com.android.catchtable.presentation.store.section.StoreInfoSection
import com.android.catchtable.presentation.store.section.StoreMenuSection
import com.android.catchtable.presentation.store.section.StorePhotoSection
import com.android.catchtable.presentation.store.section.StoreTitleSection

@Composable
fun StoreScreen(
    photoUrls: List<String>,
    userCount: Int,
    storeName: String,
    rating: String,
    reviewCount: String,
    area: String,
    category: String,
    description: String,
    subwayInfo: String,
    priceRange: String,
    openStatus: String,
    lastOrderTime: String,
    phoneNumber: String,
    maxReservationCount: Int,
    facilities: List<String>,
    photoTabCount: String,
    reviewTabCount: String,
    menus: List<StoreMenuUiModel>,
    summaryTitle: String,
    summaries: List<String>,
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
                    photoUrls = photoUrls,
                    userCount = userCount,
                    modifier = Modifier.padding(top = 12.dp),
                )
            }

            item {
                StoreTitleSection(
                    storeName = storeName,
                    rating = rating,
                    reviewCount = reviewCount,
                    area = area,
                    category = category,
                    description = description,
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
                    subwayInfo = subwayInfo,
                    priceRange = priceRange,
                    openStatus = openStatus,
                    lastOrderTime = lastOrderTime,
                    phoneNumber = phoneNumber,
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 16.dp),
                )
            }

            item {
                StoreChipSection(
                    maxReservationCount = maxReservationCount,
                    facilities = facilities,
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
                    menus = menus,
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

            item {
                StoreAiSummarySection(
                    summaryTitle = summaryTitle,
                    summaries = summaries,
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 28.dp, bottom = 75.dp),
                )
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
            photoUrls = listOf("", ""),
            userCount = 75,
            storeName = "하이디라오 서초점",
            rating = "4.7",
            reviewCount = "6,139",
            area = "강남",
            category = "중식",
            description = "중국 본토의 맛 그대로, 차원이 다른 No.1 훠궈",
            subwayInfo = "신논현역에서 221m",
            priceRange = "3-5만원",
            openStatus = "영업 중",
            lastOrderTime = "새벽 05:00 라스트오더",
            phoneNumber = "0507-1350-8260",
            maxReservationCount = 8,
            facilities = listOf("주차", "발렛", "콜키지", "장애인 편의시설", "단체", "무선 인터넷"),
            photoTabCount = "9,999+",
            reviewTabCount = "4,122",
            menus = listOf(
                StoreMenuUiModel(
                    id = 1,
                    storeId = 1,
                    imgUrl = null,
                    name = "루로우판",
                    price = "4,500",
                    isPriceFrom = false,
                ),
                StoreMenuUiModel(
                    id = 2,
                    storeId = 1,
                    imgUrl = null,
                    name = "탄탄면",
                    price = "5,000",
                    isPriceFrom = false,
                ),
                StoreMenuUiModel(
                    id = 3,
                    storeId = 1,
                    imgUrl = null,
                    name = "돼지고기튀김",
                    price = "5,900",
                    isPriceFrom = false,
                ),
            ),
            summaryTitle = "중국 본토의 맛 그대로, 차원이 다른 훠궈 전문점",
            summaries = listOf(
                "다양한 재료를 취향대로 골라 먹을 수 있는 중국 본토 스타일의 훠궈 전문점이에요.",
                "소스바에서 입맛에 맞게 소스를 만들어 즐길 수 있으며, 달콤한 케이크도 맛볼 수 있어요.",
                "자리에서 화려한 면 퍼포먼스를 감상할 수 있고, 생일이나 기념일에 방문하기 좋은 곳이에요.",
            ),
            onBackClick = {},
            onTogetherClick = {},
        )
    }
}