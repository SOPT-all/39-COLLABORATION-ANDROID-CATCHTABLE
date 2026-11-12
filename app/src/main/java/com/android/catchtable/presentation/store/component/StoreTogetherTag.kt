package com.android.catchtable.presentation.store.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.extension.noRippleClickable
import com.android.catchtable.presentation.common.theme.CatchTableTheme

@Composable
fun StoreTogetherTag(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(30.dp))
            .background(CatchTableTheme.colors.white)
            .border(
                1.dp,
                 CatchTableTheme.colors.gray200,
                RoundedCornerShape(30.dp)
            )
            .padding(vertical = 8.dp, horizontal = 12.dp)
            .noRippleClickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_together),
            modifier = Modifier.size(12.dp),
            contentDescription = "Together",
            tint = CatchTableTheme.colors.gray900
        )
        Text(
            text = "함께고르기",
            style = CatchTableTheme.typography.bodyMD12,
            color = CatchTableTheme.colors.gray900
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun StoreTogetherTagPreview(){
    CatchTableTheme {
        StoreTogetherTag(
            onClick = {}
        )
    }
}
