package com.android.catchtable.data.repositoryimpl

import com.android.catchtable.data.mapper.toModel
import com.android.catchtable.data.remote.dto.vote.DummyVoteDetailResponse
import com.android.catchtable.data.remote.service.VoteService
import com.android.catchtable.data.util.getDataOrThrow
import com.android.catchtable.domain.model.vote.VoteDetailModel
import com.android.catchtable.domain.repository.VoteRepository
import com.android.catchtable.data.util.suspendRunCatching
import com.android.catchtable.domain.model.vote.VoteStatus
import javax.inject.Inject

class VoteRepositoryImpl @Inject constructor(
    private val voteService: VoteService,
) : VoteRepository {
    override suspend fun getVoteDetail(xUserId: Int, voteId: Long?): Result<VoteDetailModel> =
        suspendRunCatching {
            if (voteId == null) {
                // Store 진입: voteId가 없으므로 기존 더미 데이터를 사용
                requireNotNull(DummyVoteDetailResponse.create(1L, "CREATE").data)
            } else {
                // Home 진입: voteId를 사용해 API 연결
                voteService.getVoteDetail(xUserId,voteId).getDataOrThrow().toModel()
            }
        }
}
