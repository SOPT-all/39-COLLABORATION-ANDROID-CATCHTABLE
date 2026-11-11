package com.android.catchtable.presentation.vote.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.common.theme.CatchTableTheme

@Composable
fun VoteTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "닉네임을 입력해주세요.",
    maxLength: Int = 12,
    showCounter: Boolean = true,
    enabled: Boolean = true,
) {
    val colors = CatchTableTheme.colors
    val typography = CatchTableTheme.typography

    val isMaxLength = value.length >= maxLength

    val counterColor = when {
        value.isEmpty() -> colors.gray400
        isMaxLength -> colors.orangeBase
        else -> colors.gray900
    }

    val counterStyle = if (isMaxLength) typography.captionB10 else typography.captionMD10

    BasicTextField(
        value = value,
        onValueChange = { newValue ->
            if (newValue.length <= maxLength) {
                onValueChange(newValue)
            }
        },
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        singleLine = true,
        textStyle = typography.h3MD14.copy(color = colors.gray900),
        cursorBrush = SolidColor(colors.orangeBase),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(color = colors.gray100)
                    .padding(horizontal = 12.dp, vertical = 14.dp),
                verticalAlignment = Alignment.Bottom,
            ) {
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterStart,
                ) {
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = typography.h3MD14,
                            color = colors.gray300,
                        )
                    }

                    innerTextField()
                }

                if (showCounter) {
                    Text(
                        text = "${value.length}/${maxLength}자",
                        style = counterStyle,
                        color = counterColor,
                    )
                }
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
private fun VoteTextFieldPreview() {
    CatchTableTheme {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            VoteTextField(
                value = "익명1",
                onValueChange = {},
                showCounter = false,
                enabled = false,
            )

            var nickname by remember { mutableStateOf("우수한 셀럽_121") }

            VoteTextField(
                value = nickname,
                onValueChange = { nickname = it },
            )

            VoteTextField(
                value = "우수한 셀럽_12128",
                onValueChange = {},
            )

            VoteTextField(
                value = "",
                onValueChange = {},
            )
        }
    }
}