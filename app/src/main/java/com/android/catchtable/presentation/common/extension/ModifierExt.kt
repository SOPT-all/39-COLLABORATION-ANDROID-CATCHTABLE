package com.android.catchtable.presentation.common.extension

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.common.theme.CatchTableTheme

@Composable
inline fun Modifier.noRippleClickable(
    enabled: Boolean = true,
    crossinline onClick: () -> Unit,
): Modifier =
    composed {
        this.clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() },
            onClick = { onClick() },
            enabled = enabled,
        )
    }

//elevation level 1
fun Modifier.elevation1(
    shape: Shape = RectangleShape
): Modifier =
    this.dropShadow(
        shape = shape,
        shadow = Shadow(
            radius = 8.dp,
            spread = 0.dp,
            color = Color.Black.copy(alpha = 0.06f),
            offset = DpOffset.Zero
        )
    )

//elevation level 2
fun Modifier.elevation2(
    shape: Shape = RectangleShape
): Modifier =
    this.dropShadow(
        shape = shape,
        shadow = Shadow(
            radius = 8.dp,
            spread = 0.dp,
            color = Color.Black.copy(alpha = 0.3f),
            offset = DpOffset(0.dp, 4.dp)
        )
    )
