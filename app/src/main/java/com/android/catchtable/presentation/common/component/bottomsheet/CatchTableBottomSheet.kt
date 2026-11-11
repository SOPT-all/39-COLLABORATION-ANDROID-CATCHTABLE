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
import com.android.catchtable.presentation.common.extension.elevation1
import com.android.catchtable.presentation.common.theme.CatchTableTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatchTableBottomSheet(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    sheetState: SheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
    content: @Composable ColumnScope.() -> Unit,
) {
    val colors = CatchTableTheme.colors
    val shape = RoundedCornerShape(topStart = 36.dp, topEnd = 36.dp)

    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        modifier = modifier.elevation1(shape = shape),
        sheetState = sheetState,
        shape = shape,
        containerColor = colors.white,
        scrimColor = colors.blackAlpha70,
        dragHandle = { CatchTableBottomSheetDragHandle() },
        content = content,
    )
}

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