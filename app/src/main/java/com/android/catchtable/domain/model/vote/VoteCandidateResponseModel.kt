package com.android.catchtable.domain.model.vote

data class VoteCandidateResponseModel(
    val candidateId: Long,
    val displayOrder: Int,
    val voteCount: Int,
    val voters: List<VoteVoterResponseModel>,
    val store: VoteDetailStoreResponseModel
)
