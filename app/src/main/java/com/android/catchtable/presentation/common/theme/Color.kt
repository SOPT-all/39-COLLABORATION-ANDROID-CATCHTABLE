package com.android.catchtable.presentation.common.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

//Primary
val OrangeBase = Color(0xFFFF3D00)
val OrangeBaseAlpha05 = OrangeBase.copy(alpha = 0.05f)
val OrangeBaseClicked = Color(0xFFDA3400)

//Gray Scales
val Black = Color(0xFF000000)
val BlackAlpha70 = Black.copy(alpha = 0.7f)
val BlackAlpha40 = Black.copy(alpha = 0.4f)
val BlackAlpha04 = Black.copy(alpha = 0.04f)
val Gray900 = Color(0xFF1C1C1C)
val Gray800 = Color(0xFF2B2B2B)
val Gray700 = Color(0xFF444444)
val Gray600 = Color(0xFF575757)
val Gray500 = Color(0xFF757575)
val Gray400 = Color(0xFFA5A5A5)
val Gray300 = Color(0xFFD6D6D6)
val Gray200 = Color(0xFF38E8E8)
val Gray100 = Color(0xFFF5F5F5)
val Gray050 = Color(0xFFFAFAFA)
val CoolGray600 = Color(0xFF5B7282)
val CoolGray200 = Color(0xFFF2F4F5)
val White = Color(0xFFFFFFFF)

//Accent
val Red = Color(0xFFFF1300)
val Blue = Color(0xFF0082F9)
val Yellow = Color(0xFFFEC300)
val Pink = Color(0xFFFADCD9)
val PinkGradient = Brush.verticalGradient(
    colors = listOf(
        Color(0xFFFF538D),
        Color(0xFFF9604F)
    )
)
val PinkGradientLight = Brush.verticalGradient(
    colors = listOf(
        Color(0xFFFFFFFF),
        Color(0xFFFEF6F8)
    )
)
val BannerGradient = Brush.verticalGradient(
    colors = listOf(
        Color(0xFF323232).copy(alpha = 0f),
        Color(0xFF382B27).copy(alpha = 0.7f)
    )
)

//Subway Color
val Line9 = Color(0xFFBDB092)
val LineSBD = Color(0xFFD31145) //신분당