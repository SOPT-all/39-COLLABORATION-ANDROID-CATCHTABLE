package com.android.catchtable.presentation.vote.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.common.theme.CatchTableTheme

@Composable
fun VoteInfoSection(
    title: @Composable () -> Unit,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    spaceBy: Dp = 8.dp
){
    Column(
        modifier = modifier.padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(spaceBy)
    ){
        title()
        content()
    }
}

@Composable
fun VoteInfoSectionTitle(
    text: String
) {
    Text(
        text = text,
        style = CatchTableTheme.typography.h3B14,
        color = CatchTableTheme.colors.gray900
    )
}

@Composable
fun VoteInfoSectionContent(
    text: String,
    minLines: Int = 1
){
    Text(
        text = text,
        minLines = minLines,
        style = CatchTableTheme.typography.bodyRG12,
        color = CatchTableTheme.colors.gray600
    )
}
