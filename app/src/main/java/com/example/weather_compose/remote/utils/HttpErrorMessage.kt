package com.example.weather_compose.remote.utils

fun HttpErrorMessage(
    message : Int
): String{
    return when {
        message in 100..199 -> "Informational Error"
        message in 300..399 -> "Redirection Error"
        message in 400..499 -> "Client Error"
        message in 500..599 -> "Server Error"
        else -> ""
    }
}