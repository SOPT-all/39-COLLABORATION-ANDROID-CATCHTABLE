package com.android.catchtable.data.mapper

import com.android.catchtable.data.remote.dto.vote.request.CreateVoteRequestDto
import com.android.catchtable.data.remote.dto.vote.response.CreateVoteCandidateResponseDto
import com.android.catchtable.data.remote.dto.vote.response.CreateVoteResponseDto
import com.android.catchtable.domain.model.vote.CreateVoteCandidateModel
import com.android.catchtable.domain.model.vote.CreateVoteModel
import com.android.catchtable.domain.model.vote.CreateVoteRequestModel
import com.android.catchtable.domain.model.vote.VoteStatus

fun CreateVoteRequestModel.toDto() = CreateVoteRequestDto(
    storeIds = storeIds
)

fun CreateVoteResponseDto.toModel() = CreateVoteModel(
    voteId = voteId,
    status = VoteStatus.find(status),
    hostUserId = hostUserId,
    candidates = candidates.map { it.toModel() },
    createdAt = createdAt
)

private fun CreateVoteCandidateResponseDto.toModel() = CreateVoteCandidateModel(
    candidateId = candidateId,
    storeId = storeId,
    displayOrder = displayOrder
)
