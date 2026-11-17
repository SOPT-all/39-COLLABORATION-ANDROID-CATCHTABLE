package com.android.catchtable.presentation.home.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 6.dp)
    ) {
        HomeHeader(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterStart)
        )
        HomeSearchTextField(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 49.dp, end = 78.dp)
                .fillMaxWidth()
        )
    }
}