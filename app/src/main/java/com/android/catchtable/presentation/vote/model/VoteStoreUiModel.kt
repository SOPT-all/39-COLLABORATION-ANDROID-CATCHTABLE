package com.android.catchtable.presentation.vote.model

data class VoteStoreUiModel(
    val id: Long,
    val thumbnailUrl: String?,
    val name: String,
    val rating: String,
    val reviewCount: String,
)
