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
import com.android.catchtable.presentation.store.model.StoreTab
import com.android.catchtable.presentation.store.model.StoreUiModel
import com.android.catchtable.presentation.store.model.dummyStoreUiModel
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
                    modifier = Modifier.padding(top = 20.dp),
                )
            }

            item {
                HorizontalDivider(
                    modifier = Modifier.padding(top = 12.dp),
                    thickness = 8.dp,
                    color = CatchTableTheme.colors.gray100,
                )
            }

            item {
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
                        aiSummary = aiSummary,
                        modifier = Modifier.padding(
                            start = 20.dp,
                            end = 20.dp,
                            top = 28.dp,
                            bottom = 75.dp
                        ),
                    )
                }
            }
        }
    }

    StoreBottomBar(
        onButtonClick = {},
        enabled = false,
    )
}

@Preview(showBackground = true)
@Composable
private fun StoreScreenPreview() {
    CatchTableTheme {
        StoreScreen(
            store = dummyStoreUiModel,
            userCount = 75,
            maxReservationCount = 8,
            photoTabCount = "9,999+",
            reviewTabCount = "4,122",
            onBackClick = {},
            onTogetherClick = {},
        )
    }
}