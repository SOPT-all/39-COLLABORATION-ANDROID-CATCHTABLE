package com.android.catchtable.data.remote.dto.vote

import com.android.catchtable.data.remote.dto.base.BaseResponse
import com.android.catchtable.data.remote.dto.vote.response.VoteAiSummaryResponseDto
import com.android.catchtable.data.remote.dto.vote.response.VoteAmenityResponseDto
import com.android.catchtable.data.remote.dto.vote.response.VoteCandidateResponseDto
import com.android.catchtable.data.remote.dto.vote.response.VoteDetailResponseDto
import com.android.catchtable.data.remote.dto.vote.response.VoteDetailStoreResponseDto
import com.android.catchtable.data.remote.dto.vote.response.VoteRepresentativeMenuResponseDto
import com.android.catchtable.data.remote.dto.vote.response.VoteStationResponseDto
import com.android.catchtable.data.remote.dto.vote.response.VoteViewerResponseDto
import com.android.catchtable.data.remote.dto.vote.response.VoteVoterResponseDto
import com.android.catchtable.presentation.vote.model.VoteRole

internal object DummyVoteDetailResponse {
    fun create(voteId: Long, role: VoteRole) = BaseResponse(
        code = 200,
        message = "투표 상세 조회 성공",
        data = VoteDetailResponseDto(
            voteId = voteId,
            status = "OPEN",
            participantCount = 2,
            candidates = listOf(
                createCandidate(
                    candidateId = 21L,
                    storeId = 1L,
                    displayOrder = 1,
                    name = "하이디라오 서초점",
                    rating = 4.7f,
                    reviewCount = 6204,
                    stationName = "신논현역",
                    distanceMeters = 221,
                    priceRange = "점심 저녁 동일가 3 - 5만원",
                    imageUrl = "https://ugc-images.catchtable.co.kr/catchtable/shopinfo/sQ6OMNo_LTW0nT53hnpp1jA/m/fa6bea1a059747e39581799d71970bca",
                    menuName = "소기름훠궈",
                    menuImageUrl = "https://ugc-images.catchtable.co.kr/shop/manager/images/970f5beef34446de95eb7757c2e0a2d5",
                    menuPrice = 9000
                ),
                createCandidate(
                    candidateId = 22L,
                    storeId = 2L,
                    displayOrder = 2,
                    name = "소보키 강남점",
                    rating = 4.5f,
                    reviewCount = 644,
                    stationName = "신논현역",
                    distanceMeters = 396,
                    priceRange = "점심 1 - 2만원 / 저녁 1 - 3만원",
                    imageUrl = "https://ugc-images.catchtable.co.kr/shop/manager/images/567e2166ccdb49aab7b0fc19adc8aeec",
                    menuName = "2인 SET",
                    menuImageUrl = "https://ugc-images.catchtable.co.kr/shop/manager/images/648a10d47da446f1af339243db711aeb",
                    menuPrice = 55000
                )
            ),
            viewer = VoteViewerResponseDto(
                userId = 2L,
                isHost = role == VoteRole.HOST,
                hasVoted = role == VoteRole.GUEST,
                selectedCandidateId = if (role == VoteRole.GUEST) 21L else null,
                displayName = "테스트1",
                defaultNickname = "테스트1"
            ),
            createdAt = "2026-11-06T19:30:00+09:00",
            closedAt = null
        )
    )

    private fun createCandidate(
        candidateId: Long,
        storeId: Long,
        displayOrder: Int,
        name: String,
        rating: Float,
        reviewCount: Int,
        stationName: String,
        distanceMeters: Int,
        priceRange: String,
        imageUrl: String,
        menuName: String,
        menuImageUrl: String,
        menuPrice: Int
    ) = VoteCandidateResponseDto(
        candidateId = candidateId,
        displayOrder = displayOrder,
        voteCount = if (candidateId == 21L) 2 else 0,
        voters = if (candidateId == 21L) listOf(VoteVoterResponseDto("테스트2")) else emptyList(),
        store = VoteDetailStoreResponseDto(
            storeId = storeId,
            name = name,
            rating = rating,
            reviewCount = reviewCount,
            imageUrls = listOf(imageUrl),
            station = VoteStationResponseDto(stationName, listOf("9", "신분당"), distanceMeters),
            aiSummary = VoteAiSummaryResponseDto("모임에 추천하는 맛집", listOf("좋은 분위기", "맛있는 메뉴")),
            priceRange = priceRange,
            representativeMenus = listOf(
                VoteRepresentativeMenuResponseDto(
                    menuId = candidateId + 100,
                    name = menuName,
                    price = menuPrice,
                    isPriceFrom = true,
                    imageUrl = menuImageUrl,
                    displayOrder = 1
                )
            ),
            amenities = listOf(VoteAmenityResponseDto("PARKING", "건물 내 주차 가능"))
        )
    )
}
