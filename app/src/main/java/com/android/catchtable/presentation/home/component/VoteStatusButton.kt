package com.android.catchtable.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.extension.noRippleClickable
import com.android.catchtable.presentation.common.theme.CatchTableTheme

@Composable
fun VoteStatusButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
){
    Row(
        modifier = modifier
            .clip(CircleShape)
            .background(CatchTableTheme.colors.gray800)
            .noRippleClickable(onClick = onClick)
            .padding(start = 12.dp, end = 20.dp, top = 4.dp, bottom = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ){
            Icon(
                painter = painterResource(id = R.drawable.ic_vote_graph),
                modifier = Modifier.size(24.dp),
                contentDescription = "Vote Graph",
                tint = Color.Unspecified
            )
            Row(
                modifier = Modifier.padding(all = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ){
                Text(
                    text = "함께 고르기 투표 중...",
                    style = CatchTableTheme.typography.bodyMD12,
                    color = CatchTableTheme.colors.white
                )
                Text(
                    text = "·",
                    style = CatchTableTheme.typography.bodyMD12,
                    color = CatchTableTheme.colors.gray500
                )
                Text(
                    text = "2개 식당",
                    style = CatchTableTheme.typography.bodyMD12,
                    color = CatchTableTheme.colors.gray500
                )
            }
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_vote_next),
            modifier = Modifier.size(12.dp),
            contentDescription = "Next",
            tint = CatchTableTheme.colors.white
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun VoteStatusButtonPreview(){
    CatchTableTheme{
        VoteStatusButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {}
        )
    }
}