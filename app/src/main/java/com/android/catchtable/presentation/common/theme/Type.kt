package com.android.catchtable.presentation.common.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    val captionB8: TextStyle

){
    val groupedTypography: List<Pair<String, List<Pair<String, TextStyle>>>>
        get() = listOf(
            "Display" to listOf(
                "displayB20" to displayB20,
                "displayB18" to displayB18,
                "displaySB18" to displaySB18,
                "displayRG18" to displayRG18
            ),
            "H1" to listOf(
                "h1B16" to h1B16,
                "h1SB16" to h1SB16,
                "h1MD16" to h1MD16
            ),
            "H3" to listOf(
                "h3B14" to h3B14,
                "h3SB14" to h3SB14,
                "h3MD14" to h3MD14,
                "h3RG14" to h3RG14
            ),
            "Body" to listOf(
                "bodyB12" to bodyB12,
                "bodySB12" to bodySB12,
                "bodyMD12" to bodyMD12,
                "bodyRG12" to bodyRG12
            ),
            "Caption" to listOf(
                "captionB10" to captionB10,
                "captionSB10" to captionSB10,
                "captionMD10" to captionMD10,
                "captionB8" to captionB8
            )
        )
}

val defaultCatchTableTypography: CatchTableTypography
    @Composable
    get() {
        val baseStyle = TextStyle(fontFamily = Pretendard, color = defaultCatchTableColors.black)

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

@Preview(showBackground = true)
@Composable
fun CatchTableTypographyPreview(){
    CatchTableTheme{
        val typographyGroups = CatchTableTheme.typography.groupedTypography

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            typographyGroups.forEach { (_, styles) ->
                styles.forEach { (styleName, style) ->
                    Text(
                        text = styleName,
                        style = style,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}