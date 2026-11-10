package com.android.catchtable.presentation.common.component.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.common.theme.CatchTableTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatchTableBottomSheet(
    onDismissRequest: () -> Unit, //바텀시트를 닫으려 할 때 쓰는 함수
    modifier: Modifier = Modifier,
    sheetState: SheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true), //열림,닫힘 상태
    title: String? = null, //위쪽 제목
    content: @Composable ColumnScope.() -> Unit, //바텀시트 안에 들어갈 내용
) {
    val colors = CatchTableTheme.colors

    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        sheetState = sheetState,
        shape = RoundedCornerShape(topStart = 36.dp, topEnd = 36.dp),
        containerColor = colors.white,
        scrimColor = colors.blackAlpha70,
        dragHandle = { CatchTableBottomSheetDragHandle() },
    ) {
        CatchTableBottomSheetContent(
            title = title,
            content = content,
        )
    }
}

// 바텀시트 맨 위 회색 손잡이
@Composable
private fun CatchTableBottomSheetDragHandle() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 13.dp),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier = Modifier
                .size(width = 50.dp, height = 6.dp)
                .background(
                    color = CatchTableTheme.colors.gray200,
                    shape = RoundedCornerShape(10.dp),
                ),
        )
    }
}

// 손잡이 아래 내용 영역 (Preview에서도 확인할 수 있게 따로 분리)
@Composable
private fun CatchTableBottomSheetContent(
    title: String?,
    content: @Composable ColumnScope.() -> Unit,
) {
    val colors = CatchTableTheme.colors
    val typography = CatchTableTheme.typography

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 28.dp, bottom = 20.dp),
    ) {
        if (title != null) { //제목을 넣었을 때 실행
            Text(
                text = title,
                style = typography.displayB18,
                color = colors.gray900,
            )
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(
                thickness = 1.dp,
                color = colors.gray200,
            )
            Spacer(modifier = Modifier.height(32.dp))
        }
        // 화면마다 다른 내용은 바깥에서 넣어줌
        content()
    }
}

@Preview(showBackground = true)
@Composable
private fun CatchTableBottomSheetContentPreview() {
    CatchTableTheme {
        Column {
            CatchTableBottomSheetDragHandle()
            CatchTableBottomSheetContent(
                title = "어떤 방식으로 투표할까요?",
            ) {
                Text(
                    text = "여기에 화면별 내용 추가!!",
                    style = CatchTableTheme.typography.h3MD14,
                )
            }
        }
    }
}