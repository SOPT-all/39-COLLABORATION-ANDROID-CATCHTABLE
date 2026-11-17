package com.android.catchtable.presentation.navigation

import kotlinx.serialization.Serializable

interface MainTabRoute : Route {
    @Serializable
    data object Home : MainTabRoute

    @Serializable
    data object Saved : MainTabRoute

    @Serializable
    data object Nearby : MainTabRoute

    @Serializable
    data object Dining : MainTabRoute

    @Serializable
    data object My : MainTabRoute
}
