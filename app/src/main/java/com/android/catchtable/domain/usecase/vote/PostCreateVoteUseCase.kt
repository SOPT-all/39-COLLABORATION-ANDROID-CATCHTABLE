package com.android.catchtable.domain.usecase.vote

import com.android.catchtable.domain.model.vote.CreateVoteModel
import com.android.catchtable.domain.model.vote.CreateVoteRequestModel
import com.android.catchtable.domain.repository.VoteRepository
import javax.inject.Inject

class PostCreateVoteUseCase @Inject constructor(
    private val voteRepository: VoteRepository
) {
    suspend operator fun invoke(request: CreateVoteRequestModel): Result<CreateVoteModel> =
        voteRepository.postCreateVote(request)
}
