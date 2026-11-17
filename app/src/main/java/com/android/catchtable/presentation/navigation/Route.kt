package com.android.catchtable.presentation.navigation

import kotlinx.serialization.Serializable

interface Route {
    @Serializable
    data class Store(val storeId: Long) : Route

    @Serializable
    data class Vote(val voteId: Long?) : Route

    @Serializable
    data object VoteComplete : Route
}
