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
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.domain.model.vote.VoteVoterResponseModel
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import kotlin.collections.getOrNull

//높이를 직접 주입하는 방식. 올바르지 않지만 VoteInfo를 Column으로 넣어서 Row로 수정하기엔 리소스가 너무 많이 들어감
@Composable
fun VoteInfoVoter(
    voters: List<VoteVoterResponseModel>,
    modifier: Modifier = Modifier
){
    VoteInfoSection(
        title = { VoteInfoSectionTitle(text = "${voters.size}명 투표") },
        content = {
            Column(
                modifier = modifier.height((VOTER_ROW_HEIGHT_DP * MAX_VISIBLE_VOTER_COUNT + VOTER_ROW_SPACING_DP * (MAX_VISIBLE_VOTER_COUNT - 1)).dp),
                verticalArrangement = Arrangement.spacedBy(VOTER_ROW_SPACING_DP.dp)
            ){
                repeat(MAX_VISIBLE_VOTER_COUNT) { index ->
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


private const val MAX_VISIBLE_VOTER_COUNT = 5
private const val VOTER_ROW_HEIGHT_DP = 16
private const val VOTER_ROW_SPACING_DP = 4
