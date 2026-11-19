package com.android.catchtable.data.repositoryimpl

import com.android.catchtable.data.mapper.toDto
import com.android.catchtable.data.remote.dto.vote.DummyVoteDetailResponse
import com.android.catchtable.data.remote.service.VoteService
import com.android.catchtable.domain.model.vote.VoteDetailModel
import com.android.catchtable.domain.repository.VoteRepository
import com.android.catchtable.data.util.suspendRunCatching
import com.android.catchtable.domain.model.vote.SubmitBallotRequestModel
import com.android.catchtable.domain.model.vote.VoteStatus
import javax.inject.Inject

class VoteRepositoryImpl @Inject constructor(
    private val voteService: VoteService,
) : VoteRepository {
    override suspend fun getVoteDetail(voteId: Long?): Result<VoteDetailModel> =
        suspendRunCatching {
            if (voteId == null) {
                // Store 진입: voteId가 없으므로 기존 더미 데이터를 사용
                requireNotNull(DummyVoteDetailResponse.create(1L, "CREATE").data)
            } else {
                // Home 진입: voteId를 사용해 API 연동 예정. 연동 전까지는 기존 더미 데이터를 사용
                requireNotNull(DummyVoteDetailResponse.create(voteId, "OPEN").data)
            }
        }

    override suspend fun postSubmitBallot(voteId: Long, request: SubmitBallotRequestModel): Result<Unit> =
        suspendRunCatching {
            voteService.postSubmitBallot(
                voteId = voteId,
                request = request.toDto(),
            )
        }
}
