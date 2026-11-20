package com.android.catchtable.domain.repository

import com.android.catchtable.domain.model.vote.ActiveVoteModel
import com.android.catchtable.domain.model.vote.VoteDetailModel

interface VoteRepository {
    suspend fun getVoteDetail(voteId: Long?): Result<VoteDetailModel>
    suspend fun getActiveVote(): Result<ActiveVoteModel?>
}
