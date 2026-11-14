package com.android.catchtable.presentation.votecomplete

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.component.CatchTableButton
import com.android.catchtable.presentation.common.model.CatchTableButtonType
import com.android.catchtable.presentation.common.theme.CatchTableTheme

@Composable
fun VoteCompleteScreen(
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = CatchTableTheme.colors.white),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(245f))

        Icon(
            painter = painterResource(id = R.drawable.ic_votecomplete_check),
            contentDescription = null,
            tint = CatchTableTheme.colors.orangeBase,
            modifier = Modifier
                .background(
                    color = CatchTableTheme.colors.orangeBaseAlpha05,
                    shape = CircleShape,
                )
                .border(
                    width = 2.dp,
                    color = CatchTableTheme.colors.orangeBase,
                    shape = CircleShape,
                )
                .padding(all = 14.dp)
                .size(28.dp),
        )

        Spacer(modifier = Modifier.height(28.dp))

        Text(
            text = "가고싶은 매장\n 투표 완료",
            style = CatchTableTheme.typography.displayB20,
            color = CatchTableTheme.colors.gray800,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "아래 버튼을 눌러\n 투표 현황을 확인해보세요",
            style = CatchTableTheme.typography.bodySB12,
            color = CatchTableTheme.colors.gray500,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.weight(223f))

        CatchTableButton(
            text = "투표 현황 보러가기",
            type = CatchTableButtonType.WHITE_ENABLED,
            onClick = onButtonClick,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 56.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun VoteCompleteScreenPreview() {
    CatchTableTheme {
        VoteCompleteScreen(
            onButtonClick = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}
