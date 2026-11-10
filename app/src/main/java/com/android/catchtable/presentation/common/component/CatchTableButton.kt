package com.android.catchtable.presentation.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.common.theme.CatchTableTheme

data class ButtonStyle(
    val backgroundColor: Color,
    val borderColor: Color,
    val textColor: Color
)

enum class CatchTableButtonType {
    PRIMARY_ENABLED,
    PRIMARY_DISABLED_PRIMARY, // 비활성화1
    PRIMARY_DISABLED_SECONDARY, // 비활성화2
    WHITE_ENABLED
}

@Composable
fun CatchTableButton(
    modifier: Modifier = Modifier,
    text: String = "Button",
    type: CatchTableButtonType,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val isEnabled = type !in listOf(
        CatchTableButtonType.PRIMARY_DISABLED_PRIMARY,
        CatchTableButtonType.PRIMARY_DISABLED_SECONDARY
    )

    val style = when {
        //pressed일 경우
        type == CatchTableButtonType.PRIMARY_ENABLED && isPressed -> ButtonStyle(
            backgroundColor = CatchTableTheme.colors.orangeBaseClicked,
            borderColor = Color.Transparent,
            textColor = CatchTableTheme.colors.gray100
        )
        else -> when (type) {
            CatchTableButtonType.PRIMARY_ENABLED -> ButtonStyle(
                backgroundColor = CatchTableTheme.colors.orangeBase,
                borderColor = Color.Transparent,
                textColor = CatchTableTheme.colors.white
            )
            CatchTableButtonType.PRIMARY_DISABLED_PRIMARY -> ButtonStyle(
                backgroundColor = CatchTableTheme.colors.blackAlpha04,
                borderColor = Color.Transparent,
                textColor = CatchTableTheme.colors.gray300
            )
            CatchTableButtonType.PRIMARY_DISABLED_SECONDARY -> ButtonStyle(
                backgroundColor = CatchTableTheme.colors.gray200,
                borderColor = Color.Transparent,
                textColor = CatchTableTheme.colors.gray400
            )
            CatchTableButtonType.WHITE_ENABLED -> ButtonStyle(
                backgroundColor = CatchTableTheme.colors.white,
                borderColor = CatchTableTheme.colors.gray200,
                textColor = CatchTableTheme.colors.gray900
            )
        }
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(style.backgroundColor)
            .border(1.dp, style.borderColor, RoundedCornerShape(12.dp))
            .clickable(
                interactionSource = interactionSource,
                indication = null,
                enabled = isEnabled,
                onClick = onClick
            )
            .padding(vertical = 12.dp, horizontal = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            style = CatchTableTheme.typography.h1SB16,
            color = style.textColor
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CatchTableButtonPreview(){
    CatchTableTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            //pressed는 interactive Mode로 확인 가능
            CatchTableButton(type = CatchTableButtonType.PRIMARY_ENABLED, onClick = {})
            CatchTableButton(type = CatchTableButtonType.PRIMARY_DISABLED_PRIMARY, onClick = {})
            CatchTableButton(type = CatchTableButtonType.PRIMARY_DISABLED_SECONDARY, onClick = {})
            CatchTableButton(type = CatchTableButtonType.WHITE_ENABLED, onClick = {})
        }
    }
}