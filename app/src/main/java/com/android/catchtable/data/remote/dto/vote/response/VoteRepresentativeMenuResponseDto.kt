package com.android.catchtable.data.remote.dto.vote.response

import kotlinx.serialization.Serializable

@Serializable
data class VoteRepresentativeMenuResponseDto(
    val menuId: Long,
    val name: String,
    val price: Int,
    val isPriceFrom: Boolean,
    val imageUrl: String,
    val displayOrder: Int
)
