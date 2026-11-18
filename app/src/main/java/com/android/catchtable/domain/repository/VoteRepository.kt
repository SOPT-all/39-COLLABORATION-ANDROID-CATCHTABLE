package com.android.catchtable.domain.repository

import com.android.catchtable.domain.model.vote.CreateVoteModel
import com.android.catchtable.domain.model.vote.CreateVoteRequestModel
import com.android.catchtable.domain.model.vote.VoteDetailModel

interface VoteRepository {
    suspend fun getVoteDetail(xUserId: Int, voteId: Long?): Result<VoteDetailModel>
    suspend fun postCreateVote(xUserId: Int, request: CreateVoteRequestModel): Result<CreateVoteModel>
}
