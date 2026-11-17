package com.android.catchtable.presentation.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.main.component.BottomNavigationBar
import com.android.catchtable.presentation.main.model.BottomNavItem
import kotlinx.collections.immutable.toPersistentList

@Composable
fun MainScreen(
    appState: MainAppState = rememberMainAppState(),
) {
    val currentTab by appState.currentTab.collectAsStateWithLifecycle()
    val isBottomBarVisible by appState.isBottomBarVisible.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = CatchTableTheme.colors.white,
        bottomBar = {
            BottomNavigationBar(
                visible = isBottomBarVisible,
                items = BottomNavItem.entries.toPersistentList(),
                selectedItem = currentTab,
                onItemClick = appState::navigate,
            )
        },
    ) { innerPadding ->
        MainNavHost(
            appState = appState,
            innerPadding = innerPadding,
        )
    }
}
