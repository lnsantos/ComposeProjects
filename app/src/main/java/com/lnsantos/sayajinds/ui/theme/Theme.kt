package com.lnsantos.sayajinds.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = SayajinColors.Purple200,
    primaryVariant = SayajinColors.Purple700,
    secondary = SayajinColors.Teal200
)

private val LightColorPalette = lightColors(
    primary = SayajinColors.Purple500,
    primaryVariant = SayajinColors.Purple700,
    secondary = SayajinColors.Teal200
)

@Composable
fun SayajinDSTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}