package com.android.catchtable.presentation.together.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.extension.noRippleClickable
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.together.model.VoteTagType

@Composable
fun VoteTag(
    modifier: Modifier = Modifier,
    type: VoteTagType,
    onClick: () -> Unit
) {
    val style = type.style()
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(style.backgroundColor)
            .border(1.dp, style.borderColor, RoundedCornerShape(16.dp))
            .noRippleClickable(onClick = onClick)
            .padding(vertical = 6.dp, horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = style.text,
            style = CatchTableTheme.typography.bodyB12,
            color = style.textColor
        )
        style.iconColor?.let { color ->
            Icon(
                modifier = Modifier.size(8.dp),
                painter = painterResource(id = R.drawable.ic_vote_next),
                contentDescription = "Next",
                tint = color
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun VoteTagPreview(){
    CatchTableTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            VoteTag(type = VoteTagType.RESERVED, onClick = {})
            VoteTag(type = VoteTagType.VIEW_ALL, onClick = {})
            VoteTag(type = VoteTagType.VOTE_ENDED, onClick = {})
        }
    }
}