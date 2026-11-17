package com.android.catchtable.data.repositoryimpl

import com.android.catchtable.data.remote.dto.vote.DummyVoteDetailResponse
import com.android.catchtable.domain.model.vote.VoteDetailModel
import com.android.catchtable.domain.repository.VoteRepository
import com.android.catchtable.data.util.suspendRunCatching
import javax.inject.Inject

class VoteRepositoryImpl @Inject constructor() : VoteRepository {
    override suspend fun getVoteDetail(voteId: Long?): Result<VoteDetailModel> =
        suspendRunCatching {
            if (voteId == null) {
                // Store 진입: voteId가 없으므로 기존 더미 데이터를 사용
                requireNotNull(DummyVoteDetailResponse.create(1L).data)
            } else {
                // Home 진입: voteId를 사용해 API 연동 예정. 연동 전까지는 기존 더미 데이터를 사용
                requireNotNull(DummyVoteDetailResponse.create(voteId).data)
            }
        }
}
