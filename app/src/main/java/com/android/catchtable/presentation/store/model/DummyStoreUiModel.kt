package com.android.catchtable.presentation.store.model

val dummyStoreUiModel = StoreUiModel(
    storeId = 1,
    name = "하이디라오 서초점",
    category = "중식",
    region = "강남",
    intro = "중국에서 시작해 전 세계에서 사랑받는 훠궈 브랜드, 하이디라오 훠궈",
    rating = "4.7",
    reviewCount = "6,204",
    station = StoreStationUiModel(
        name = "신논현역",
        lines = listOf("9", "신분당"),
        distanceMeters = 221,
    ),
    priceRange = "점심 저녁 동일가 3 - 5만원",
    businessHours = "매일 10:00 - 07:00",
    phone = "0507-1350-8260",
    imageUrls = listOf("", ""),
    menus = listOf(
        StoreMenuUiModel(
            id = 1,
            storeId = 1,
            imgUrl = null,
            name = "소기름훠궈",
            price = "9,000",
            isPriceFrom = true,
        ),
        StoreMenuUiModel(
            id = 2,
            storeId = 1,
            imgUrl = null,
            name = "청유마라훠궈",
            price = "9,000",
            isPriceFrom = true,
        ),
        StoreMenuUiModel(
            id = 3,
            storeId = 1,
            imgUrl = null,
            name = "토마토탕훠궈",
            price = "9,000",
            isPriceFrom = true,
        ),
    ),
    aiSummary = StoreAiSummaryUiModel(
        title = "중국 본토의 맛 그대로, 차원이 다른 훠궈 전문점",
        lines = listOf(
            "다양한 재료를 취향대로 골라 먹을 수 있는 중국 본토 스타일의 훠궈 전문점이에요.",
            "소스바에서 입맛에 맞게 소스를 만들어 즐길 수 있으며, 달콤한 케이크도 맛볼 수 있어요.",
            "자리에서 화려한 면 퍼포먼스를 감상할 수 있고, 생일이나 기념일에 방문하기 좋은 곳이에요.",
        ),
    ),
    amenities = listOf("주류·콜키지"),
)