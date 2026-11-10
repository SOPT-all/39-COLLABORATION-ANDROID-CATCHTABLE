package com.android.catchtable.presentation.common.component.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.theme.CatchTableTheme

@Composable
fun CatchTableSearchTextField(
    modifier: Modifier = Modifier,
    placeholder: String = "",
) {
    val colors = CatchTableTheme.colors
    val typography = CatchTableTheme.typography

    val shape = RoundedCornerShape(30.dp)

    Row(
        modifier = modifier
            .clip(shape)
            .background(color = colors.gray100)
            .border(width = 1.dp, color = colors.gray200, shape = shape)
            .padding(horizontal = 14.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_search),
            contentDescription = null,
            modifier = Modifier.size(14.dp),
            tint = Color.Unspecified,
        )


        Text(
            text = placeholder,
            style = typography.h3MD14,
            color = colors.gray400,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CatchTableSearchTextFieldPreview() {
    CatchTableTheme {
        CatchTableSearchTextField(
            modifier = Modifier
                .padding(20.dp)
                .width(248.dp),
            placeholder = "혜택을 검색해보세요!",
        )
    }
}