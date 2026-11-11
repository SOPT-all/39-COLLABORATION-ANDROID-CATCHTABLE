package com.android.catchtable.presentation.restaurant.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.common.component.CatchTableButton
import com.android.catchtable.presentation.common.extension.noRippleClickable
import com.android.catchtable.presentation.common.model.CatchTableButtonType
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.home.model.StoreBottomBarItemType

@Composable
fun StoreBottomBar(
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onBookmarkClick: () -> Unit = {},
    onPhoneClick: () -> Unit = {}
){

    Column{
        HorizontalDivider(
            Modifier.width(1.dp),
            color = CatchTableTheme.colors.gray200
        )
        Row(
            modifier = modifier.padding(vertical = 8.dp, horizontal = 22.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(13.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ){
                StoreBottomBarButton(
                    type = StoreBottomBarItemType.BOOKMARK,
                    onClick = onBookmarkClick
                )

                StoreBottomBarButton(
                    type = StoreBottomBarItemType.PHONE,
                    onClick = onPhoneClick
                )
            }
            CatchTableButton(
                type = if(enabled) CatchTableButtonType.PRIMARY_ENABLED else CatchTableButtonType.PRIMARY_DISABLED_SECONDARY,
                text = if(enabled) "예약하기" else "바로 입장 가능",
                onClick = { if (enabled) onButtonClick() }
            )
        }
    }
}

@Composable
private fun StoreBottomBarButton(
    type: StoreBottomBarItemType,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
){

    Column(
        modifier = modifier.padding(horizontal = 6.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        Icon(
            modifier = Modifier
                .size(24.dp)
                .noRippleClickable(onClick = onClick),
            painter = painterResource(id = type.icon),
            contentDescription = type.toString(),
            tint = CatchTableTheme.colors.gray900
        )
        
        Text(
            text = type.text,
            style = CatchTableTheme.typography.captionB10,
            color = CatchTableTheme.colors.gray900
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun StoreBottomBarPreview(){
    CatchTableTheme{
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ){
            StoreBottomBar(
                enabled = true,
                onButtonClick = {}
            )
            StoreBottomBar(
                enabled = false,
                onButtonClick = {}
            )
        }
    }
}
