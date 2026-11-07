package com.android.catchtable.presentation.common.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//Primary
private val OrangeBase = Color(0xFFFF3D00)
private val OrangeBaseAlpha05 = OrangeBase.copy(alpha = 0.05f)
private val OrangeBaseClicked = Color(0xFFDA3400)

//Gray Scales
private val Black = Color(0xFF000000)
private val BlackAlpha70 = Black.copy(alpha = 0.7f)
private val BlackAlpha40 = Black.copy(alpha = 0.4f)
private val BlackAlpha04 = Black.copy(alpha = 0.04f)
private val Gray900 = Color(0xFF1C1C1C)
private val Gray800 = Color(0xFF2B2B2B)
private val Gray700 = Color(0xFF444444)
private val Gray600 = Color(0xFF575757)
private val Gray500 = Color(0xFF757575)
private val Gray400 = Color(0xFFA5A5A5)
private val Gray300 = Color(0xFFD6D6D6)
private val Gray200 = Color(0xFFE8E8E8)
private val Gray100 = Color(0xFFF5F5F5)
private val Gray050 = Color(0xFFFAFAFA)
private val CoolGray600 = Color(0xFF5B7282)
private val CoolGray200 = Color(0xFFF2F4F5)
private val White = Color(0xFFFFFFFF)

//Accent
private val Red = Color(0xFFFF1300)
private val Blue = Color(0xFF0082F9)
private val Yellow = Color(0xFFFEC300)
private val Pink = Color(0xFFFADCD9)
private val PinkGradient = Brush.verticalGradient(
    colors = listOf(
        Color(0xFFFF537D),
        Color(0xFFF9604F)
    )
)
private val PinkGradientLight = Brush.verticalGradient(
    colors = listOf(
        Color(0xFFFFFFFF),
        Color(0xFFFEF6F8)
    )
)
private val BannerGradient = Brush.verticalGradient(
    colors = listOf(
        Color(0xFF323232).copy(alpha = 0f),
        Color(0xFF382B27).copy(alpha = 0.7f)
    )
)

//Subway Color
private val Line9 = Color(0xFFBDB092)
private val LineSBD = Color(0xFFD31145) //신분당

@Immutable
data class CatchTableColors(
    val orangeBase: Color,
    val orangeBaseAlpha05: Color,
    val orangeBaseClicked: Color,
    val black: Color,
    val blackAlpha70: Color,
    val blackAlpha40: Color,
    val blackAlpha04: Color,
    val gray900: Color,
    val gray800: Color,
    val gray700: Color,
    val gray600: Color,
    val gray500: Color,
    val gray400: Color,
    val gray300: Color,
    val gray200: Color,
    val gray100: Color,
    val gray050: Color,
    val coolGray600: Color,
    val coolGray200: Color,
    val white: Color,
    val red: Color,
    val blue: Color,
    val yellow: Color,
    val pink: Color,
    val pinkGradient: Brush,
    val pinkGradientLight: Brush,
    val bannerGradient: Brush,
    val line9: Color,
    val lineSBD: Color
){
    val allColors: List<Color>
        get() = listOf(
            orangeBase, orangeBaseAlpha05, orangeBaseClicked, black, blackAlpha70, blackAlpha40, blackAlpha04,
            gray900, gray800, gray700, gray600, gray500, gray400, gray300, gray200, gray100, gray050,
            coolGray600, coolGray200, white, red, blue, yellow, pink, line9, lineSBD
        )

    val allGradients: List<Brush>
        get() = listOf(pinkGradient, pinkGradientLight, bannerGradient)
}
val defaultCatchTableColors = CatchTableColors(
    orangeBase = OrangeBase,
    orangeBaseAlpha05 = OrangeBaseAlpha05,
    orangeBaseClicked = OrangeBaseClicked,
    black = Black,
    blackAlpha70 = BlackAlpha70,
    blackAlpha40 = BlackAlpha40,
    blackAlpha04 = BlackAlpha04,
    gray900 = Gray900,
    gray800 = Gray800,
    gray700 = Gray700,
    gray600 = Gray600,
    gray500 = Gray500,
    gray400 = Gray400,
    gray300 = Gray300,
    gray200 = Gray200,
    gray100 = Gray100,
    gray050 = Gray050,
    coolGray600 = CoolGray600,
    coolGray200 = CoolGray200,
    white = White,
    red = Red,
    blue = Blue,
    yellow = Yellow,
    pink = Pink,
    pinkGradient = PinkGradient,
    pinkGradientLight = PinkGradientLight,
    bannerGradient = BannerGradient,
    line9 = Line9,
    lineSBD = LineSBD
)

@Preview(showBackground = true)
@Composable
fun CatchTableColorPreview() {
    CatchTableTheme {
        val colors = CatchTableTheme.colors.allColors
        val gradients = CatchTableTheme.colors.allGradients

        FlowRow(
            modifier = Modifier.padding(16.dp),
            maxItemsInEachRow = 6,
        ) {
            colors.forEach { c ->
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(c)
                )
            }
            gradients.forEach { b ->
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(b)
                )
            }
        }
    }
}
