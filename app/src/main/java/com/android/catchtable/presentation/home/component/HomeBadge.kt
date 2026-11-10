package com.android.catchtable.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.common.component.CatchTableBadgeLine9
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.home.model.HomeBadgeType

@Composable
fun HomeBadge(
    type: HomeBadgeType,
    modifier: Modifier = Modifier,
) {
    val badgeShape = RoundedCornerShape(
        topEnd = 10.dp,
        bottomStart = 8.dp,
        bottomEnd = 10.dp,
    )

    Text(
        text = type.text,
        color = CatchTableTheme.colors.white,
        style = CatchTableTheme.typography.captionB8,
        modifier = modifier
            .background(
                color = type.color(),
                shape = badgeShape
            )
            .border(
                width = 1.dp,
                color = CatchTableTheme.colors.white,
                shape = badgeShape
            )
            .padding(vertical = 2.dp, horizontal = 6.dp)
    )
}

@Preview(showBackground = true)
@Composable
private fun HomeBadgePreview() {
    CatchTableTheme {
        Row(
            modifier = Modifier.padding(20.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ){
            HomeBadge(
                type = HomeBadgeType.HOT
            )

            HomeBadge(
                type = HomeBadgeType.TOP
            )
        }
    }
}
