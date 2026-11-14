package com.android.catchtable.data.mapper

import com.android.catchtable.data.remote.dto.vote.response.VoteAiSummaryResponseDto
import com.android.catchtable.data.remote.dto.vote.response.VoteAmenityResponseDto
import com.android.catchtable.data.remote.dto.vote.response.VoteCandidateResponseDto
import com.android.catchtable.data.remote.dto.vote.response.VoteDetailResponseDto
import com.android.catchtable.data.remote.dto.vote.response.VoteDetailStoreResponseDto
import com.android.catchtable.data.remote.dto.vote.response.VoteRepresentativeMenuResponseDto
import com.android.catchtable.data.remote.dto.vote.response.VoteStationResponseDto
import com.android.catchtable.data.remote.dto.vote.response.VoteViewerResponseDto
import com.android.catchtable.domain.model.vote.VoteAiSummaryResponseModel
import com.android.catchtable.domain.model.vote.VoteAmenityResponseModel
import com.android.catchtable.domain.model.vote.VoteCandidateResponseModel
import com.android.catchtable.domain.model.vote.VoteDetailResponseModel
import com.android.catchtable.domain.model.vote.VoteDetailStoreResponseModel
import com.android.catchtable.domain.model.vote.VoteRepresentativeMenuResponseModel
import com.android.catchtable.domain.model.vote.VoteStationResponseModel
import com.android.catchtable.presentation.vote.model.VoteStatus
import com.android.catchtable.domain.model.vote.VoteViewerResponseModel
import com.android.catchtable.domain.model.vote.VoteVoterResponseModel

fun VoteDetailResponseDto.toResponseModel() = VoteDetailResponseModel(
    voteId = voteId,
    status = VoteStatus.find(status),
    participantCount = participantCount,
    candidates = candidates.map { it.toResponseModel() },
    viewer = viewer.toResponseModel(),
    createdAt = createdAt,
    closedAt = closedAt
)

private fun VoteCandidateResponseDto.toResponseModel() = VoteCandidateResponseModel(
    candidateId = candidateId,
    displayOrder = displayOrder,
    voteCount = voteCount,
    voters = voters.map { VoteVoterResponseModel(displayName = it.displayName) },
    store = store.toResponseModel()
)

private fun VoteDetailStoreResponseDto.toResponseModel() = VoteDetailStoreResponseModel(
    storeId = storeId,
    name = name,
    rating = rating,
    reviewCount = reviewCount,
    imageUrls = imageUrls,
    station = station.toResponseModel(),
    aiSummary = aiSummary.toResponseModel(),
    priceRange = priceRange,
    representativeMenus = representativeMenus.map { it.toResponseModel() },
    amenities = amenities.map { it.toResponseModel() }
)

private fun VoteStationResponseDto.toResponseModel() = VoteStationResponseModel(
    name = name,
    lines = lines,
    distanceMeters = distanceMeters
)

private fun VoteAiSummaryResponseDto.toResponseModel() = VoteAiSummaryResponseModel(
    title = title,
    lines = lines
)

private fun VoteRepresentativeMenuResponseDto.toResponseModel() = VoteRepresentativeMenuResponseModel(
    menuId = menuId,
    name = name,
    price = price,
    isPriceFrom = isPriceFrom,
    imageUrl = imageUrl,
    displayOrder = displayOrder
)

private fun VoteAmenityResponseDto.toResponseModel() = VoteAmenityResponseModel(
    category = category,
    content = content
)

private fun VoteViewerResponseDto.toResponseModel() = VoteViewerResponseModel(
    userId = userId,
    isHost = isHost,
    hasVoted = hasVoted,
    selectedCandidateId = selectedCandidateId,
    displayName = displayName,
    defaultNickname = defaultNickname
)
