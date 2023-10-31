package com.shashi.shiva.codechallengevirtusa.ui.theme

import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val LightColorPalette = lightColors(
    primary = DarkGray,
    primaryVariant = Gray,
    secondary = LightPurple,
    onPrimary = Color.Black,
    onSecondary = White,

//     Other default colors to override
    background = Color.White,
    surface = Color.White,

    onBackground = Color.Black,
    onSurface = Color.Black,
)


@Composable
fun CodeChallengeVirtusaTheme(content: @Composable() () -> Unit) {

    androidx.compose.material.MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}