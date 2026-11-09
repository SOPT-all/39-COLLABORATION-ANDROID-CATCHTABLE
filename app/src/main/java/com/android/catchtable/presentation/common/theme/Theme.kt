package com.android.catchtable.presentation.common.theme

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalView

val LocalCatchTableColors = staticCompositionLocalOf { defaultCatchTableColors }
val LocalCatchTableTypography = staticCompositionLocalOf<CatchTableTypography>{ error("No Typography Provided") }

@Composable
fun CatchTableTheme(
    color: CatchTableColors = defaultCatchTableColors,
    typography: CatchTableTypography = defaultCatchTableTypography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalCatchTableColors provides color,
        LocalCatchTableTypography provides typography
    ) {
        content()
    }
}

object CatchTableTheme {
    val colors: CatchTableColors
        @Composable
        get() = LocalCatchTableColors.current
    val typography: CatchTableTypography
        @Composable
        get() = LocalCatchTableTypography.current
}