package com.example.weather_compose.remote.utils

sealed class FetchResult{
    data class Success<out T>(val data: T): FetchResult()
    data class Error(val error : String): FetchResult()
    object Loading : FetchResult()
}