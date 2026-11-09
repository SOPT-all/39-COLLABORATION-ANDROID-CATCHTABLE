package com.android.catchtable.presentation.common.component.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.common.theme.CatchTableTheme

@Composable
fun CatchTableTextField(
    value: String, //지금 입력칸에 들어 있는 글자
    onValueChange: (String) -> Unit, //글자가 바뀌면 실행할 함수
    modifier: Modifier = Modifier,
    placeholder: String = "", //비어 있을 때 보이는 회색 안내 글자
    maxLength: Int = 12, //최대 글자 수
    showCounter: Boolean = true, //n/12자 표시 여부
    enabled: Boolean = true, //입력 가능 여부
) {
    // 테마에 정의된 색상/타이포를 꺼내 씀
    val colors = CatchTableTheme.colors
    val typography = CatchTableTheme.typography

    // 최대 글자 수에 도달했는지 여부 → 피그마의 error 상태
    val isMaxLength = value.length >= maxLength

    // 글자 수 텍스트 색상: 비어 있으면 회색, 최대치면 주황색, 그 외엔 검정색
    val counterColor = when {
        value.isEmpty() -> colors.gray400
        isMaxLength -> colors.orangeBase
        else -> colors.gray900
    }

    // 글자 수 텍스트 스타일: 최대치일 때만 Bold, 나머지는 Medium
    val counterStyle = if (isMaxLength) typography.captionB10 else typography.captionMD10

    BasicTextField(
        //실제 입력칸
        value = value,
        onValueChange = { newValue ->
            // 최대 글자 수를 넘는 입력은 무시함 (12자까지만 입력 가능)
            if (newValue.length <= maxLength) {
                onValueChange(newValue)
            }
        },
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        // 이름 입력이므로 한 줄만 입력되게 함 (엔터로 줄바꿈 X)
        singleLine = true,
        // 입력된 글자 스타일
        textStyle = typography.h3MD14.copy(color = colors.gray900),
        // 피그마 typing 상태의 주황색 커서
        cursorBrush = SolidColor(colors.orangeBase),
        // decorationBox: 입력창의 배경
        decorationBox = { innerTextField -> //실제로 글자가 입력되는 부분
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(
                        color = colors.gray100,
                        shape = RoundedCornerShape(12.dp),
                    )
                    .padding(12.dp),
                verticalAlignment = Alignment.Bottom,
            ) {
                // 입력 영역이 남는 공간을 모두 차지하게 weight(1f)
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterStart,
                ) {
                    // 입력값이 없을 때만 placeholder를 보여줌
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = typography.h3MD14,
                            color = colors.gray300,
                        )
                    }
                    // 실제로 글자가 입력되는 영역
                    innerTextField()
                }

                if (showCounter) {
                    // 입력 글자가 길어져도 글자 수와 붙지 않도록 최소 간격 확보
                    Spacer(modifier = Modifier.width(8.dp))
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
private fun CatchTableTextFieldPreview() {
    CatchTableTheme {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            // 익명: 수정 불가, 글자 수 없음
            CatchTableTextField(
                value = "익명1",
                onValueChange = {},
                showCounter = false,
                enabled = false,
            )
            // 입력 가능: 직접 쳐볼 수 있음
            var nickname by remember { mutableStateOf("우수한 셀럽_121") }
            CatchTableTextField(
                value = nickname,
                onValueChange = { nickname = it },
            )
            // 12자 꽉 참: 주황색 Bold
            CatchTableTextField(
                value = "우수한 셀럽_12128",
                onValueChange = {},
            )
            // 비어 있음: placeholder + 0/12자 회색
            CatchTableTextField(
                value = "",
                onValueChange = {},
                placeholder = "닉네임을 입력해주세요.",
            )
        }
    }
}