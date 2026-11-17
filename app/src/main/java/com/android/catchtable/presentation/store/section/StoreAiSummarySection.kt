package com.android.catchtable.presentation.store.section

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.extension.elevation1
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.store.model.StoreAiSummaryUiModel
import com.android.catchtable.presentation.store.model.dummyStoreUiModel

@Composable
fun StoreAiSummarySection(
    aiSummary: StoreAiSummaryUiModel,
    modifier: Modifier = Modifier,
) {
    val summaryShape = RoundedCornerShape(14.dp)

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_store_sparkle),
                contentDescription = null,
                modifier = Modifier.size(16.dp),
                tint = Color.Unspecified,
            )

            Spacer(modifier = Modifier.width(4.dp))

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
                style = CatchTableTheme.typography.displayB18,
                color = CatchTableTheme.colors.gray900,
            )

            Spacer(modifier = Modifier.width(2.dp))

            Icon(
                painter = painterResource(id = R.drawable.ic_store_help),
                contentDescription = null,
                modifier = Modifier.size(16.dp),
                tint = CatchTableTheme.colors.gray900,
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
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
            Text(
                text = aiSummary.title,
                style = CatchTableTheme.typography.bodySB12,
                color = CatchTableTheme.colors.gray900,
            )

            Spacer(modifier = Modifier.height(13.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp),
            ) {
                aiSummary.lines.forEach { line ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_store_bullet),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(10.dp)
                                .size(4.dp),
                            tint = CatchTableTheme.colors.gray500,
                        )

                        Text(
                            text = line,
                            modifier = Modifier.weight(1f),
                            style = CatchTableTheme.typography.bodyMD12,
                            color = CatchTableTheme.colors.gray500,
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(23.dp))

            Row(
                modifier = Modifier.align(Alignment.End),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_store_like),
                    contentDescription = null,
                    modifier = Modifier.size(28.dp),
                    tint = Color.Unspecified,
                )

                Icon(
                    painter = painterResource(id = R.drawable.ic_store_dislike),
                    contentDescription = null,
                    modifier = Modifier.size(28.dp),
                    tint = Color.Unspecified,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun StoreAiSummarySectionPreview() {
    CatchTableTheme {
        dummyStoreUiModel.aiSummary?.let { aiSummary ->
            StoreAiSummarySection(
                aiSummary = aiSummary,
            )
        }
    }
}