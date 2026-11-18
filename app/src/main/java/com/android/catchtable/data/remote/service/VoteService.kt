package com.android.catchtable.data.remote.service

import com.android.catchtable.data.remote.dto.base.BaseResponse
import com.android.catchtable.data.remote.dto.vote.response.VoteDetailResponseDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface VoteService {

    @GET("/api/v1/votes/{voteId}")
    suspend fun getVoteDetail(
        @Header("X-User-Id") xUserId: Int,
        @Path("voteId") voteId: Long
    ): BaseResponse<VoteDetailResponseDto>

}

