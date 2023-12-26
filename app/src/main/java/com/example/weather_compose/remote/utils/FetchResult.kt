package com.example.weather_compose.remote.utils

import com.example.weather_compose.remote.entity.WeatherDetailResponse

sealed class FetchResult{
    data class Success(val detail: WeatherDetailResponse): FetchResult()
    data class Error(val error : String): FetchResult()
    object Loading : FetchResult()
}