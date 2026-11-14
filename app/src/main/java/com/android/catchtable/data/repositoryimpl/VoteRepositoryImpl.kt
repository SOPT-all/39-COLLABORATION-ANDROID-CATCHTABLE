package com.android.catchtable.data.repositoryimpl

import com.android.catchtable.data.remote.dto.vote.DummyVoteDetailResponse
import com.android.catchtable.data.mapper.toResponseModel
import com.android.catchtable.domain.model.vote.VoteDetailResponseModel
import com.android.catchtable.domain.model.vote.VoteRole
import com.android.catchtable.domain.repository.VoteRepository
import javax.inject.Inject

class VoteRepositoryImpl @Inject constructor() : VoteRepository {
    override suspend fun getVoteDetail(voteId: Long, role: VoteRole): VoteDetailResponseModel =
        requireNotNull(DummyVoteDetailResponse.create(voteId, role).data).toResponseModel()
}
