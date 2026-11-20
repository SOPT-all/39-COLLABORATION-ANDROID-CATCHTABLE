package com.android.catchtable.domain.usecase.vote

import com.android.catchtable.domain.model.vote.ActiveVoteModel
import com.android.catchtable.domain.repository.VoteRepository
import javax.inject.Inject

class GetActiveVoteUseCase @Inject constructor(
    private val voteRepository: VoteRepository,
) {
    suspend operator fun invoke(): Result<ActiveVoteModel?> =
        voteRepository.getActiveVote()
}
