package com.android.catchtable.presentation.common.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.android.catchtable.presentation.common.theme.CatchTableTheme

data class ButtonStyle(
    val backgroundColor: Color,
    val textColor: Color,
    val borderColor: Color = Color.Unspecified
)

enum class CatchTableButtonType(
    val style: @Composable () -> ButtonStyle,
    val pressedStyle: (@Composable () -> ButtonStyle)? = null,
) {
    PRIMARY_ENABLED(
        style = {
            ButtonStyle(
                backgroundColor = CatchTableTheme.colors.orangeBase,
                textColor = CatchTableTheme.colors.white
            )
        },
        pressedStyle = {
            ButtonStyle(
                backgroundColor = CatchTableTheme.colors.orangeBaseClicked,
                textColor = CatchTableTheme.colors.gray100
            )
        },
    ),
    PRIMARY_DISABLED_PRIMARY(
        style = {
            ButtonStyle(
                backgroundColor = CatchTableTheme.colors.blackAlpha04,
                textColor = CatchTableTheme.colors.gray300
            )
        },
    ),
    PRIMARY_DISABLED_SECONDARY(
        style = {
            ButtonStyle(
                backgroundColor = CatchTableTheme.colors.gray200,
                textColor = CatchTableTheme.colors.gray400
            )
        },
    ),
    WHITE_ENABLED(
        style = {
            ButtonStyle(
                backgroundColor = CatchTableTheme.colors.white,
                textColor = CatchTableTheme.colors.gray900,
                borderColor = CatchTableTheme.colors.gray200
            )
        },
    ),
}