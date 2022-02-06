package com.adrianlazaro8.rickmorty.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.adrianlazaro8.rickmorty.R

val Nunito = FontFamily(
    Font(R.font.nunito_black, FontWeight.Black, FontStyle.Normal),
    Font(R.font.nunito_blackitalic, FontWeight.Black, FontStyle.Italic),
    Font(R.font.nunito_bold, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.nunito_bolditalic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.nunito_extrabold, FontWeight.ExtraBold, FontStyle.Normal),
    Font(R.font.nunito_extrabolditalic, FontWeight.ExtraBold, FontStyle.Italic),
    Font(R.font.nunito_extralightitalic, FontWeight.ExtraLight, FontStyle.Italic),
    Font(R.font.nunito_extralight, FontWeight.ExtraLight, FontStyle.Normal),
    Font(R.font.nunito_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.nunito_light, FontWeight.Light, FontStyle.Normal),
    Font(R.font.nunito_lightitalic, FontWeight.Black, FontStyle.Italic),
    Font(R.font.nunito_medium, FontWeight.Medium, FontStyle.Normal),
    Font(R.font.nunito_mediumitalic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.nunito_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.nunito_semibold, FontWeight.SemiBold, FontStyle.Normal),
    Font(R.font.nunito_semibolditalic, FontWeight.SemiBold, FontStyle.Italic)
)

// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = Nunito,
    body1 = TextStyle(
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)