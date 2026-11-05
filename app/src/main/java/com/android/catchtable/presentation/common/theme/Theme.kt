package com.android.catchtable.presentation.common.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = OrangeBase,
    secondary = OrangeBase,
    tertiary = Pink
)

private val LightColorScheme = lightColorScheme(
    primary = OrangeBase,
    secondary = OrangeBase,
    tertiary = Pink
)

val LocalCatchTableTypography = staticCompositionLocalOf<CatchTableTypography> {
    error("No CatchTableTypography provided")
}

@Composable
fun _39COLLABORATIONANDROIDCATCHTABLETheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val typography = catchTableTypography

    CompositionLocalProvider(
        LocalCatchTableTypography provides typography
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}

object CatchTableTheme {
    val typography: CatchTableTypography
        @Composable
        get() = LocalCatchTableTypography.current
}
