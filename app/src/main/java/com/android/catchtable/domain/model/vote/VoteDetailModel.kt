package com.android.catchtable.domain.model.vote

data class VoteDetailModel(
    val voteId: Long,
    val status: VoteStatus,
    val participantCount: Int,
    val candidates: List<VoteCandidateModel>,
    val viewer: VoteViewerModel,
    val createdAt: String,
    val closedAt: String?
)

data class VoteViewerModel(
    val userId: Long,
    val isHost: Boolean,
    val hasVoted: Boolean,
    val selectedCandidateId: Long?,
    val displayName: String?,
    val defaultNickname: String
)

data class VoteCandidateModel(
    val candidateId: Long,
    val displayOrder: Int,
    val voteCount: Int,
    val voters: List<VoteVoterModel>,
    val store: VoteStoreModel
)

data class VoteVoterModel(val displayName: String)

