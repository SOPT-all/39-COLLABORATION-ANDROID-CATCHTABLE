package com.android.catchtable.domain.usecase.vote

import com.android.catchtable.domain.model.vote.VoteDetailModel
import com.android.catchtable.domain.repository.VoteRepository
import javax.inject.Inject

class GetVoteDetailUseCase @Inject constructor(
    private val voteRepository: VoteRepository
) {
    suspend operator fun invoke(voteId: Long): Result<VoteDetailModel> =
        voteRepository.getVoteDetail(voteId)
}
