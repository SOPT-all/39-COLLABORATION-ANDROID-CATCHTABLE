package com.android.catchtable.presentation.store.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.store.component.StoreCardPhoto

@Composable
fun StorePhotoSection(
    photoUrls: List<String>,
    userCount: Int,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier,
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