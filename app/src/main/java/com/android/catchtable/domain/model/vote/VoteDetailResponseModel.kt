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

data class VoteViewerResponseModel(
    val userId: Long,
    val isHost: Boolean,
    val hasVoted: Boolean,
    val selectedCandidateId: Long?,
    val displayName: String,
    val defaultNickname: String
)

data class VoteCandidateResponseModel(
    val candidateId: Long,
    val displayOrder: Int,
    val voteCount: Int,
    val voters: List<VoteVoterResponseModel>,
    val store: VoteStoreResponseModel
)

data class VoteVoterResponseModel(val displayName: String)

