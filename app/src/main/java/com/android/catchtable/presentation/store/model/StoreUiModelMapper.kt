package com.android.catchtable.presentation.store.model

import com.android.catchtable.domain.model.store.StoreDetailModel
import java.time.LocalTime
import java.util.Locale

fun StoreDetailModel.toUiModel() = StoreUiModel(
    storeId = storeId,
    name = name,
    category = category,
    region = region,
    intro = intro,
    rating = rating,
    reviewCount = reviewCount,
    isOpen = isOpenNow(businessHours),
    station = StoreStationUiModel(
        name = station.name,
        lines = station.lines,
        distanceMeters = station.distanceMeters,
    ),
    priceRange = priceRange,
    businessHours = businessHours,
    phone = phone,
    imageUrls = imageUrls,
    menus = representativeMenus.map { menu ->
        StoreMenuUiModel(
            id = menu.menuId,
            storeId = storeId,
            imgUrl = menu.imageUrl,
            name = menu.name,
            price = "%,d".format(Locale.KOREA, menu.price),
            isPriceFrom = menu.isPriceFrom,
        )
    },
    aiSummary = aiSummary?.let { summary ->
        StoreAiSummaryUiModel(
            title = summary.title,
            lines = summary.lines,
        )
    },
    amenities = amenities.map { amenity ->
        StoreAmenityUiModel(
            category = amenity.category,
            content = amenity.content,
        )
    },
)

private fun isOpenNow(businessHours: String): Boolean {
    val times =
        Regex("\\d{2}:\\d{2}").findAll(businessHours).map { LocalTime.parse(it.value) }.toList()
    if (times.size < 2) return false

    val openTime = times[0]
    val closeTime = times[1]
    val now = LocalTime.now()

    return if (openTime < closeTime) {
        now >= openTime && now < closeTime
    } else {
        now >= openTime || now < closeTime
    }
}
