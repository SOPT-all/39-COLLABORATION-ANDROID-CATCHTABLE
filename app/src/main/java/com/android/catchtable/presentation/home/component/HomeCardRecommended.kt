package com.android.catchtable.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.component.BaseAsyncImage
import com.android.catchtable.presentation.common.component.Dot
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.home.model.RecommendStoreUiModel

@Composable
fun HomeCardRecommended(
    store: RecommendStoreUiModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        BaseAsyncImage(
            imgUrl = store.thumbnailUrl,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(shape = RoundedCornerShape(8.dp)),
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(2.dp),
            ) {
                Text(
                    text = store.name,
                    color = CatchTableTheme.colors.black,
                    style = CatchTableTheme.typography.h3B14,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_star),
                        contentDescription = null,
                        tint = CatchTableTheme.colors.yellow,
                        modifier = Modifier
                            .size(20.dp)
                    )

                    Spacer(modifier = Modifier.width(2.dp))

                    Text(
                        text = store.rating,
                        color = CatchTableTheme.colors.black,
                        style = CatchTableTheme.typography.bodySB12,
                        modifier = Modifier.padding(vertical = 2.dp)
                    )

                    Spacer(modifier = Modifier.width(5.dp))

                    Text(
                        text = store.category,
                        color = CatchTableTheme.colors.gray500,
                        style = CatchTableTheme.typography.captionSB10,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )

                    Dot(
                        modifier = Modifier.padding(horizontal = 2.dp)
                    )

                    Text(
                        text = store.region,
                        color = CatchTableTheme.colors.gray500,
                        style = CatchTableTheme.typography.captionSB10,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f, fill = false),
                    )
                }
            }

            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                painter = painterResource(id = R.drawable.ic_bookmark_20),
                contentDescription = "북마크",
                tint = CatchTableTheme.colors.white,
                modifier = Modifier
                    .background(
                        color = CatchTableTheme.colors.gray300,
                        shape = CircleShape
                    )
                    .padding(all = 5.dp)
                    .size(20.dp)
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 375)
@Composable
private fun HomeCardRecommendedPreview() {
    val dummyStore = RecommendStoreUiModel(
        id = 5,
        thumbnailUrl = null,
        name = "만가타",
        category = "유러피안음식",
        region = "삼청",
        rating = "4.8"
    )

    CatchTableTheme {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            HomeCardRecommended(
                store = dummyStore,
                modifier = Modifier.weight(1f)
            )

            HomeCardRecommended(
                store = dummyStore,
                modifier = Modifier.weight(1f)
            )
        }
    }
}
