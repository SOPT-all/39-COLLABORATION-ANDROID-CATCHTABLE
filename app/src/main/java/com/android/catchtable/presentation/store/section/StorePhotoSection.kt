package com.android.catchtable.presentation.store.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.store.component.StoreCardPhoto
import com.android.catchtable.presentation.store.model.dummyStoreUiModel

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

@Preview(showBackground = true)
@Composable
private fun StorePhotoSectionPreview() {
    CatchTableTheme {
        StorePhotoSection(
            photoUrls = dummyStoreUiModel.imageUrls,
            userCount = 75,
        )
    }
}