package com.android.catchtable.presentation.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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


/* 이건 코드리뷰 확인해볼게요. 3.dp, 5.dp로 해야 딱 정가운데이긴한데 피그마 그대로 사용한다면 padding(padding)으로 코드 수정하면 됩니다!
    val padding = when (line) {
        "9" -> PaddingValues(top = 3.dp, end = 5.dp, bottom = 4.dp, start = 6.dp)
        "신분당" -> PaddingValues(vertical = 3.dp, horizontal = 6.dp)
        else -> PaddingValues(0.dp)
    }*/

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
