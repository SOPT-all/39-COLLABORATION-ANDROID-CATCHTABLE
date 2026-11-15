package com.android.catchtable.presentation.store.section

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.component.CatchTableBadgeLine9
import com.android.catchtable.presentation.common.component.CatchTableBadgeSBD
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.store.model.StoreStationUiModel

@Composable
fun StoreInfoSection(
    station: StoreStationUiModel,
    priceRange: String,
    businessHours: String,
    phone: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_store_location),
                contentDescription = null,
                modifier = Modifier.size(14.dp),
                tint = Color.Unspecified,
            )

            CatchTableBadgeLine9(
                modifier = Modifier.padding(start = 8.dp),
            )

            CatchTableBadgeSBD(
                modifier = Modifier.padding(start = 4.dp),
            )

            Text(
                text = "${station.name}에서 ${station.distanceMeters}m",
                modifier = Modifier.padding(start = 8.dp),
                style = CatchTableTheme.typography.bodyMD12,
                color = CatchTableTheme.colors.gray900,
            )

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_store_dropdown),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = CatchTableTheme.colors.gray400,
            )

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_store_map),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .size(20.dp),
                tint = Color.Unspecified,
            )

            Text(
                text = "위치",
                modifier = Modifier.padding(start = 1.dp),
                style = CatchTableTheme.typography.bodyMD12,
                color = CatchTableTheme.colors.blue,
            )
        }

        Row(
            modifier = Modifier
                .padding(top = 6.dp)
                .height(20.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_store_price),
                contentDescription = null,
                modifier = Modifier.size(14.dp),
                tint = Color.Unspecified,
            )

            Text(
                text = priceRange,
                modifier = Modifier.padding(start = 8.dp),
                style = CatchTableTheme.typography.bodyMD12,
                color = CatchTableTheme.colors.gray900,
            )

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_store_question),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .size(12.dp),
                tint = CatchTableTheme.colors.gray400,
            )
        }

        Row(
            modifier = Modifier
                .padding(top = 6.dp)
                .height(20.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_store_time),
                contentDescription = null,
                modifier = Modifier.size(14.dp),
                tint = Color.Unspecified,
            )

            Text(
                text = businessHours,
                modifier = Modifier.padding(start = 8.dp),
                style = CatchTableTheme.typography.bodyMD12,
                color = CatchTableTheme.colors.gray900,
            )

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_store_dropdown),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = CatchTableTheme.colors.gray400,
            )
        }

        Row(
            modifier = Modifier.padding(top = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_store_phone),
                contentDescription = null,
                modifier = Modifier.size(14.dp),
                tint = CatchTableTheme.colors.gray900,
            )

            Text(
                text = phone,
                modifier = Modifier.padding(start = 8.dp),
                style = CatchTableTheme.typography.bodyMD12,
                color = CatchTableTheme.colors.gray900,
            )

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_store_info),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 2.dp)
                    .size(14.dp),
                tint = CatchTableTheme.colors.gray400,
            )

            Text(
                text = "복사",
                modifier = Modifier.padding(start = 6.dp),
                style = CatchTableTheme.typography.captionMD10,
                color = CatchTableTheme.colors.orangeBase,
            )
        }
    }
}