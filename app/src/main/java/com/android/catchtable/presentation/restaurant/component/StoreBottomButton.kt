package com.android.catchtable.presentation.restaurant.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.component.CatchTableButton
import com.android.catchtable.presentation.common.component.CatchTableButtonType
import com.android.catchtable.presentation.common.extension.noRippleClickable
import com.android.catchtable.presentation.common.theme.CatchTableTheme

@Composable
fun StoreBottomBar(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    onBookmarkClick: () -> Unit = {},
    onPhoneClick: () -> Unit = {},
    enabled: Boolean = false
){

    Column{
        //상단에만 border를 구현할 때 borderBehind보다 Column -> Box 방식이 간편해서 사용
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(CatchTableTheme.colors.gray200)
        )
        Row(
            modifier = modifier.padding(vertical = 8.dp, horizontal = 20.dp), //20.dp를 써야할지 22.dp를 써야할지 모르겠음
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ){
                StoreBottomBarButton(
                    type = BottomBarItemType.BOOKMARK,
                    onClick = onBookmarkClick
                )
                StoreBottomBarButton(
                    type = BottomBarItemType.PHONE,
                    onClick = onPhoneClick
                )
            }
            CatchTableButton(
                type = if(enabled) CatchTableButtonType.PRIMARY_ENABLED else CatchTableButtonType.PRIMARY_DISABLED_SECONDARY,
                text = if(enabled) "에약하기" else "바로 입장 가능",
                onClick = { if (enabled) onClick() }
            )
        }
    }
}

enum class BottomBarItemType{
    BOOKMARK, PHONE
}

@Composable
private fun StoreBottomBarButton(
    type: BottomBarItemType,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
){
    val (text, icon) = when (type) {
        BottomBarItemType.BOOKMARK -> Pair("6.3만", R.drawable.ic_bookmark) //일단 박아둠
        BottomBarItemType.PHONE -> Pair("전화", R.drawable.ic_phone)
    }

    Column(
        modifier = modifier.padding(horizontal = 6.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(3.dp)
    ) {
        Icon(
            painter = painterResource(id = icon),
            modifier = Modifier
                .size(24.dp)
                .noRippleClickable(
                    onClick = onClick
                ),
            contentDescription = type.toString(),
            tint = CatchTableTheme.colors.gray900
        )
        Text(
            text = text,
            style = CatchTableTheme.typography.captionB10,
            color = CatchTableTheme.colors.gray900
        )
    }
}

@Preview(showBackground = true)
@Composable
fun StoreBottomBarPreview(){
    CatchTableTheme{
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ){
            StoreBottomBar(
                enabled = true,
                onClick = {}
            )
            StoreBottomBar(
                enabled = false,
                onClick = {}
            )
        }
    }
}