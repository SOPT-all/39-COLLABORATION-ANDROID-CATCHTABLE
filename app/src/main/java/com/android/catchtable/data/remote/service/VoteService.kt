package com.android.catchtable.data.remote.service

import com.android.catchtable.data.remote.dto.base.BaseResponse
import com.android.catchtable.data.remote.dto.vote.response.ActiveVoteResponseDto
import retrofit2.http.GET

interface VoteService {
    @GET("api/v1/users/me/votes/active")
    suspend fun getActiveVote(): BaseResponse<ActiveVoteResponseDto>
}