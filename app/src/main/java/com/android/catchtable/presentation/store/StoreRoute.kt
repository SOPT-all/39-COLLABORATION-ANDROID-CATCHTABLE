package com.android.catchtable.presentation.store

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun StoreRoute(
    storeId: Long,
    onBackClick: () -> Unit,
    onTogetherClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: StoreViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(storeId) {
        viewModel.getStoreDetail(storeId)
    }

    StoreScreen(
        uiState = uiState,
        onBackClick = onBackClick,
        onTogetherClick = onTogetherClick,
        modifier = modifier,
    )
}