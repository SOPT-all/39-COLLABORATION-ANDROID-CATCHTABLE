package com.android.catchtable.presentation.restaurant.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.component.asyncimage.BaseAsyncImage
import com.android.catchtable.presentation.common.theme.CatchTableTheme

@Composable
fun RestaurantCardPhoto(
    imgUrl: String?,
    userCount: Int,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxWidth(),
    ) {
        BaseAsyncImage(
            imgUrl = imgUrl,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(21f / 16f)
                .clip(shape = RoundedCornerShape(16.dp)),
        )

        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 8.dp, bottom = 11.dp)
                .background(
                    color = CatchTableTheme.colors.blackAlpha40,
                    shape = CircleShape,
                )
                .padding(start = 7.dp, end = 11.dp, top = 6.dp, bottom = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(2.dp),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_restaurant_fire),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(20.dp)
            )

            Text(
                text = userCount.toString() + "명이 보고 있어요!",
                color = CatchTableTheme.colors.white,
                style = CatchTableTheme.typography.bodySB12,
                modifier = Modifier.padding(vertical = 2.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RestaurantCardPhotoPreview() {
    CatchTableTheme {
        RestaurantCardPhoto(
            imgUrl = null,
            userCount = 72,
            modifier = Modifier.padding(10.dp)
        )
    }
}
