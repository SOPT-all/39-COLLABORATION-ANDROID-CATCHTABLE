package com.android.catchtable.presentation.store

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.store.component.StoreBottomBar
import com.android.catchtable.presentation.store.component.StoreCardPhoto
import com.android.catchtable.presentation.store.component.StoreHeader

@Composable
fun StoreScreen(
    photoUrls: List<String>,
    userCount: Int,
    onBackClick: () -> Unit,
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
            onBackClick = {},
        )
    }
}