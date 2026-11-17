package com.android.catchtable.domain.repository

import com.android.catchtable.domain.model.vote.VoteDetailResponseModel

interface VoteRepository {
    suspend fun getVoteDetail(voteId: Long): Result<VoteDetailResponseModel>
}
