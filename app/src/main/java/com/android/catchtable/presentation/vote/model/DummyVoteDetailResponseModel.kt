package com.android.catchtable.presentation.vote.model

import com.android.catchtable.domain.model.vote.VoteAiSummaryResponseModel
import com.android.catchtable.domain.model.vote.VoteAmenityResponseModel
import com.android.catchtable.domain.model.vote.VoteCandidateResponseModel
import com.android.catchtable.domain.model.vote.VoteDetailResponseModel
import com.android.catchtable.domain.model.vote.VoteDetailStoreResponseModel
import com.android.catchtable.domain.model.vote.VoteRepresentativeMenuResponseModel
import com.android.catchtable.domain.model.vote.VoteStationResponseModel
import com.android.catchtable.domain.model.vote.VoteViewerResponseModel
import com.android.catchtable.domain.model.vote.VoteVoterResponseModel

fun createDummyVoteDetailResponseModel() = VoteDetailResponseModel(
    voteId = 10L,
    status = VoteStatus.OPEN,
    participantCount = 2,
    candidates = listOf(createFirstCandidate(), createSecondCandidate()),
    viewer = VoteViewerResponseModel(
        userId = 2L,
        isHost = false,
        hasVoted = true,
        selectedCandidateId = FIRST_CANDIDATE_ID,
        displayName = "테스트1",
        defaultNickname = "테스트1"
    ),
    createdAt = "2026-11-06T19:30:00+09:00",
    closedAt = null
)

private fun createFirstCandidate() = VoteCandidateResponseModel(
    candidateId = FIRST_CANDIDATE_ID,
    displayOrder = 1,
    voteCount = 2,
    voters = listOf(VoteVoterResponseModel(displayName = "테스트2")),
    store = VoteDetailStoreResponseModel(
        storeId = 1L,
        name = "하이디라오 서초점",
        rating = 4.7f,
        reviewCount = 6204,
        imageUrls = listOf(
            "https://ugc-images.catchtable.co.kr/catchtable/shopinfo/sQ6OMNo_LTW0nT53hnpp1jA/m/fa6bea1a059747e39581799d71970bca"
        ),
        station = VoteStationResponseModel(
            name = "신논현역",
            lines = listOf("9", "신분당"),
            distanceMeters = 221
        ),
        aiSummary = VoteAiSummaryResponseModel(
            title = "중국 본토의 맛 그대로, 차원이 다른 훠궈 전문점",
            lines = listOf(
                "소스바에서 취향에 맞는 소스를 만들 수 있어요.",
                "모임이나 기념일에 방문하기 좋아요."
            )
        ),
        priceRange = "점심 저녁 동일가 3 - 5만원",
        representativeMenus = listOf(
            VoteRepresentativeMenuResponseModel(
                menuId = 1L,
                name = "소기름훠궈",
                price = 9000,
                isPriceFrom = true,
                imageUrl = "https://ugc-images.catchtable.co.kr/shop/manager/images/970f5beef34446de95eb7757c2e0a2d5",
                displayOrder = 1
            ),
            VoteRepresentativeMenuResponseModel(
                menuId = 2L,
                name = "청유마라훠궈",
                price = 9000,
                isPriceFrom = true,
                imageUrl = "https://ugc-images.catchtable.co.kr/shop/manager/images/637851d2a986486ca1d5efdb6314f941",
                displayOrder = 2
            )
        ),
        amenities = listOf(
            VoteAmenityResponseModel(
                category = "LIQUOR_CORKAGE",
                content = "- 와인: 병당 5만원\n- 위스키: 병당 5만원\n- 사케: 병당 5만원"
            )
        )
    )
)

private fun createSecondCandidate() = VoteCandidateResponseModel(
    candidateId = 22L,
    displayOrder = 2,
    voteCount = 0,
    voters = emptyList(),
    store = VoteDetailStoreResponseModel(
        storeId = 2L,
        name = "소보키 강남점",
        rating = 4.5f,
        reviewCount = 644,
        imageUrls = listOf(
            "https://ugc-images.catchtable.co.kr/shop/manager/images/567e2166ccdb49aab7b0fc19adc8aeec"
        ),
        station = VoteStationResponseModel(
            name = "신논현역",
            lines = listOf("9", "신분당"),
            distanceMeters = 396
        ),
        aiSummary = VoteAiSummaryResponseModel(
            title = "트렌디한 퓨전 한식과 전통주가 어우러진 주점",
            lines = listOf(
                "다채로운 전통주와 퓨전 한식을 즐길 수 있어요.",
                "프라이빗 룸이 있어 모임에 좋아요."
            )
        ),
        priceRange = "점심 1 - 2만원 / 저녁 1 - 3만원",
        representativeMenus = listOf(
            VoteRepresentativeMenuResponseModel(
                menuId = 5L,
                name = "2인 SET",
                price = 55000,
                isPriceFrom = false,
                imageUrl = "https://ugc-images.catchtable.co.kr/shop/manager/images/648a10d47da446f1af339243db711aeb",
                displayOrder = 1
            ),
            VoteRepresentativeMenuResponseModel(
                menuId = 6L,
                name = "3인 SET",
                price = 69000,
                isPriceFrom = false,
                imageUrl = "https://ugc-images.catchtable.co.kr/shop/manager/images/af7ceda48de64adfbec2afb324071872",
                displayOrder = 2
            )
        ),
        amenities = listOf(
            VoteAmenityResponseModel(
                category = "LIQUOR_CORKAGE",
                content = "- 와인 외 가능: 병당 5만원"
            )
        )
    )
)

private const val FIRST_CANDIDATE_ID = 21L
