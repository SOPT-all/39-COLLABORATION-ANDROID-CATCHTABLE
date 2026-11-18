package com.android.catchtable.domain.repository

import com.android.catchtable.domain.model.vote.VoteDetailModel

interface VoteRepository {
    suspend fun getVoteDetail(xUserId: Int, voteId: Long?): Result<VoteDetailModel>

}
