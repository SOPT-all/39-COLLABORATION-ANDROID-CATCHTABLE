package com.android.catchtable.presentation.together.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.android.catchtable.presentation.common.theme.CatchTableTheme

data class VoteTagStyle(
    val text: String,
    val backgroundColor: Color,
    val borderColor: Color,
    val textColor: Color,
    val iconColor: Color ?= null
)

enum class VoteTagType(
    val style: @Composable () -> VoteTagStyle,
) {
    RESERVED(
        style = {
            VoteTagStyle(
                text = "예약하기",
                backgroundColor = CatchTableTheme.colors.orangeBaseAlpha05,
                borderColor = CatchTableTheme.colors.orangeBase,
                textColor = CatchTableTheme.colors.orangeBase,
                iconColor = CatchTableTheme.colors.orangeBase
            )
        }
    ),

    VIEW_ALL(
        style = {
            VoteTagStyle(
                text = "전체보기",
                backgroundColor = Color.Unspecified,
                borderColor = CatchTableTheme.colors.gray300,
                textColor = CatchTableTheme.colors.gray900,
                iconColor = CatchTableTheme.colors.gray600
            )
        }
    ),

    VOTE_ENDED(
        style = {
            VoteTagStyle(
                text = "투표종료",
                backgroundColor = CatchTableTheme.colors.orangeBase,
                borderColor = Color.Transparent,
                textColor = CatchTableTheme.colors.white,
                iconColor = null
            )
        }
    )
}
