package com.android.catchtable.domain.repository

import com.android.catchtable.domain.model.vote.SubmitBallotRequestModel
import com.android.catchtable.domain.model.vote.VoteDetailModel

interface VoteRepository {
    suspend fun getVoteDetail(voteId: Long?): Result<VoteDetailModel>

    suspend fun postSubmitBallot(voteId: Long, request: SubmitBallotRequestModel): Result<Unit>
}
