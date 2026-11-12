package com.android.catchtable.presentation.store

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.component.CatchTableBadgeLine9
import com.android.catchtable.presentation.common.component.CatchTableBadgeSBD
import com.android.catchtable.presentation.common.component.CatchTableDot
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.store.component.StoreBottomBar
import com.android.catchtable.presentation.store.component.StoreCardPhoto
import com.android.catchtable.presentation.store.component.StoreHeader
import com.android.catchtable.presentation.store.component.StoreTogetherTag

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
    onBackClick: () -> Unit,
    onTogetherClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
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
                LazyRow(
                    modifier = Modifier.padding(top = 12.dp),
                    contentPadding = PaddingValues(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    itemsIndexed(photoUrls) { index, photoUrl ->
                        StoreCardPhoto(
                            imgUrl = photoUrl,
                            userCount = userCount,
                            modifier = Modifier.width(294.dp),
                            isUserCountVisible = index == 0,
                        )
                    }
                }
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp, top = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = storeName,
                        style = CatchTableTheme.typography.displayB20,
                        color = CatchTableTheme.colors.gray900,
                    )

                    StoreTogetherTag(
                        onClick = onTogetherClick,
                    )
                }
            }

            item {
                Column(
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 4.dp),
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_star),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp),
                            tint = Color.Unspecified,
                        )

                        Text(
                            text = rating,
                            modifier = Modifier.padding(start = 2.dp),
                            style = CatchTableTheme.typography.h3SB14,
                            color = CatchTableTheme.colors.gray900,
                        )

                        CatchTableDot(
                            modifier = Modifier.padding(start = 2.dp, end = 4.dp),
                            size = 4.dp,
                            color = CatchTableTheme.colors.gray300,
                        )

                        Text(
                            text = "리뷰 ${reviewCount}개",
                            style = CatchTableTheme.typography.h3SB14,
                            color = CatchTableTheme.colors.gray900,
                        )

                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_store_next),
                            contentDescription = null,
                            modifier = Modifier.size(12.dp),
                            tint = CatchTableTheme.colors.gray900,
                        )

                        CatchTableDot(
                            modifier = Modifier.padding(horizontal = 6.dp),
                            size = 4.dp,
                            color = CatchTableTheme.colors.gray300,
                        )

                        Text(
                            text = area,
                            style = CatchTableTheme.typography.bodyMD12,
                            color = CatchTableTheme.colors.gray900,
                        )

                        CatchTableDot(
                            modifier = Modifier.padding(horizontal = 6.dp),
                            size = 4.dp,
                            color = CatchTableTheme.colors.gray300,
                        )

                        Text(
                            text = category,
                            style = CatchTableTheme.typography.bodyMD12,
                            color = CatchTableTheme.colors.gray900,
                        )
                    }

                    Text(
                        text = description,
                        style = CatchTableTheme.typography.bodyMD12,
                        color = CatchTableTheme.colors.gray500,
                    )
                }
            }

            item {
                HorizontalDivider(
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 16.dp),
                    thickness = 1.dp,
                    color = CatchTableTheme.colors.gray200,
                )
            }

            item {
                Row(
                    modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_store_location),
                        contentDescription = null,
                        modifier = Modifier.size(14.dp),
                        tint = Color.Unspecified,
                    )

                    CatchTableBadgeLine9(
                        modifier = Modifier.padding(start = 8.dp),
                    )

                    CatchTableBadgeSBD(
                        modifier = Modifier.padding(start = 4.dp),
                    )

                    Text(
                        text = subwayInfo,
                        modifier = Modifier.padding(start = 8.dp),
                        style = CatchTableTheme.typography.bodyMD12,
                        color = CatchTableTheme.colors.gray900,
                    )

                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_store_dropdown),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = Color.Unspecified,
                    )

                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_store_map),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 4.dp)
                            .size(20.dp),
                        tint = Color.Unspecified,
                    )

                    Text(
                        text = "위치",
                        style = CatchTableTheme.typography.bodyMD12,
                        color = CatchTableTheme.colors.blue,
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
            photoUrls = listOf("", ""),
            userCount = 75,
            storeName = "하이디라오 서초점",
            rating = "4.7",
            reviewCount = "6,139",
            area = "강남",
            category = "중식",
            description = "중국 본토의 맛 그대로, 차원이 다른 No.1 훠궈",
            subwayInfo = "신논현역에서 221m",
            onBackClick = {},
            onTogetherClick = {},
        )
    }
}