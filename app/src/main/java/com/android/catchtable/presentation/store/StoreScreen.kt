package com.android.catchtable.presentation.store

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    items(photoUrls) { photoUrl ->
                        StoreCardPhoto(
                            imgUrl = photoUrl,
                            userCount = userCount,
                            modifier = Modifier.width(294.dp),
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
            onBackClick = {},
            onTogetherClick = {},
        )
    }
}