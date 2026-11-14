package com.android.catchtable.presentation.vote.model

enum class VoteStatus {
    CREATE,
    OPEN;
    companion object {
        fun find(rawValue: String): VoteStatus = entries.firstOrNull { it.name == rawValue }
            ?: throw IllegalArgumentException("Unknown vote status: $rawValue")
    }
}
