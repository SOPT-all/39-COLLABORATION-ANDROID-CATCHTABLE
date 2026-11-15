package com.android.catchtable.presentation.store.section

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.catchtable.presentation.store.component.StoreChip

@Composable
fun StoreChipSection(
    maxReservationCount: Int,
    facilities: List<String>,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        StoreChip(
            text = "최대 ${maxReservationCount}명 예약",
            isIconVisible = true,
        )

        facilities.forEach { facility ->
            StoreChip(
                text = facility,
            )
        }
    }
}