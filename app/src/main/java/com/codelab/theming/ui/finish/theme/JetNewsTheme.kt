package com.codelab.theming.ui.finish.theme

import DarkColors
import JetnewsShape
import LightColors
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable

@Composable
fun JetNewsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable ()-> Unit
){
    androidx.compose.material.MaterialTheme(
        content = content,
        colors = if (darkTheme) DarkColors else LightColors,
        typography = JetnewsTypography,
        shapes = JetnewsShape
    )
}