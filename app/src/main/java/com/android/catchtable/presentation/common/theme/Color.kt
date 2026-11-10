package com.android.catchtable.presentation.common.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//Primary
private val orangeBase = Color(0xFFFF3D00)
private val orangeBaseAlpha05 = orangeBase.copy(alpha = 0.05f)
private val orangeBaseClicked = Color(0xFFDA3400)

//Gray Scales
private val black = Color(0xFF000000)
private val blackAlpha70 = black.copy(alpha = 0.7f)
private val blackAlpha40 = black.copy(alpha = 0.4f)
private val blackAlpha04 = black.copy(alpha = 0.04f)
private val gray900 = Color(0xFF1C1C1C)
private val gray800 = Color(0xFF2B2B2B)
private val gray700 = Color(0xFF444444)
private val gray600 = Color(0xFF575757)
private val gray500 = Color(0xFF757575)
private val gray400 = Color(0xFFA5A5A5)
private val gray300 = Color(0xFFD6D6D6)
private val gray200 = Color(0xFFE8E8E8)
private val gray100 = Color(0xFFF5F5F5)
private val gray50 = Color(0xFFFAFAFA)
private val coolGray600 = Color(0xFF5B7282)
private val coolGray200 = Color(0xFFF2F4F5)
private val white = Color(0xFFFFFFFF)

//Accent
private val red = Color(0xFFFF1300)
private val blue = Color(0xFF0082F9)
private val yellow = Color(0xFFFEC300)
private val pink = Color(0xFFFADCD9)

//Subway Color
private val line9 = Color(0xFFBDB092)
private val lineSBD = Color(0xFFD31145) //신분당

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
    val gray50: Color,
    val coolGray600: Color,
    val coolGray200: Color,
    val white: Color,
    val red: Color,
    val blue: Color,
    val yellow: Color,
    val pink: Color,
    val line9: Color,
    val lineSBD: Color
){
    val allColors: List<Color>
        get() = listOf(
            orangeBase,
            orangeBaseAlpha05,
            orangeBaseClicked,
            black,
            blackAlpha70,
            blackAlpha40,
            blackAlpha04,
            gray900,
            gray800,
            gray700,
            gray600,
            gray500,
            gray400,
            gray300,
            gray200,
            gray100,
            gray50,
            coolGray600,
            coolGray200,
            white,
            red,
            blue,
            yellow,
            pink,
            line9,
            lineSBD
        )
}
val defaultCatchTableColors = CatchTableColors(
    orangeBase = orangeBase,
    orangeBaseAlpha05 = orangeBaseAlpha05,
    orangeBaseClicked = orangeBaseClicked,
    black = black,
    blackAlpha70 = blackAlpha70,
    blackAlpha40 = blackAlpha40,
    blackAlpha04 = blackAlpha04,
    gray900 = gray900,
    gray800 = gray800,
    gray700 = gray700,
    gray600 = gray600,
    gray500 = gray500,
    gray400 = gray400,
    gray300 = gray300,
    gray200 = gray200,
    gray100 = gray100,
    gray50 = gray50,
    coolGray600 = coolGray600,
    coolGray200 = coolGray200,
    white = white,
    red = red,
    blue = blue,
    yellow = yellow,
    pink = pink,
    line9 = line9,
    lineSBD = lineSBD
)

@Preview(showBackground = true)
@Composable
private fun CatchTableColorPreview() {
    CatchTableTheme {
        val colors = CatchTableTheme.colors.allColors

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
        }
    }
}
