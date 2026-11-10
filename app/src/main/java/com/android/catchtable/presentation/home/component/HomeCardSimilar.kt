package com.android.catchtable.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.android.catchtable.presentation.common.component.CatchTableAsyncImage
import com.android.catchtable.presentation.common.component.CatchTableDot
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.home.model.SimilarStoreUiModel

@Composable
fun HomeCardSimilar(
    store: SimilarStoreUiModel,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        CatchTableAsyncImage(
            imgUrl = store.thumbnailUrl,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(6.dp)),
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = store.name,
            color = CatchTableTheme.colors.gray900,
            style = CatchTableTheme.typography.h3B14,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(3.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = store.region,
                color = CatchTableTheme.colors.gray500,
                style = CatchTableTheme.typography.bodyB12,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            CatchTableDot(
                modifier = Modifier.padding(horizontal = 3.dp)
            )

            Text(
                text = store.category,
                color = CatchTableTheme.colors.gray500,
                style = CatchTableTheme.typography.bodyB12,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f, fill = false),
            )
        }

        Spacer(modifier = Modifier.height(3.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = null,
                tint = CatchTableTheme.colors.yellow,
                modifier = Modifier
                    .size(16.dp),
            )

            Text(
                text = store.rating,
                color = CatchTableTheme.colors.black,
                style = CatchTableTheme.typography.bodyB12,
            )

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
private fun HomeCardSimilarPreview() {
    val dummyStores = listOf(
        SimilarStoreUiModel(
            id = 1,
            thumbnailUrl = null,
            name = "하이디라오 서초점",
            category = "중식",
            region = "강남",
            rating = "4.7",
            reviewCount = "6,204",
        ),
        SimilarStoreUiModel(
            id = 3,
            thumbnailUrl = null,
            name = "소보키 강남점",
            category = "한식",
            region = "강남",
            rating = "4.5",
            reviewCount = "644",
        ),
        SimilarStoreUiModel(
            id = 4,
            thumbnailUrl = null,
            name = "징관청훠궈 가로수길본점",
            category = "중식",
            region = "가로수길",
            rating = "4.6",
            reviewCount = "18",
        ),
    )

    CatchTableTheme {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            dummyStores.forEach { store ->
                HomeCardSimilar(
                    store = store,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}
