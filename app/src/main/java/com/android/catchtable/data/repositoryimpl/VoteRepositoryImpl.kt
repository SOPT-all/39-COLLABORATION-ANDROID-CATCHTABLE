package com.android.catchtable.data.repositoryimpl

import com.android.catchtable.data.remote.dto.vote.DummyVoteDetailResponse
import com.android.catchtable.domain.model.vote.VoteDetailResponseModel
import com.android.catchtable.domain.repository.VoteRepository
import com.android.catchtable.presentation.vote.model.VoteRole
import javax.inject.Inject

class VoteRepositoryImpl @Inject constructor() : VoteRepository {
    override suspend fun getVoteDetail(voteId: Long, role: VoteRole): VoteDetailResponseModel =
        //API 연동 후 수정 예정
        requireNotNull(DummyVoteDetailResponse.create(voteId, role).data)
}
