package com.android.catchtable.presentation.vote.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.android.catchtable.presentation.vote.model.VoteMenuUiModel

@Composable
fun VoteCardMenu(
    menu: VoteMenuUiModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        CatchTableAsyncImage(
            imgUrl = menu.menuImageUrl,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(shape = RoundedCornerShape(8.dp)),
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = menu.name,
            color = CatchTableTheme.colors.gray900,
            style = CatchTableTheme.typography.bodyB12,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "${menu.price}원${if (menu.isPriceFrom) " ~" else ""}",
            color = CatchTableTheme.colors.gray500,
            style = CatchTableTheme.typography.bodyB12,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true, widthDp = 375)
@Composable
private fun VoteCardMenuPreview() {
    val dummyMenus = listOf(
        VoteMenuUiModel(
            menuId = 4,
            storeId = 1,
            menuImageUrl = null,
            name = "우유마라훠궈",
            price = "9,000",
            isPriceFrom = true,
        ),
        VoteMenuUiModel(
            menuId = 5,
            storeId = 2,
            menuImageUrl = null,
            name = "2인 SET",
            price = "55,000",
            isPriceFrom = false,
        ),
    )

    CatchTableTheme {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            dummyMenus.forEach { menu ->
                VoteCardMenu(
                    menu = menu,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}
