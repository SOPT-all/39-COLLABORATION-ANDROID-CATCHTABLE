package com.android.catchtable.data.mapper

import com.android.catchtable.data.remote.dto.vote.response.VoteAiSummaryResponseDto
import com.android.catchtable.data.remote.dto.vote.response.VoteAmenityResponseDto
import com.android.catchtable.data.remote.dto.vote.response.VoteCandidateResponseDto
import com.android.catchtable.data.remote.dto.vote.response.VoteDetailResponseDto
import com.android.catchtable.data.remote.dto.vote.response.VoteStoreResponseDto
import com.android.catchtable.data.remote.dto.vote.response.VoteRepresentativeMenuResponseDto
import com.android.catchtable.data.remote.dto.vote.response.VoteStationResponseDto
import com.android.catchtable.data.remote.dto.vote.response.VoteViewerResponseDto
import com.android.catchtable.domain.model.vote.VoteAiSummaryModel
import com.android.catchtable.domain.model.vote.VoteAmenityModel
import com.android.catchtable.domain.model.vote.VoteCandidateModel
import com.android.catchtable.domain.model.vote.VoteDetailModel
import com.android.catchtable.domain.model.vote.VoteStoreModel
import com.android.catchtable.domain.model.vote.VoteRepresentativeMenuModel
import com.android.catchtable.domain.model.vote.VoteStationModel
import com.android.catchtable.domain.model.vote.VoteStatus
import com.android.catchtable.domain.model.vote.VoteViewerModel
import com.android.catchtable.domain.model.vote.VoteVoterModel

fun VoteDetailResponseDto.toModel() = VoteDetailModel(
    voteId = voteId,
    status = VoteStatus.find(status),
    participantCount = participantCount,
    candidates = candidates.map { it.toModel() },
    viewer = viewer.toModel(),
    createdAt = createdAt,
    closedAt = closedAt
)

private fun VoteCandidateResponseDto.toModel() = VoteCandidateModel(
    candidateId = candidateId,
    displayOrder = displayOrder,
    voteCount = voteCount,
    voters = voters.map { VoteVoterModel(displayName = it.displayName) },
    store = store.toModel()
)

private fun VoteStoreResponseDto.toModel() = VoteStoreModel(
    storeId = storeId,
    name = name,
    rating = rating,
    reviewCount = reviewCount,
    imageUrls = imageUrls,
    station = station.toModel(),
    aiSummary = aiSummary?.toModel(),
    priceRange = priceRange,
    representativeMenus = representativeMenus.map { it.toModel() },
    amenities = amenities.map { it.toModel() }
)

private fun VoteStationResponseDto.toModel() = VoteStationModel(
    name = name,
    lines = lines,
    distanceMeters = distanceMeters
)

private fun VoteAiSummaryResponseDto.toModel() = VoteAiSummaryModel(
    title = title,
    lines = lines
)

private fun VoteRepresentativeMenuResponseDto.toModel() = VoteRepresentativeMenuModel(
    menuId = menuId,
    name = name,
    price = price,
    isPriceFrom = isPriceFrom,
    imageUrl = imageUrl,
    displayOrder = displayOrder
)

private fun VoteAmenityResponseDto.toModel() = VoteAmenityModel(
    category = category,
    content = content
)

private fun VoteViewerResponseDto.toModel() = VoteViewerModel(
    userId = userId,
    isHost = isHost,
    hasVoted = hasVoted,
    selectedCandidateId = selectedCandidateId,
    displayName = displayName,
    defaultNickname = defaultNickname
)
