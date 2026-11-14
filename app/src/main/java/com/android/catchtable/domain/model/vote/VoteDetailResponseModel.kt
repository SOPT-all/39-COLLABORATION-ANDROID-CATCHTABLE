package com.android.catchtable.domain.model.vote

import com.android.catchtable.presentation.vote.model.VoteStatus

data class VoteDetailResponseModel(
    val voteId: Long,
    val status: VoteStatus,
    val participantCount: Int,
    val candidates: List<VoteCandidateResponseModel>,
    val viewer: VoteViewerResponseModel,
    val createdAt: String,
    val closedAt: String?
)

