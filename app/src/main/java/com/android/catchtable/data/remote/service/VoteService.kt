package com.android.catchtable.data.remote.service

import com.android.catchtable.data.remote.dto.base.BaseResponse
import com.android.catchtable.data.remote.dto.vote.request.SubmitBallotRequestDto
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface VoteService {
    @POST("api/v1/votes/{voteId}/ballots/me")
    suspend fun postSubmitBallot(
        @Path("voteId") voteId: Long,
        @Body request: SubmitBallotRequestDto,
    ): BaseResponse<Unit>
}
