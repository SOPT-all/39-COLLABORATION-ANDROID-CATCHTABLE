package com.android.catchtable.data.mapper

import com.android.catchtable.data.remote.dto.vote.request.SubmitBallotRequestDto
import com.android.catchtable.domain.model.vote.SubmitBallotRequestModel

fun SubmitBallotRequestModel.toDto() = SubmitBallotRequestDto(
    candidateId = candidateId,
    nickname = nickname
)
