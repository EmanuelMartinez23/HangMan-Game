package com.uam.horcado.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.uam.horcado.R
// atma
private val light = Font(R.font.atma_light, FontWeight.W300)
private val regular = Font(R.font.atma_regular, FontWeight.W400)
private val medium = Font(R.font.atma_medium, FontWeight.W500)
private val semibold = Font(R.font.atma_semibold, FontWeight.W600)
private val bold = Font(R.font.atma_bold, FontWeight.W700)

//indie flower
private val regularIndieFlower = Font(R.font.indieflower_regular, FontWeight.W400)

private val boldIndieFlower = Font(R.font.indieflower_regular, FontWeight.W900)

// creamos las familias
private val indieFlower = FontFamily(fonts = listOf(regularIndieFlower))
private val atmaFontFamily = FontFamily(fonts = listOf(light, regular, medium, semibold,bold))

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,


    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)