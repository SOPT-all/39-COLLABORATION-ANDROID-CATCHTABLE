package com.android.catchtable.domain.model.vote

data class CreateVoteModel(
    val voteId: Long,
    val status: VoteStatus,
    val hostUserId: Long,
    val candidates: List<CreateVoteCandidateModel>,
    val createdAt: String
)

data class CreateVoteCandidateModel(
    val candidateId: Long,
    val storeId: Long,
    val displayOrder: Int
)