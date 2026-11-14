package com.android.catchtable.presentation.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.theme.CatchTableTheme

@Composable
fun HomeCategoryItem(
    name: String,
    @DrawableRes imageRes: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.width(60.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            modifier = Modifier
                .size(44.dp)
                .clip(RoundedCornerShape(16.dp))
        )
        Text(
            text = name,
            style = CatchTableTheme.typography.captionMD10,
            color = CatchTableTheme.colors.gray900
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeCategoryItemPreview() {
    val images = listOf(
        R.drawable.img_category_01, R.drawable.img_category_02, R.drawable.img_category_03,
        R.drawable.img_category_04, R.drawable.img_category_05, R.drawable.img_category_06,
        R.drawable.img_category_07, R.drawable.img_category_08, R.drawable.img_category_09,
        R.drawable.img_category_10, R.drawable.img_category_11, R.drawable.img_category_12,
        R.drawable.img_category_13, R.drawable.img_category_14, R.drawable.img_category_15,
    )

    CatchTableTheme {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            images.chunked(5).forEach { row ->
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    row.forEach { image ->
                        HomeCategoryItem(name = "카테고리", imageRes = image)
                    }
                }
            }
        }
    }
}