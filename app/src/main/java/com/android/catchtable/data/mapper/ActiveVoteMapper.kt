package com.android.catchtable.data.mapper

import com.android.catchtable.data.remote.dto.vote.response.ActiveVoteInfoResponseDto
import com.android.catchtable.domain.model.vote.ActiveVoteModel

fun ActiveVoteInfoResponseDto.toModel() = ActiveVoteModel(
    voteId = voteId,
    candidateCount = candidateCount,
    createdAt = createdAt,
)
