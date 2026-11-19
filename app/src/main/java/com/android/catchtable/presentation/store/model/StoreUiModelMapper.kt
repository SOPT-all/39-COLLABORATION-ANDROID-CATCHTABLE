package com.android.catchtable.presentation.store.model

import com.android.catchtable.domain.model.store.StoreDetailModel
import java.util.Locale

fun StoreDetailModel.toUiModel() = StoreUiModel(
    storeId = storeId,
    name = name,
    category = category,
    region = region,
    intro = intro,
    rating = rating,
    reviewCount = reviewCount,
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
