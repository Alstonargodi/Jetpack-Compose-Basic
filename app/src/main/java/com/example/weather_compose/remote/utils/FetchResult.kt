package com.example.weather_compose.remote.utils

import com.example.weather_compose.remote.entity.WeatherDetailResponse
import com.example.weather_compose.remote.entity.WeatherForecastResponse

sealed class FetchResult{
    data class Success(val detail: WeatherDetailResponse): FetchResult()
    data class Error(val error : String): FetchResult()
    object Loading : FetchResult()
}

sealed class FetchResultForecast{
    data class Success(val detail: WeatherForecastResponse): FetchResultForecast()
    data class Error(val error : String): FetchResultForecast()
    object Loading : FetchResultForecast()
}