package com.android.catchtable.presentation.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.theme.CatchTableTheme

@Composable
fun HomeSectionHeader(
    title: String,
    actionText: String,
    modifier: Modifier = Modifier,
    subtitle: String? = null,
    @DrawableRes titleIcon: Int? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    text = title,
                    style = CatchTableTheme.typography.displayB18,
                    color = CatchTableTheme.colors.gray900,
                )
                if (titleIcon != null) {
                    Icon(
                        painter = painterResource(id = titleIcon),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp),
                        tint = Color.Unspecified,
                    )
                }
            }
            if (subtitle != null) {
                Text(
                    text = subtitle,
                    style = CatchTableTheme.typography.h3RG14,
                    color = CatchTableTheme.colors.gray500,
                )
            }
        }
        Row(
            modifier = Modifier.padding(top = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Text(
                text = actionText,
                style = CatchTableTheme.typography.h3MD14,
                color = CatchTableTheme.colors.gray800,
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_home_next),
                contentDescription = null,
                modifier = Modifier.size(12.dp),
                tint = CatchTableTheme.colors.gray800,
            )
        }
    }
}