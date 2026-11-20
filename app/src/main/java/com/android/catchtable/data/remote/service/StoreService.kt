package com.android.catchtable.data.remote.service

import com.android.catchtable.data.remote.dto.base.BaseResponse
import com.android.catchtable.data.remote.dto.store.response.StoreDetailResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface StoreService {
    @GET("api/v1/stores/{storeId}")
    suspend fun getStoreDetail(
        @Path("storeId") storeId: Long,
    ): BaseResponse<StoreDetailResponseDto>
}