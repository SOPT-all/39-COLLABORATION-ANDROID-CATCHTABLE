package com.android.catchtable.presentation.vote

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.common.component.CatchTableButton
import com.android.catchtable.presentation.common.model.CatchTableButtonType
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.vote.component.VoteHeader
import com.android.catchtable.presentation.vote.component.VoteInfo
import com.android.catchtable.presentation.vote.model.DummyVoteStores.dummyVoteStores
import com.android.catchtable.presentation.vote.model.VoteRole
import com.android.catchtable.presentation.vote.model.VoteStatus

@Composable
fun VoteScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onShareClick: () -> Unit = {},
    onVoteEndClick: () -> Unit = {},
    //status: VoteStatus = VoteStatus.IN_PROGRESS,
    //role: VoteRole = VoteRole.HOST,
    //viewModel: VoteViewModel = viewModel()
) {



    Column(
        modifier = modifier
            .fillMaxSize()
            .background(CatchTableTheme.colors.white)
    ){
        VoteHeader(
            onBackClick = { onBackClick() },
            modifier = Modifier.fillMaxWidth(),
            status = VoteStatus.IN_PROGRESS,
            role = VoteRole.HOST,
            onShareClick = { onShareClick() },
            onVoteEndClick = { onVoteEndClick() }
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(top = 20.dp, bottom = 24.dp, start = 12.dp, end = 12.dp)
        ){
            VoteInfo(
                store = dummyVoteStores[0],
                isSelected = false,
                modifier = Modifier.weight(1f),
                backgroundColor = CatchTableTheme.colors.white,
                strokeColor = CatchTableTheme.colors.gray200
            )

            VoteInfo(
                store = dummyVoteStores[1],
                isSelected = true,
                modifier = Modifier.weight(1f),
                backgroundColor = CatchTableTheme.colors.gray100,
                strokeColor = CatchTableTheme.colors.white
            )
        }

        CatchTableButton(
            text = "text",
            type = CatchTableButtonType.PRIMARY_ENABLED,
            onClick = {  },
            modifier = Modifier
                .fillMaxWidth()
                .background(CatchTableTheme.colors.white)
                .padding(vertical = 12.dp ,horizontal = 20.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun VoteScreenPreview() {
    CatchTableTheme {
        Scaffold { innerPadding ->
            VoteScreen(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
