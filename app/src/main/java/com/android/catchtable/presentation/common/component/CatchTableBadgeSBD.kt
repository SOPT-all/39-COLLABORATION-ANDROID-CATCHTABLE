package com.android.catchtable.presentation.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.common.theme.CatchTableTheme

@Composable
fun CatchTableBadgeSBD(
    modifier: Modifier = Modifier
) {
    Text(
        text = "신분당",
        color = CatchTableTheme.colors.white,
        style = CatchTableTheme.typography.captionB8,
        modifier = modifier
            .background(
                color = CatchTableTheme.colors.lineSBD,
                shape = CircleShape
            )
            .padding(vertical = 3.dp, horizontal = 6.dp)
    )
}

@Preview(showBackground = true)
@Composable
private fun CatchTableBadgeSBDPreview() {
    CatchTableTheme {
        CatchTableBadgeSBD(
            modifier = Modifier.padding(10.dp)
        )
    }
}
