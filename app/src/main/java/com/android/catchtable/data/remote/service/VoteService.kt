package com.android.catchtable.data.remote.service

import com.android.catchtable.data.remote.dto.base.BaseResponse
import com.android.catchtable.data.remote.dto.vote.request.CreateVoteRequestDto
import com.android.catchtable.data.remote.dto.vote.response.CreateVoteResponseDto
import com.android.catchtable.data.remote.dto.vote.response.VoteDetailResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import com.android.catchtable.data.remote.dto.vote.response.ActiveVoteResponseDto

interface VoteService {

    @GET("/api/v1/votes/{voteId}")
    suspend fun getVoteDetail(
        @Header("X-User-Id") xUserId: Int,
        @Path("voteId") voteId: Long
    ): BaseResponse<VoteDetailResponseDto>

    @POST("/api/v1/votes")
    suspend fun postCreateVote(
        @Header("X-User-Id") xUserId: Int,
        @Body request: CreateVoteRequestDto
    ): BaseResponse<CreateVoteResponseDto>
    @GET("api/v1/users/me/votes/active")
    suspend fun getActiveVote(): BaseResponse<ActiveVoteResponseDto>
}
