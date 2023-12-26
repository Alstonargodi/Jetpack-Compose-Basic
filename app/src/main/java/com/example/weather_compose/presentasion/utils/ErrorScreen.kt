package com.example.weather_compose.presentasion.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather_compose.R

@Composable
fun ErrorScreen(
    message : String,
    onTryAgain: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_error_24),
            contentDescription = "error",
            modifier = Modifier
                .height(200.dp)
                .width(200.dp)
        )
        Text(
            text = "${message}",
            style = TextStyle(color = Color.White),
            fontSize = 15.sp,
            modifier = Modifier.padding(2.dp),
            textAlign = TextAlign.Center
        )
        Button(
            onClick = { onTryAgain() }
        ) {
            Text(text = "Coba Lagi")
        }
    }
}
