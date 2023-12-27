package com.example.weather_compose.presentasion.home.detail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.weather_compose.remote.entity.WeatherDetailResponse

@Composable
fun ShowDetailWeather(
    detail : WeatherDetailResponse
){
    Column {
        FirstCard(detail = detail)
    }
}


@Composable
fun FirstCard(
    detail : WeatherDetailResponse,
){
    val icon = "http://openweathermap.org/img/w/${detail.weather[0].icon}.png"
    Row {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(icon)
                .build(),
            modifier = Modifier
                .width(100.dp)
                .height(100.dp),
            contentDescription = "Profile Image"
        )
        Column(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(
                fontSize = 20.sp,
                text = detail.name
            )
        }
    }
}



