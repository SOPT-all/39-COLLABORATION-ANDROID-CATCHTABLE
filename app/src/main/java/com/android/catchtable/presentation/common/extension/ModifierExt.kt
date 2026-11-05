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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.common.theme.BlackAlpha70

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
        ) }

//elevation level 1
fun Modifier.elevation1(
    shape: Shape = RectangleShape
): Modifier =
    this.shadow(
    elevation = 8.dp,
    shape = shape,
    spotColor = Color.Black.copy(alpha = 0.06f),
    ambientColor = Color.Black.copy(alpha = 0.06f)
)

//elevation level 2
fun Modifier.elevation2(
    shape: Shape = RectangleShape
): Modifier =
    this.shadow(
        elevation = 8.dp,
        shape = shape,
        spotColor = Color.Black.copy(alpha = 0.3f),
        ambientColor = Color.Black.copy(alpha = 0.3f)
    )
    .offset(y = 4.dp)

// glassMorphism 1
fun Modifier.glassMorphism1(
    shape: Shape = RectangleShape,
    blurRadius: Dp = 8.dp
): Modifier = this
    .background(BlackAlpha70, shape = shape)
    .blur(blurRadius)
