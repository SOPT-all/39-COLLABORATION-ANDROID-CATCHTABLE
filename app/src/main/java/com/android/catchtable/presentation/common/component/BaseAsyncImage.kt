package com.android.catchtable.presentation.common.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import coil3.compose.AsyncImage
import com.android.catchtable.presentation.common.theme.CatchTableTheme

@Composable
fun BaseAsyncImage(
    imgUrl: String?,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Crop,
) {
    val emptyColor = CatchTableTheme.colors.gray200
    val emptyPainter = remember(emptyColor) { ColorPainter(emptyColor) }

    AsyncImage(
        model = imgUrl,
        contentDescription = contentDescription,
        contentScale = contentScale,
        placeholder = emptyPainter,
        error = emptyPainter,
        modifier = modifier,
    )
}
