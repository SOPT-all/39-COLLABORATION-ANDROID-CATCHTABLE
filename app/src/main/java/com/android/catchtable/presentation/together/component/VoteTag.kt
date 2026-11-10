package com.android.catchtable.presentation.together.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.android.catchtable.presentation.common.theme.CatchTableTheme

data class VoteTagStyle(
    val text: String,
    val backgroundColor: Color,
    val borderColor: Color,
    val textColor: Color,
    val iconColor: Color?
)

enum class VoteTagType {
    RESERVED,   // 예약하기
    VIEW_ALL,   // 전체보기
    VOTE_ENDED  // 투표종료
}

@Composable
fun VoteTag(
    type: VoteTagType,
    modifier: Modifier = Modifier
) {
    val style = when (type) {
        VoteTagType.RESERVED -> VoteTagStyle(
            text = "예약하기",
            backgroundColor = CatchTableTheme.colors.orangeBaseAlpha05,
            borderColor = CatchTableTheme.colors.orangeBase,
            textColor = CatchTableTheme.colors.orangeBase,
            iconColor = CatchTableTheme.colors.orangeBase
        )

        VoteTagType.VIEW_ALL -> VoteTagStyle(
            text = "전체보기",
            backgroundColor = Color.Unspecified,
            borderColor = CatchTableTheme.colors.gray300,
            textColor = CatchTableTheme.colors.gray900,
            iconColor = CatchTableTheme.colors.gray600
        )

        VoteTagType.VOTE_ENDED -> VoteTagStyle(
            text = "투표종료",
            backgroundColor = CatchTableTheme.colors.orangeBase,
            borderColor = Color.Transparent,
            textColor = CatchTableTheme.colors.white,
            iconColor = null
        )
    }

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(style.backgroundColor)
            .border(1.dp, style.borderColor, RoundedCornerShape(16.dp))
            .padding(vertical = 6.dp, horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = style.text,
            style = CatchTableTheme.typography.bodyB12,
            color = style.textColor
        )
        style.iconColor?.let { color ->
            Icon(
                painter = painterResource(id = R.drawable.ic_vote_next),
                contentDescription = "Next",
                tint = color
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VoteTagPreview(){
    CatchTableTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            VoteTag(type = VoteTagType.RESERVED)
            VoteTag(type = VoteTagType.VIEW_ALL)
            VoteTag(type = VoteTagType.VOTE_ENDED)
        }
    }
}