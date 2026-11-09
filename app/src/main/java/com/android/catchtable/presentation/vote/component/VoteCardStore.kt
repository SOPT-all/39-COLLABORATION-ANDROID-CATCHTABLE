package com.android.catchtable.presentation.vote.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.component.BaseAsyncImage
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.vote.model.VoteStoreUiModel

@Composable
fun VoteCardStore(
    store: VoteStoreUiModel,
    onButtonClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    isSelected: Boolean? = null,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            BaseAsyncImage(
                imgUrl = store.thumbnailUrl,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(16.dp)),
            )

            if (isSelected != null) {
                val buttonIcon = if (isSelected) R.drawable.ic_vote_button_selected
                else R.drawable.ic_vote_button_unselected

                Icon(
                    painter = painterResource(id = buttonIcon),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 12.dp, end = 12.dp)
                        .size(24.dp)
                        .clickable { onButtonClick(store.id) },
                )
            }


        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = store.name,
            color = CatchTableTheme.colors.gray900,
            style = CatchTableTheme.typography.h3B14,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(6.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = null,
                tint = CatchTableTheme.colors.yellow,
                modifier = Modifier
                    .size(12.dp),
            )

            Spacer(modifier = Modifier.width(4.dp))

            Text(
                text = store.rating,
                color = CatchTableTheme.colors.black,
                style = CatchTableTheme.typography.bodyB12,
            )

            Spacer(modifier = Modifier.width(2.dp))

            Text(
                text = "(" + store.reviewCount + ")",
                color = CatchTableTheme.colors.gray400,
                style = CatchTableTheme.typography.bodyB12,
            )
        }

        Spacer(modifier = Modifier.height(4.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun VoteCardStorePreview() {
    val dummyStore = VoteStoreUiModel(
        id = 1,
        thumbnailUrl = null,
        name = "하이디라오 서초점",
        rating = "4.7",
        reviewCount = "6,204",
    )

    CatchTableTheme {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            VoteCardStore(
                store = dummyStore,
                isSelected = true,
                onButtonClick = {},
                modifier = Modifier.weight(1f)
            )

            VoteCardStore(
                store = dummyStore,
                isSelected = false,
                onButtonClick = {},
                modifier = Modifier.weight(1f)
            )

            VoteCardStore(
                store = dummyStore,
                onButtonClick = {},
                modifier = Modifier.weight(1f)
            )
        }
    }
}
