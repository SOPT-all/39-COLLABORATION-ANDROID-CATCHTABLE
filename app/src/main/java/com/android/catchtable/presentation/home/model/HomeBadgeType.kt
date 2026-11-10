package com.android.catchtable.presentation.home.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.android.catchtable.presentation.common.theme.CatchTableTheme

enum class HomeBadgeType(
    val text: String,
    val color: @Composable () -> Color,
) {
    HOT(
        text = "핫플",
        color = { CatchTableTheme.colors.red }
    ),
    TOP(
        text = "인기",
        color = { CatchTableTheme.colors.blue }
    ),
}
