package com.android.catchtable.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.home.component.HomeHeader
import com.android.catchtable.presentation.main.component.BottomNavigationBar
import com.android.catchtable.presentation.main.model.BottomNavItem

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(CatchTableTheme.colors.white),
    ) {
        HomeHeader(modifier = Modifier.fillMaxWidth())

        Box(modifier = Modifier.weight(1f)) {
            LazyColumn(
                state = listState,
                modifier = Modifier.fillMaxSize(),
            ) {
            }
        }

        BottomNavigationBar(
            selectedItem = BottomNavItem.HOME,
            onItemClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    CatchTableTheme {
        HomeScreen()
    }
}