package com.android.catchtable.presentation.restaurant.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.extension.noRippleClickable
import com.android.catchtable.presentation.common.theme.CatchTableTheme

@Composable
fun StoreHeader(
    modifier: Modifier = Modifier,
    onSearchClick: () -> Unit = {},
    onBookmarkClick: () -> Unit = {},
    onShareClick: () -> Unit = {},
    onBackClick: () -> Unit
){
    Row(
        modifier = modifier
            .padding(vertical = 9.dp, horizontal = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ){
            Icon(
                modifier = Modifier
                    .size(22.dp)
                    .noRippleClickable(onClick = onBackClick),
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "Back",
                tint = CatchTableTheme.colors.gray900
            )
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = R.drawable.ic_home),
                contentDescription = "Home",
                tint = CatchTableTheme.colors.gray900
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ){
            Icon(
                modifier = Modifier
                    .size(20.dp)
                    .noRippleClickable(onClick = onSearchClick),
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search",
                tint = CatchTableTheme.colors.gray900
            )
            Icon(
                modifier = Modifier
                    .size(20.dp)
                    .noRippleClickable(onClick = onBookmarkClick),
                painter = painterResource(id = R.drawable.ic_bookmark),
                contentDescription = "Bookmark",
                tint = CatchTableTheme.colors.gray900
            )
            Icon(
                modifier = Modifier
                    .size(20.dp)
                    .noRippleClickable(onClick = onShareClick),
                painter = painterResource(id = R.drawable.ic_share20),
                contentDescription = "Share",
                tint = CatchTableTheme.colors.gray900
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun StoreHeaderPreview() {
    CatchTableTheme {
        StoreHeader(modifier = Modifier.fillMaxWidth(), onBackClick = {})
    }
}