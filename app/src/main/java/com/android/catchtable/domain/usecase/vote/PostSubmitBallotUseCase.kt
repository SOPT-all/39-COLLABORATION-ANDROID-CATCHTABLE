package com.android.catchtable.domain.usecase.vote

import com.android.catchtable.domain.model.vote.SubmitBallotRequestModel
import com.android.catchtable.domain.repository.VoteRepository
import javax.inject.Inject

class PostSubmitBallotUseCase @Inject constructor(
    private val voteRepository: VoteRepository
) {
    suspend operator fun invoke(voteId: Long, request: SubmitBallotRequestModel): Result<Unit> =
        voteRepository.postSubmitBallot(voteId, request)
}
