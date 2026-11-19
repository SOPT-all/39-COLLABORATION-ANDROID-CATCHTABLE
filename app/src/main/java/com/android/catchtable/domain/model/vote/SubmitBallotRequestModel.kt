package com.android.catchtable.domain.model.vote

data class SubmitBallotRequestModel(
    val candidateId: Long,
    val nickname: String,
)
