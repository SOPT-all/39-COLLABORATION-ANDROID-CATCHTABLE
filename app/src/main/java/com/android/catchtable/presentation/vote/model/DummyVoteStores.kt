package com.android.catchtable.presentation.vote.model

object DummyVoteStores {

    val dummyVoteStores = listOf(
        VoteStoreModel(
            storeId = 1L,
            name = "하이디라오 서초점",
            region = "강남",
            intro = "중국에서 시작해 전 세계에서 사랑받는 훠궈 브랜드, 하이디라오 훠궈",
            rating = 4.7f,
            reviewCount = "6204",
            station = StationModel(
                name = "신논현역",
                lines = listOf("9", "신분당"),
                distanceMeters = 221
            ),
            priceRange = "점심 저녁 동일가 3 - 5만원",
            imageUrls = "https://ugc-images.catchtable.co.kr/catchtable/shopinfo/sQ6OMNo_LTW0nT53hnpp1jA/m/fa6bea1a059747e39581799d71970bca",
            representativeMenu = listOf(
                RepresentativeMenusModel(
                    menuId = 1L,
                    name = "소기름훠궈",
                    price = 9000,
                    isPriceFrom = true,
                    imageUrl = "https://ugc-images.catchtable.co.kr/shop/manager/images/970f5beef34446de95eb7757c2e0a2d5",
                    displayOrder = 1
                ),
                RepresentativeMenusModel(
                    menuId = 2L,
                    name = "청유마라훠궈",
                    price = 9000,
                    isPriceFrom = true,
                    imageUrl = "https://ugc-images.catchtable.co.kr/shop/manager/images/637851d2a986486ca1d5efdb6314f941",
                    displayOrder = 2
                ),
                RepresentativeMenusModel(
                    menuId = 3L,
                    name = "토마토탕훠궈",
                    price = 9000,
                    isPriceFrom = true,
                    imageUrl = "https://ugc-images.catchtable.co.kr/shop/manager/images/a865280c5b3b40d0aa9be20d0bf9a494",
                    displayOrder = 3
                )
            ),
            aiSummary = AiSummaryModel(
                title = "중국 본토의 맛 그대로, 차원이 다른 훠궈 전문점",
                lines = "다양한 재료를 취향대로 골라 먹을 수 있는 중국 본토 스타일의 훠궈 전문점이에요.\n소스바에서 입맛에 맞게 소스를 만들어 즐길 수 있으며, 달콤한 케이크도 맛볼 수 있어요.\n자리에서 화려한 면 퍼포먼스를 감상할 수 있고, 생일이나 기념일에 방문하기 좋은 곳이에요."
            ),
            amenities = AmenitiesModel(
                category = "LIQUOR_CORKAGE",
                content = "- 와인: 병당 5만원\n- 위스키: 병당 5만원\n- 사케: 병당 5만원"
            )
        ),
        VoteStoreModel(
            storeId = 2L,
            name = "소보키 강남점",
            region = "강남",
            intro = "다양한 전통주와 맛있는 퓨전 한식 안주를 즐길 수 있는 강남역 분위기 좋은 한식주점",
            rating = 4.5f,
            reviewCount = "644",
            station = StationModel(
                name = "신논현역",
                lines = listOf("9", "신분당"),
                distanceMeters = 396
            ),
            priceRange = "점심 1 - 2만원 / 저녁 1 - 3만원",
            imageUrls = "https://ugc-images.catchtable.co.kr/shop/manager/images/567e2166ccdb49aab7b0fc19adc8aeec",
            representativeMenu = listOf(
                RepresentativeMenusModel(
                    menuId = 5L,
                    name = "2인 SET",
                    price = 55000,
                    isPriceFrom = false,
                    imageUrl = "https://ugc-images.catchtable.co.kr/shop/manager/images/648a10d47da446f1af339243db711aeb",
                    displayOrder = 1
                ),
                RepresentativeMenusModel(
                    menuId = 6L,
                    name = "3인 SET",
                    price = 69000,
                    isPriceFrom = false,
                    imageUrl = "https://ugc-images.catchtable.co.kr/shop/manager/images/af7ceda48de64adfbec2afb324071872",
                    displayOrder = 2
                )
            ),
            aiSummary = AiSummaryModel(
                title = "트렌디한 퓨전 한식과 전통주가 어우러진 주점",
                lines = "강남역 인근에 위치한 곳으로, 다채로운 전통주와 트렌디한 퓨전 한식을 함께 맛볼 수 있는 주점이에요.\n특유의 맛이 매력적인 '차돌 마라 전골'과 '치즈 베이컨 감자채전', 다양한 파스타도 인기가 많아요.\n프라이빗한 룸과 넓은 홀이 마련되어 있어 청첩장 모임이나 단체 모임 장소로 방문하는 것을 추천드려요."
            ),
            amenities = AmenitiesModel(
                category = "LIQUOR_CORKAGE",
                content = "- 와인 외 가능: 병당 5만원"
            )
        )
    )

    val dummyVoteStore = dummyVoteStores[0]
}