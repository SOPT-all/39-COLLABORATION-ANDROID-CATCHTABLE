package com.android.catchtable.domain.repository

import com.android.catchtable.domain.model.store.StoreDetailModel

interface StoreRepository {
    suspend fun getStoreDetail(storeId: Long): Result<StoreDetailModel>
}