package com.android.catchtable.presentation.common.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.theme.CatchTableTheme


@Composable
fun CatchTableAI(
    modifier: Modifier = Modifier,
    iconSize: Dp = 16.dp,
    title: String = "가 요약했어요",
    style: TextStyle = CatchTableTheme.typography.displayB18
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_sparkle),
            contentDescription = null,
            modifier = Modifier.size(iconSize),
            tint = Color.Unspecified,
        )

        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color(0xFFFF537D), Color(0xFFF9604F)),
                        ),
                    ),
                ) {
                    append("AI")
                }
                append(title)
            },
            modifier = Modifier.padding(start = 4.dp),
            style = style,
            color = CatchTableTheme.colors.gray900,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CatchTableAIPreview(){
    CatchTableTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            //StoreScreen
            CatchTableAI()

            //VoteScreen
            CatchTableAI(
                iconSize = 12.dp,
                title = " 요약",
                style = CatchTableTheme.typography.h3B14,
            )
        }
    }
}