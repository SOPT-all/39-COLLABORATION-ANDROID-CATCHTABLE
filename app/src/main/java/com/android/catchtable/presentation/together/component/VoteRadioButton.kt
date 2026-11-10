package com.android.catchtable.presentation.together.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.common.extension.noRippleClickable
import com.android.catchtable.presentation.common.theme.CatchTableTheme

@Composable
fun VoteRadioButton(
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
){
    val borderColor = if (selected) CatchTableTheme.colors.orangeBase else CatchTableTheme.colors.gray300

    Box(
        modifier = modifier
            .size(24.dp)
            .padding(all = 1.dp)
            .clip(CircleShape)
            .border(width = 1.dp, color = borderColor, shape = CircleShape)
            .noRippleClickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        if (selected) {
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .background(color = CatchTableTheme.colors.orangeBase, shape = CircleShape)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun VoteRadioButtonPreview(){
    CatchTableTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            VoteRadioButton(selected = true, onClick = {})
            VoteRadioButton(selected = false, onClick = {})
        }
    }
}
