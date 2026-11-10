package com.android.catchtable.presentation.common.component.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.theme.CatchTableTheme

@Composable
fun CatchTableSearchTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    onSearch: () -> Unit = {},
) {
    val colors = CatchTableTheme.colors
    val typography = CatchTableTheme.typography

    // 배경과 테두리에 같은 모양을 써야 해서 변수로 한 번만 만듦
    val shape = RoundedCornerShape(30.dp)

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        singleLine = true,
        textStyle = typography.h3MD14.copy(color = colors.gray900),
        cursorBrush = SolidColor(colors.orangeBase),
        // 키보드 오른쪽 아래 버튼을 검색 버튼으로 바꿈
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        // 그 검색 버튼을 눌렀을 때 onSearch 실행
        keyboardActions = KeyboardActions(onSearch = { onSearch() }),
        // 모양 없는 BasicTextField에 모양을 입히는 곳
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .background(color = colors.gray100, shape = shape)
                    .border(width = 1.dp, color = colors.gray200, shape = shape)
                    .padding(horizontal = 14.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                // 돋보기 아이콘
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_search),
                    contentDescription = null,
                    modifier = Modifier.size(14.dp),
                    tint = Color.Unspecified,
                )
                // 아이콘과 글자 사이 간격
                Spacer(modifier = Modifier.width(10.dp))
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterStart,
                ) {
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = typography.h3MD14,
                            color = colors.gray400,
                        )
                    }
                    innerTextField()
                }
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
private fun CatchTableSearchTextFieldPreview() {
    CatchTableTheme {
        var keyword by remember { mutableStateOf("") }
        CatchTableSearchTextField(
            value = keyword,
            onValueChange = { keyword = it },
            modifier = Modifier
                .padding(20.dp)
                .width(248.dp),
            placeholder = "혜택을 검색해보세요!",
        )
    }
}