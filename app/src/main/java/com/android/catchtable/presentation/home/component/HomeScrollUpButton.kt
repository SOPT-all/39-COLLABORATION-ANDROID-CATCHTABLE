package com.android.catchtable.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.extension.elevation2
import com.android.catchtable.presentation.common.extension.noRippleClickable
import com.android.catchtable.presentation.common.theme.CatchTableTheme

@Composable
fun HomeScrollUpButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .size(40.dp)
            .elevation2(shape = CircleShape)
            .background(color = CatchTableTheme.colors.white, shape = CircleShape)
            .clip(CircleShape)
            .noRippleClickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_scroll_up),
            contentDescription = "Scroll Up",
            tint = CatchTableTheme.colors.gray700
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScrollUpButtonPreview(){
    CatchTableTheme {
        HomeScrollUpButton(
            modifier = Modifier.padding(20.dp),
            onClick = {}
        )
    }
}