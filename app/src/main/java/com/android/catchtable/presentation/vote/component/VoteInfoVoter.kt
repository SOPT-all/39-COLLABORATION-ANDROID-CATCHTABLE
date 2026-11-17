package com.android.catchtable.presentation.vote.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.domain.model.vote.VoteVoterModel
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import kotlin.collections.getOrNull

//높이를 직접 주입하는 방식. 올바르지 않지만 VoteInfo를 Column으로 넣어서 Row로 수정하기엔 리소스가 너무 많이 들어감
@Composable
fun VoteInfoVoter(
    voters: List<VoteVoterModel>,
    modifier: Modifier = Modifier,
    rowCount: Int = voters.size
){
    val votersCount = voters.size
    // voter가 있으면 익명1 줄이 하나 추가로 보임
    val anonymousRowCount = if (voters.isNotEmpty()) 1 else 0
    val visibleRowCount = maxOf(votersCount + anonymousRowCount, rowCount)
    VoteInfoSection(
        title = { VoteInfoSectionTitle(text = "${votersCount + anonymousRowCount}명 투표") },
        content = {
            Column(
                modifier = modifier.height(
                    (VOTER_ROW_HEIGHT_DP * visibleRowCount + VOTER_ROW_SPACING_DP * (visibleRowCount - 1).coerceAtLeast(0)).dp
                ),
                verticalArrangement = Arrangement.spacedBy(VOTER_ROW_SPACING_DP.dp)
            ){
                if (voters.isNotEmpty()) {
                    Row(
                        modifier = Modifier.height(VOTER_ROW_HEIGHT_DP.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_profile),
                            contentDescription = null,
                            modifier = Modifier.size(14.dp),
                            tint = Color.Unspecified
                        )
                        Text(
                            text = "익명1",
                            style = CatchTableTheme.typography.bodyRG12,
                            color = CatchTableTheme.colors.gray600,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                // 익명1 줄을 제외한 나머지 줄 (빈 줄은 양쪽 후보 높이 맞추기용)
                repeat(visibleRowCount - anonymousRowCount) { index ->
                    val voter = voters.getOrNull(index)
                    Row(
                        modifier = Modifier.height(VOTER_ROW_HEIGHT_DP.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        if (voter != null) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_profile),
                                contentDescription = null,
                                modifier = Modifier.size(14.dp),
                                tint = Color.Unspecified
                            )
                            Text(
                                text = voter.displayName,
                                style = CatchTableTheme.typography.bodyRG12,
                                color = CatchTableTheme.colors.gray600,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }
        }
    )
}

private const val VOTER_ROW_HEIGHT_DP = 16
private const val VOTER_ROW_SPACING_DP = 4

@Preview(showBackground = true)
@Composable
private fun VoteInfoVoterPreview(){
    CatchTableTheme {
        VoteInfoVoter(
            voters = listOf(
                VoteVoterModel("김승혁"),
                VoteVoterModel("김승현"),
                VoteVoterModel("김승호"),
                VoteVoterModel("김승희"),
                VoteVoterModel("김승훈"),
                VoteVoterModel("김승열")
            )
        )
    }
}
