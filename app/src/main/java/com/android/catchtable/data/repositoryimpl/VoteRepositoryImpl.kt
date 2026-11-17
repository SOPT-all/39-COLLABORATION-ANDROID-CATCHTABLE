package com.android.catchtable.data.repositoryimpl

import com.android.catchtable.data.remote.dto.vote.DummyVoteDetailResponse
import com.android.catchtable.domain.model.vote.VoteDetailModel
import com.android.catchtable.domain.repository.VoteRepository
import com.android.catchtable.data.util.suspendRunCatching
import javax.inject.Inject

class VoteRepositoryImpl @Inject constructor() : VoteRepository {
    override suspend fun getVoteDetail(voteId: Long): Result<VoteDetailModel> =
        suspendRunCatching {
            // API 연동 후 수정 예정
            requireNotNull(DummyVoteDetailResponse.create(voteId).data)
        }
}
