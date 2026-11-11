package com.android.catchtable.presentation.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.common.model.CatchTableButtonType
import com.android.catchtable.presentation.common.theme.CatchTableTheme

@Composable
fun CatchTableButton(
    text: String,
    type: CatchTableButtonType,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val isEnabled = type !in listOf(
        CatchTableButtonType.PRIMARY_DISABLED_PRIMARY,
        CatchTableButtonType.PRIMARY_DISABLED_SECONDARY
    )

    val style = (type.pressedStyle.takeIf { isPressed } ?: type.style)()

    Text(
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
        text = text,
        style = CatchTableTheme.typography.h1SB16,
        color = style.textColor,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true)
@Composable
private fun CatchTableButtonPreview(){
    CatchTableTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            //pressed는 interactive Mode로 확인 가능
            CatchTableButton(text="Button", type = CatchTableButtonType.PRIMARY_ENABLED, onClick = {})
            CatchTableButton(text="Button", type = CatchTableButtonType.PRIMARY_DISABLED_PRIMARY, onClick = {})
            CatchTableButton(text="Button", type = CatchTableButtonType.PRIMARY_DISABLED_SECONDARY, onClick = {})
            CatchTableButton(text="Button", type = CatchTableButtonType.WHITE_ENABLED, onClick = {})
        }
    }
}
