package com.android.catchtable.presentation.common.component.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
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
        content = content,
    )
}

// 바텀시트 맨 위 회색 손잡이
@Composable
private fun CatchTableBottomSheetDragHandle(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .padding(top = 13.dp)
            .size(width = 50.dp, height = 6.dp)
            .background(
                color = CatchTableTheme.colors.gray200,
                shape = CircleShape,
            ),
    )
}


@Preview(showBackground = true)
@Composable
private fun CatchTableBottomSheetDragHandlePreview() {
    CatchTableTheme {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CatchTableBottomSheetDragHandle()
            Text(
                text = "여기에 화면별 내용 추가!!",
                style = CatchTableTheme.typography.h3MD14,
                modifier = Modifier.padding(20.dp),
            )
        }
    }
}