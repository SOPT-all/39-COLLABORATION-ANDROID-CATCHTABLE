package com.android.catchtable.presentation.together.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.extension.noRippleClickable
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.together.model.VoteRole
import com.android.catchtable.presentation.together.model.VoteStatus
import com.android.catchtable.presentation.together.model.VoteTagType

@Composable
fun VoteHeader(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    status: VoteStatus = VoteStatus.NOT_STARTED,
    role: VoteRole = VoteRole.GUEST,
    onShareClick: () -> Unit = {},
    onVoteEndClick: (Int) -> Unit = {}
) {
    //임의 vote id 값
    val voteId = 1

    Row(
        modifier = modifier
            .padding(vertical = 5.dp, horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                modifier = Modifier
                    .size(22.dp)
                    .noRippleClickable(onClick = onBackClick),
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "Back",
                tint = CatchTableTheme.colors.gray900
            )
            Text(
                text = "함께 고르기",
                style = CatchTableTheme.typography.displayB18,
                color = CatchTableTheme.colors.gray900
            )
        }
        if (status == VoteStatus.IN_PROGRESS) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                if (role == VoteRole.HOST) {
                    //투표종료 component
                    VoteTag(type = VoteTagType.VOTE_ENDED, onClick = { onVoteEndClick(voteId) })
                }
                //공유하기
                Icon(
                    modifier = Modifier
                        .size(30.dp)
                        .padding(all = 3.dp)
                        .noRippleClickable(onClick = onShareClick),
                    painter = painterResource(id = R.drawable.ic_share24),
                    contentDescription = "Share",
                    tint = Color.Unspecified
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun VoteHeaderPreview() {
    CatchTableTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            VoteHeader(modifier = Modifier.fillMaxWidth(),status = VoteStatus.NOT_STARTED, onBackClick = {})
            VoteHeader(modifier = Modifier.fillMaxWidth(),status = VoteStatus.IN_PROGRESS, role = VoteRole.GUEST, onBackClick = {})
            VoteHeader(modifier = Modifier.fillMaxWidth(), status = VoteStatus.IN_PROGRESS, role = VoteRole.HOST, onBackClick = {})
        }
    }
}
