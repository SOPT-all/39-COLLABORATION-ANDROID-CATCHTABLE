package com.android.catchtable.domain.repository

import com.android.catchtable.domain.model.vote.VoteDetailResponseModel
import com.android.catchtable.domain.model.vote.VoteRole

interface VoteRepository {
    suspend fun getVoteDetail(voteId: Long, role: VoteRole): VoteDetailResponseModel
}
