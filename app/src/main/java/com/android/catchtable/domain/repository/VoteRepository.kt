package com.android.catchtable.domain.repository

import com.android.catchtable.domain.model.vote.SubmitBallotRequestModel
import com.android.catchtable.domain.model.vote.CreateVoteModel
import com.android.catchtable.domain.model.vote.CreateVoteRequestModel
import com.android.catchtable.domain.model.vote.ActiveVoteModel
import com.android.catchtable.domain.model.vote.VoteDetailModel

interface VoteRepository {
    suspend fun postCreateVote(request: CreateVoteRequestModel): Result<CreateVoteModel>

    suspend fun getVoteDetail(voteId: Long?): Result<VoteDetailModel>

    suspend fun postSubmitBallot(voteId: Long, request: SubmitBallotRequestModel): Result<Unit>

    suspend fun getActiveVote(): Result<ActiveVoteModel?>
}
