package com.android.catchtable.domain.model.vote

data class ActiveVoteModel(
    val voteId: Long,
    val candidateCount: Int,
    val createdAt: String,
)