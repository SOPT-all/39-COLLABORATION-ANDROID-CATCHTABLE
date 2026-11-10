package com.android.catchtable.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
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

@Composable
fun HomeHeader(
    modifier: Modifier = Modifier,
    onHistoryClick: () -> Unit = {},
    onNotificationClick: () -> Unit = {}
){
    Row(
        modifier = modifier
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = R.drawable.ic_symbol),
            contentDescription = "Symbol",
            tint = Color.Unspecified
        )
        //Todo:검색창 component 제작 후 추가
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            modifier = Modifier
                .size(24.dp)
                .noRippleClickable(onClick = onHistoryClick),
            painter = painterResource(id = R.drawable.ic_history),
            contentDescription = "History",
            tint = CatchTableTheme.colors.gray900
        )
        Icon(
            modifier = Modifier
                .size(24.dp)
                .noRippleClickable(onClick = onNotificationClick),
            painter = painterResource(id = R.drawable.ic_notification),
            contentDescription = "Notification",
            tint = CatchTableTheme.colors.gray900
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeHeaderPreview(){
    CatchTableTheme{
        HomeHeader()
    }
}