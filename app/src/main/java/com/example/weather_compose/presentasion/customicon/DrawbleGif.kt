package com.example.weather_compose.presentasion.customicon

import android.graphics.drawable.Drawable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Canvas
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DrawableGif(){
    Canvas(
        modifier = Modifier.fillMaxSize()
    ){
        val canvasWidth = size.width
        val canvasHeight = size.height

        drawLine(
            start = Offset(x=canvasWidth,y=0f),
            end = Offset(x=0f,y=canvasHeight),
            color = Color.White,
            strokeWidth = 5F
        )
    }
}

@Preview
@Composable
fun DrawblePreview(){
    DrawableGif()
}