package com.android.catchtable.presentation.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.common.theme.CatchTableTheme

@Composable
fun CatchTableSubwayBadge(
    line: String,
    modifier: Modifier = Modifier
) {

    val backgroundColor = when (line) {
        "9" -> CatchTableTheme.colors.line9
        "신분당" -> CatchTableTheme.colors.lineSBD
        else -> CatchTableTheme.colors.white
    }
    Text(
        text = line,
        color = CatchTableTheme.colors.white,
        style = CatchTableTheme.typography.captionB8,
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = CircleShape
            )
            .padding(vertical = 3.dp, horizontal = 5.dp)
    )
}

@Preview(showBackground = true)
@Composable
private fun CatchTableSubwayBadgePreview() {
    CatchTableTheme {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            CatchTableSubwayBadge(
                line = "9",
                modifier = Modifier.padding(10.dp)
            )
            CatchTableSubwayBadge(
                line = "신분당",
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}
