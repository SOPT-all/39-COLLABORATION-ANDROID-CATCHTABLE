package com.android.catchtable.presentation.store.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.theme.CatchTableTheme

@Composable
fun StoreChip(
    text: String,
    modifier: Modifier = Modifier,
    isIconVisible: Boolean = false
) {
    Row(
        modifier = modifier
            .background(
                color = CatchTableTheme.colors.gray200,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = text,
            color = CatchTableTheme.colors.coolGray600,
            style = CatchTableTheme.typography.captionMD10
        )

        if (isIconVisible) {
            Icon(
                painter = painterResource(id = R.drawable.ic_store_question),
                contentDescription = "도움말",
                tint = CatchTableTheme.colors.coolGray600,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .size(12.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun StoreChipPreview() {
    CatchTableTheme {
        Row(
            modifier = Modifier.padding(20.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            StoreChip(
                text = "최대 8명 예약",
                isIconVisible = true,
            )

            StoreChip(
                text = "주차",
            )
        }
    }
}
