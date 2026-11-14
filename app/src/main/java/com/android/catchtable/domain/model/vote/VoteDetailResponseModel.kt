package com.android.catchtable.domain.model.vote

data class VoteDetailResponseModel(
    val voteId: Long,
    val status: VoteStatus,
    val participantCount: Int,
    val candidates: List<VoteCandidateResponseModel>,
    val viewer: VoteViewerResponseModel,
    val createdAt: String,
    val closedAt: String?
)

