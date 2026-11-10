package com.android.catchtable.presentation.store.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.common.component.CatchTableAsyncImage
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.store.model.StoreMenuUiModel

@Composable
fun StoreCardMenu(
    menu: StoreMenuUiModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        CatchTableAsyncImage(
            imgUrl = menu.imgUrl,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(shape = RoundedCornerShape(8.dp)),
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = menu.name,
            color = CatchTableTheme.colors.gray900,
            style = CatchTableTheme.typography.h1B16,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "${menu.price}원$",
            color = CatchTableTheme.colors.gray900,
            style = CatchTableTheme.typography.h3SB14,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true, widthDp = 375)
@Composable
private fun StoreCardMenuPreview() {
    val dummyMenu = StoreMenuUiModel(
            id = 4,
            storeId = 1,
            imgUrl = null,
            name = "루로우판",
            price = "4,500",
    )

    CatchTableTheme {
        StoreCardMenu(
            menu = dummyMenu,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
        )
    }
}
