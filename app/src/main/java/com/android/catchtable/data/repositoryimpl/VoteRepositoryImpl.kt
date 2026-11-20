package com.android.catchtable.data.repositoryimpl

import com.android.catchtable.data.mapper.toDto
import com.android.catchtable.data.mapper.toModel
import com.android.catchtable.data.remote.dto.vote.DummyVoteDetailResponse
import com.android.catchtable.data.remote.service.VoteService
import com.android.catchtable.data.util.getDataOrThrow
import com.android.catchtable.data.util.suspendRunCatching
import com.android.catchtable.domain.model.vote.ActiveVoteModel
import com.android.catchtable.domain.model.vote.CreateVoteModel
import com.android.catchtable.domain.model.vote.CreateVoteRequestModel
import com.android.catchtable.domain.model.vote.SubmitBallotRequestModel
import com.android.catchtable.domain.model.vote.VoteDetailModel
import com.android.catchtable.domain.repository.VoteRepository
import javax.inject.Inject

class VoteRepositoryImpl @Inject constructor(
    private val voteService: VoteService,
) : VoteRepository {
    override suspend fun getVoteDetail(voteId: Long?): Result<VoteDetailModel> =
        suspendRunCatching {
            if (voteId == null) {
                requireNotNull(DummyVoteDetailResponse.create(1L, "CREATE").data)
            } else {
                voteService.getVoteDetail(voteId).getDataOrThrow().toModel()
            }
        }

    override suspend fun postCreateVote(request: CreateVoteRequestModel): Result<CreateVoteModel> =
        suspendRunCatching {
            voteService.postCreateVote(request.toDto()).getDataOrThrow().toModel()
        }

    override suspend fun getActiveVote(): Result<ActiveVoteModel?> = suspendRunCatching {
        voteService.getActiveVote().getDataOrThrow().vote?.toModel()
    }


    override suspend fun postSubmitBallot(
        voteId: Long,
        request: SubmitBallotRequestModel
    ): Result<Unit> =
        suspendRunCatching {
            voteService.postSubmitBallot(
                voteId = voteId,
                request = request.toDto(),
            )
        }
}
