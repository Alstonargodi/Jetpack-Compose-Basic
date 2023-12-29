package com.example.weather_compose.presentasion.home.detail

import android.graphics.drawable.BitmapDrawable
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.weather_compose.remote.entity.ForecastItem
import com.example.weather_compose.remote.entity.WeatherDetailResponse
import com.example.weather_compose.remote.entity.WeatherForecastResponse
import kotlin.math.round

@Composable
fun ShowDetailWeather(
    detail : WeatherDetailResponse,
    forecastResponse: WeatherForecastResponse
){
    Column(
        modifier = Modifier
            .background(Color.Black)
            .padding(20.dp)
    ) {
        FirstCard(detail = detail)
        SecondCard(detail = detail)
        ListForecast(forecastResponse = forecastResponse )
    }
}

@Composable
fun FirstCard(
    detail : WeatherDetailResponse,
){
    val icon = "https://openweathermap.org/img/w/${detail.weather[0].icon}.png"
    val temp = round(detail.main.temp).toInt()

    Row {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(icon)
                .allowHardware(false)
                .build(),
            modifier = Modifier
                .width(100.dp)
                .height(100.dp),
            contentDescription = "Profile Image"
        )
        Column(
        ) {
            Text(
                fontSize = 20.sp,
                text = detail.name
            )
            Text(
                fontSize = 20.sp,
                text = detail.weather[0].description
            )
            Text(
                fontSize = 20.sp,
                text = temp.toString()
            )
        }
    }
}

@Composable
fun SecondCard(
    detail : WeatherDetailResponse
){
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                text = "Clouds"
            )
            Text(
                fontSize = 20.sp,
                text = "${detail.clouds.all} %"
            )
        }
        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                text = "Humidty"
            )
            Text(
                fontSize = 20.sp,
                text = "${detail.main.humidity} %"
            )
        }
        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                text = "Humidty"
            )
            Text(
                fontSize = 20.sp,
                text = "${detail.wind.speed} km/h"
            )
        }
    }
}

//forecast
@Composable
fun ListForecast(
    forecastResponse: WeatherForecastResponse,
    modifier: Modifier = Modifier
){
    Log.d("listForecast",forecastResponse.list.size.toString())
    LazyColumn(modifier= modifier){
        items(
            count = forecastResponse.list.size,
            key = { forecastResponse.list[it].dt }
        ){
            val data = forecastResponse.list[it]
            forecastCard(detail = data)
        }
    }
}


@Composable
fun forecastCard(
    detail : ForecastItem
){
    val icon = "https://openweathermap.org/img/w/${detail.weather[0].icon}.png"
    val temp = round(detail.main.temp).toInt()

    Row {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(icon)
                .allowHardware(false)
                .build(),
            modifier = Modifier
                .width(100.dp)
                .height(100.dp),
            contentDescription = "Profile Image"
        )
        Column {
            Text(
                text = temp.toString(),
                style = TextStyle(
                    color = Color.White
                ),
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp)
            )
            Text(
                text = detail.weather[0].description,
                style = TextStyle(
                    color = Color.White
                ),
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp)
            )
        }
    }

}
