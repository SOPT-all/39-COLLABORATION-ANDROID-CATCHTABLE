package com.android.catchtable.presentation.store.section

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.catchtable.R
import com.android.catchtable.presentation.common.component.CatchTableBadgeLine9
import com.android.catchtable.presentation.common.component.CatchTableBadgeSBD
import com.android.catchtable.presentation.common.theme.CatchTableTheme
import com.android.catchtable.presentation.store.model.StoreStationUiModel
import com.android.catchtable.presentation.store.model.dummyStoreUiModel

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
        verticalArrangement = Arrangement.spacedBy(6.dp),
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

            Spacer(modifier = Modifier.width(8.dp))

            CatchTableBadgeLine9()

            Spacer(modifier = Modifier.width(4.dp))

            CatchTableBadgeSBD()

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "${station.name}에서 ${station.distanceMeters}m",
                style = CatchTableTheme.typography.bodyMD12,
                color = CatchTableTheme.colors.gray900,
            )

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_store_dropdown),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = CatchTableTheme.colors.gray400,
            )

            Spacer(modifier = Modifier.width(4.dp))

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_store_map),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = Color.Unspecified,
            )

            Spacer(modifier = Modifier.width(1.dp))

            Text(
                text = "위치",
                style = CatchTableTheme.typography.bodyMD12,
                color = CatchTableTheme.colors.blue,
            )
        }

        Row(
            modifier = Modifier.height(20.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_store_price),
                contentDescription = null,
                modifier = Modifier.size(14.dp),
                tint = Color.Unspecified,
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = priceRange,
                style = CatchTableTheme.typography.bodyMD12,
                color = CatchTableTheme.colors.gray900,
            )

            Spacer(modifier = Modifier.width(4.dp))

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_store_question),
                contentDescription = null,
                modifier = Modifier.size(12.dp),
                tint = CatchTableTheme.colors.gray400,
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_store_time),
                contentDescription = null,
                modifier = Modifier.size(14.dp),
                tint = Color.Unspecified,
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = businessHours,
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
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_store_phone),
                contentDescription = null,
                modifier = Modifier.size(14.dp),
                tint = CatchTableTheme.colors.gray900,
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = phone,
                style = CatchTableTheme.typography.bodyMD12,
                color = CatchTableTheme.colors.gray900,
            )

            Spacer(modifier = Modifier.width(2.dp))

            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_store_info),
                contentDescription = null,
                modifier = Modifier.size(14.dp),
                tint = CatchTableTheme.colors.gray400,
            )

            Spacer(modifier = Modifier.width(6.dp))

            Text(
                text = "복사",
                style = CatchTableTheme.typography.captionMD10,
                color = CatchTableTheme.colors.orangeBase,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun StoreInfoSectionPreview() {
    CatchTableTheme {
        StoreInfoSection(
            station = dummyStoreUiModel.station,
            priceRange = dummyStoreUiModel.priceRange,
            businessHours = dummyStoreUiModel.businessHours,
            phone = dummyStoreUiModel.phone,
        )
    }
}