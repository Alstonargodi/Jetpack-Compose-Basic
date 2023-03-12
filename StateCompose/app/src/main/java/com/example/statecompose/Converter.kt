package com.example.statecompose

fun convertToCelsius(fahrenheit: String) =
    fahrenheit.toDoubleOrNull()?.let {
        (it - 32) * 5 / 9
    }.toString()

fun convertToFarenheit(celcius : String) =
    celcius.toDoubleOrNull()?.let {
        (it * 9 / 5) + 32
    }.toString()
