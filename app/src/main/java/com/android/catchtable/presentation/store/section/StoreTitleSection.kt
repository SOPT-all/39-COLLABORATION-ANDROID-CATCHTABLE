package com.android.catchtable.presentation.store.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.component.CatchTableDot
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.store.component.StoreTogetherTag
import com.android.catchtable.presentation.store.model.dummyStoreUiModel

@Composable
fun StoreTitleSection(
    storeName: String,
    rating: Double,
    reviewCount: Int,
    area: String,
    category: String,
    description: String,
    onTogetherClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val formattedReviewCount = "%,d".format(reviewCount)

    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = storeName,
                style = CatchTableTheme.typography.displayB22,
                color = CatchTableTheme.colors.gray900,
            )

            StoreTogetherTag(
                onClick = onTogetherClick,
            )
        }

        Row(
            modifier = Modifier.padding(top = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_star),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = CatchTableTheme.colors.yellow,
            )

            Text(
                text = rating.toString(),
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
                text = "리뷰 ${formattedReviewCount}개",
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

@Preview(showBackground = true)
@Composable
private fun StoreTitleSectionPreview() {
    CatchTableTheme {
        StoreTitleSection(
            storeName = dummyStoreUiModel.name,
            rating = dummyStoreUiModel.rating,
            reviewCount = dummyStoreUiModel.reviewCount,
            area = dummyStoreUiModel.region,
            category = dummyStoreUiModel.category,
            description = dummyStoreUiModel.intro,
            onTogetherClick = {},
        )
    }
}