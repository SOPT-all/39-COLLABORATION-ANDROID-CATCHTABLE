package com.android.catchtable.presentation.common.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.android.catchtable.R.font.*

val Pretendard = FontFamily(
    Font(pretendard_bold, FontWeight.Bold),
    Font(pretendard_semibold, FontWeight.SemiBold),
    Font(pretendard_medium, FontWeight.Medium),
    Font(pretendard_regular, FontWeight.Normal),
)

@Immutable
data class CatchTableTypography(
    val displayB20: TextStyle,
    val displayB18: TextStyle,
    val displaySB18: TextStyle,
    val displayRG18: TextStyle,
    val h1B16: TextStyle,
    val h1SB16: TextStyle,
    val h1MD16: TextStyle,
    val h3B14: TextStyle,
    val h3SB14: TextStyle,
    val h3MD14: TextStyle,
    val h3RG14: TextStyle,
    val bodyB12: TextStyle,
    val bodySB12: TextStyle,
    val bodyMD12: TextStyle,
    val bodyRG12: TextStyle,
    val captionB10: TextStyle,
    val captionSB10: TextStyle,
    val captionMD10: TextStyle,
    val captionB8: TextStyle,
)

val catchTableTypography: CatchTableTypography
    @Composable
    get() {
        val baseStyle = TextStyle(fontFamily = Pretendard, color = Black)

        return CatchTableTypography(
            displayB20 = baseStyle.copy(fontWeight = FontWeight.Bold, fontSize = 20.sp, lineHeight = 1.5.em),
            displayB18 = baseStyle.copy(fontWeight = FontWeight.Bold, fontSize = 18.sp, lineHeight = 1.5.em),
            displaySB18 = baseStyle.copy(fontWeight = FontWeight.SemiBold, fontSize = 18.sp, lineHeight = 1.5.em),
            displayRG18 = baseStyle.copy(fontWeight = FontWeight.Normal, fontSize = 18.sp, lineHeight = 1.5.em),
            h1B16 = baseStyle.copy(fontWeight = FontWeight.Bold, fontSize = 16.sp, lineHeight = 1.5.em),
            h1SB16 = baseStyle.copy(fontWeight = FontWeight.SemiBold, fontSize = 16.sp, lineHeight = 1.5.em),
            h1MD16 = baseStyle.copy(fontWeight = FontWeight.Medium, fontSize = 16.sp, lineHeight = 1.5.em),
            h3B14 = baseStyle.copy(fontWeight = FontWeight.Bold, fontSize = 14.sp, lineHeight = 20.sp),
            h3SB14 = baseStyle.copy(fontWeight = FontWeight.SemiBold, fontSize = 14.sp, lineHeight = 20.sp),
            h3MD14 = baseStyle.copy(fontWeight = FontWeight.Medium, fontSize = 14.sp, lineHeight = 20.sp),
            h3RG14 = baseStyle.copy(fontWeight = FontWeight.Normal, fontSize = 14.sp, lineHeight = 20.sp),
            bodyB12 = baseStyle.copy(fontWeight = FontWeight.Bold, fontSize = 12.sp, lineHeight = 16.sp),
            bodySB12 = baseStyle.copy(fontWeight = FontWeight.SemiBold, fontSize = 12.sp, lineHeight = 16.sp),
            bodyMD12 = baseStyle.copy(fontWeight = FontWeight.Medium, fontSize = 12.sp, lineHeight = 16.sp),
            bodyRG12 = baseStyle.copy(fontWeight = FontWeight.Normal, fontSize = 12.sp, lineHeight = 16.sp),
            captionB10 = baseStyle.copy(fontWeight = FontWeight.Bold, fontSize = 10.sp, lineHeight = 14.sp),
            captionSB10 = baseStyle.copy(fontWeight = FontWeight.SemiBold, fontSize = 10.sp, lineHeight = 14.sp),
            captionMD10 = baseStyle.copy(fontWeight = FontWeight.Medium, fontSize = 10.sp, lineHeight = 14.sp),
            captionB8 = baseStyle.copy(fontWeight = FontWeight.Bold, fontSize = 8.sp, lineHeight = 10.sp),
        )
    }
