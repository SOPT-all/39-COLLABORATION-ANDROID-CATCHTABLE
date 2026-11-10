package com.android.catchtable.presentation.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.store.component.StoreCardMenu
import com.android.catchtable.presentation.store.model.StoreMenuUiModel

@Composable
fun CatchTableBadgeLine9(
    modifier: Modifier = Modifier
) {
    Text(
        text = "9",
        color = CatchTableTheme.colors.white,
        style = CatchTableTheme.typography.captionB8,
        modifier = Modifier
            .background(
                color = CatchTableTheme.colors.line9,
                shape = CircleShape
            )
            .padding(top = 3.dp, bottom = 4.dp, start = 6.dp, end = 5.dp)
    )
}

@Preview(showBackground = true)
@Composable
private fun CatchTableBadgeLine9Preview() {
    CatchTableTheme {
        CatchTableBadgeLine9(
            modifier = Modifier.padding(10.dp)
        )
    }
}
