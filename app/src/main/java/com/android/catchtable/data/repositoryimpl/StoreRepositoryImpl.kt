package com.android.catchtable.data.repositoryimpl

import com.android.catchtable.data.mapper.toModel
import com.android.catchtable.data.remote.service.StoreService
import com.android.catchtable.data.util.getDataOrThrow
import com.android.catchtable.data.util.suspendRunCatching
import com.android.catchtable.domain.model.store.StoreDetailModel
import com.android.catchtable.domain.repository.StoreRepository
import javax.inject.Inject

class StoreRepositoryImpl @Inject constructor(
    private val storeService: StoreService,
) : StoreRepository {
    override suspend fun getStoreDetail(storeId: Long): Result<StoreDetailModel> =
        suspendRunCatching {
            storeService.getStoreDetail(storeId).getDataOrThrow().toModel()
        }
}