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

    uiState.store?.let { store ->
        StoreScreen(
            store = store,
            userCount = uiState.userCount,
            maxReservationCount = uiState.maxReservationCount,
            photoTabCount = uiState.photoTabCount,
            reviewTabCount = uiState.reviewTabCount,
            onBackClick = onBackClick,
            onTogetherClick = onTogetherClick,
            modifier = modifier,
        )
    }
}