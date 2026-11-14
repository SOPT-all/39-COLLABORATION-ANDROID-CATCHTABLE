package com.android.catchtable.domain.model.vote

data class VoteRepresentativeMenuResponseModel(
    val menuId: Long,
    val name: String,
    val price: Int,
    val isPriceFrom: Boolean,
    val imageUrl: String,
    val displayOrder: Int
)
