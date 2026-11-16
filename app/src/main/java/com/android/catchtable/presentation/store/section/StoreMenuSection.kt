package com.android.catchtable.presentation.store.section

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.store.component.StoreCardMenu
import com.android.catchtable.presentation.store.model.StoreMenuUiModel
import com.android.catchtable.presentation.store.model.dummyStoreUiModel

@Composable
fun StoreMenuSection(
    menus: List<StoreMenuUiModel>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(14.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "메뉴",
                style = CatchTableTheme.typography.h1MD16,
                color = CatchTableTheme.colors.gray900,
            )

            Spacer(modifier = Modifier.width(4.dp))

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_store_next),
                contentDescription = null,
                modifier = Modifier.size(12.dp),
                tint = CatchTableTheme.colors.gray400,
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "메뉴판 이미지",
                style = CatchTableTheme.typography.h3RG14,
                color = CatchTableTheme.colors.orangeBase,
            )
        }

        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            menus.forEach { menu ->
                StoreCardMenu(
                    menu = menu,
                    modifier = Modifier.width(136.dp),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun StoreMenuSectionPreview() {
    CatchTableTheme {
        StoreMenuSection(
            menus = dummyStoreUiModel.menus,
        )
    }
}