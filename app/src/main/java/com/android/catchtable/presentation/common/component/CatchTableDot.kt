package com.android.catchtable.presentation.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.common.theme.CatchTableTheme

@Composable
fun CatchTableDot(
    modifier: Modifier = Modifier,
    size: Dp = 2.dp,
    color: Color = CatchTableTheme.colors.gray500,
) {
    Box(
        modifier = modifier
            .size(size)
            .background(
                color = color,
                shape = CircleShape,
            ),
    )
}

@Preview(showBackground = true)
@Composable
private fun CatchTableDotPreview() {
    CatchTableTheme {
        CatchTableDot(
            modifier = Modifier.padding(10.dp)
        )
    }
}
