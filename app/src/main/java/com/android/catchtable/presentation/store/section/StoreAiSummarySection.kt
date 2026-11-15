package com.android.catchtable.presentation.store.section

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.extension.elevation1
import com.android.catchtable.presentation.common.theme.CatchTableTheme

@Composable
fun StoreAiSummarySection(
    summaryTitle: String,
    summaries: List<String>,
    modifier: Modifier = Modifier,
) {
    val summaryShape = RoundedCornerShape(14.dp)

    Column(
        modifier = modifier,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_store_sparkle),
                contentDescription = null,
                modifier = Modifier.size(16.dp),
                tint = Color.Unspecified,
            )

            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            brush = CatchTableTheme.colors.pinkGradient,
                        ),
                    ) {
                        append("AI")
                    }
                    append("가 요약했어요")
                },
                modifier = Modifier.padding(start = 4.dp),
                style = CatchTableTheme.typography.displayB18,
                color = CatchTableTheme.colors.gray900,
            )

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_store_help),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 2.dp)
                    .size(16.dp),
                tint = CatchTableTheme.colors.gray900,
            )
        }

        Box(
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth()
                .height(226.dp)
                .elevation1(shape = summaryShape)
                .background(
                    brush = CatchTableTheme.colors.pinkGradientLight,
                    shape = summaryShape,
                )
                .border(
                    width = 1.dp,
                    brush = CatchTableTheme.colors.pinkGradient,
                    shape = summaryShape,
                )
                .padding(horizontal = 20.dp, vertical = 18.dp),
        ) {
            Column {
                Text(
                    text = summaryTitle,
                    style = CatchTableTheme.typography.bodySB12,
                    color = CatchTableTheme.colors.gray900,
                )

                Column(
                    modifier = Modifier.padding(top = 13.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                ) {
                    summaries.forEach { summary ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.ic_store_bullet),
                                contentDescription = null,
                                modifier = Modifier
                                    .padding(10.dp)
                                    .size(4.dp),
                                tint = CatchTableTheme.colors.gray500,
                            )

                            Text(
                                text = summary,
                                modifier = Modifier.weight(1f),
                                style = CatchTableTheme.typography.bodyMD12,
                                color = CatchTableTheme.colors.gray500,
                            )
                        }
                    }
                }
            }

            Row(
                modifier = Modifier.align(Alignment.BottomEnd),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_store_like),
                    contentDescription = null,
                    modifier = Modifier.size(28.dp),
                    tint = Color.Unspecified,
                )

                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_store_dislike),
                    contentDescription = null,
                    modifier = Modifier.size(28.dp),
                    tint = Color.Unspecified,
                )
            }
        }
    }
}