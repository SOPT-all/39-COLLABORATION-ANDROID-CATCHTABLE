package com.android.catchtable.data.mapper

import com.android.catchtable.data.remote.dto.store.response.StoreAiSummaryResponseDto
import com.android.catchtable.data.remote.dto.store.response.StoreAmenityResponseDto
import com.android.catchtable.data.remote.dto.store.response.StoreDetailResponseDto
import com.android.catchtable.data.remote.dto.store.response.StoreRepresentativeMenuResponseDto
import com.android.catchtable.data.remote.dto.store.response.StoreStationResponseDto
import com.android.catchtable.domain.model.store.StoreAiSummaryModel
import com.android.catchtable.domain.model.store.StoreAmenityModel
import com.android.catchtable.domain.model.store.StoreDetailModel
import com.android.catchtable.domain.model.store.StoreRepresentativeMenuModel
import com.android.catchtable.domain.model.store.StoreStationModel

fun StoreDetailResponseDto.toModel() = StoreDetailModel(
    storeId = storeId,
    name = name,
    category = category,
    region = region,
    intro = intro,
    rating = rating,
    reviewCount = reviewCount,
    station = station.toModel(),
    priceRange = priceRange,
    businessHours = businessHours,
    phone = phone,
    imageUrls = imageUrls,
    representativeMenus = representativeMenus.sortedBy { it.displayOrder }.map { it.toModel() },
    aiSummary = aiSummary?.toModel(),
    amenities = amenities.map { it.toModel() },
)

private fun StoreStationResponseDto.toModel() = StoreStationModel(
    name = name,
    lines = lines,
    distanceMeters = distanceMeters,
)

private fun StoreRepresentativeMenuResponseDto.toModel() = StoreRepresentativeMenuModel(
    menuId = menuId,
    name = name,
    price = price,
    isPriceFrom = isPriceFrom,
    imageUrl = imageUrl,
    displayOrder = displayOrder,
)

private fun StoreAiSummaryResponseDto.toModel() = StoreAiSummaryModel(
    title = title,
    lines = lines,
)

private fun StoreAmenityResponseDto.toModel() = StoreAmenityModel(
    category = category,
    content = content,
)