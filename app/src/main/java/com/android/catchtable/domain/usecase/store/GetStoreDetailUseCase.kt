package com.android.catchtable.domain.usecase.store

import com.android.catchtable.domain.model.store.StoreDetailModel
import com.android.catchtable.domain.repository.StoreRepository
import javax.inject.Inject

class GetStoreDetailUseCase @Inject constructor(
    private val storeRepository: StoreRepository,
) {
    suspend operator fun invoke(storeId: Long): Result<StoreDetailModel> =
        storeRepository.getStoreDetail(storeId)
}