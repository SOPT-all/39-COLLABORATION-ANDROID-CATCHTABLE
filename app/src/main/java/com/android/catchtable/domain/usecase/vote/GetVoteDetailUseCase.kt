package com.android.catchtable.domain.usecase.vote

import com.android.catchtable.domain.model.vote.VoteDetailResponseModel
import com.android.catchtable.presentation.vote.model.VoteRole
import com.android.catchtable.domain.repository.VoteRepository
import javax.inject.Inject

class GetVoteDetailUseCase @Inject constructor(
    private val voteRepository: VoteRepository
) {
    suspend operator fun invoke(
        voteId: Long,
        role: VoteRole
    ): VoteDetailResponseModel =
        voteRepository.getVoteDetail(voteId, role)
}
