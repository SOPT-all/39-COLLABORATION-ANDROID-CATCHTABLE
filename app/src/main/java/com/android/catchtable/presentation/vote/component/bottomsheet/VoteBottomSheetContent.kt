package com.android.catchtable.presentation.vote.component.bottomsheet

import android.R.attr.onClick
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.common.component.CatchTableButton
import com.android.catchtable.presentation.common.model.CatchTableButtonType
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.vote.component.VoteRadioButton
import com.android.catchtable.presentation.vote.component.VoteTextField
import com.android.catchtable.presentation.vote.model.VoteMethod

@Composable
fun VoteBottomSheetContent(
    nickname: String,
    selectedMethod: VoteMethod?,
    onMethodClick: (VoteMethod) -> Unit,
    onValueChange: (String) -> Unit,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 28.dp, bottom = 58.dp)

    ) {
        Text(
            text = "어떤 방식으로 투표할까요?",
            style = CatchTableTheme.typography.displayB18,
            color = CatchTableTheme.colors.gray900,
            modifier = Modifier.padding(bottom = 10.dp)
        )

        HorizontalDivider(
            thickness = 1.dp,
            color = CatchTableTheme.colors.gray200,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        VoteMethodItem(
            text = "익명",
            selected = selectedMethod == VoteMethod.ANONYMOUS,
            onClick = { onMethodClick(VoteMethod.ANONYMOUS) },
        )

        if (selectedMethod == VoteMethod.ANONYMOUS) {
            Spacer(modifier = Modifier.height(8.dp))

            VoteTextField(
                value = "익명1",
                onValueChange = {},
                showCounter = false,
                enabled = false,
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        VoteMethodItem(
            text = "닉네임",
            selected = selectedMethod == VoteMethod.NICKNAME,
            onClick = { onMethodClick(VoteMethod.NICKNAME) },
        )

        if (selectedMethod == VoteMethod.NICKNAME) {
            Spacer(modifier = Modifier.height(8.dp))

            VoteTextField(
                value = nickname,
                onValueChange = { onValueChange(it) },
            )
        }

        Spacer(modifier = Modifier.height(36.dp))

        CatchTableButton(
            text = "이 이름으로 투표하기",
            type = if (nickname.length <= 12) CatchTableButtonType.PRIMARY_ENABLED else CatchTableButtonType.PRIMARY_DISABLED_PRIMARY,
            onClick = onButtonClick,
        )
    }
}

@Composable
private fun VoteMethodItem(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        VoteRadioButton(
            selected = selected,
            onClick = onClick,
        )
        Text(
            text = text,
            style = CatchTableTheme.typography.h3MD14,
            color = CatchTableTheme.colors.gray900,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun VoteBottomSheetContentPreview() {
    CatchTableTheme {
        var selectedMethod by remember { mutableStateOf<VoteMethod?>(null) }
        var nickname by remember { mutableStateOf("우수한 셀럽_12128") }

        VoteBottomSheetContent(
            nickname = nickname,
            selectedMethod = selectedMethod,
            onMethodClick = { selectedMethod = it },
            onValueChange = { nickname = it },
            onButtonClick = {}
        )
    }
}
