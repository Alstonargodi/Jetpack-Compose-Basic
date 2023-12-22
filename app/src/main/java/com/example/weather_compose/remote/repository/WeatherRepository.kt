package com.example.weather_compose.remote.repository

import com.example.weather_compose.remote.WeatherApiService
import com.example.weather_compose.remote.entity.WeatherDetailResponse
import com.example.weather_compose.remote.entity.WeatherForecastResponse
import com.example.weather_compose.remote.utils.UserLocation

class WeatherRepository(
    private var weatherApiService: WeatherApiService
) {
    suspend fun getWeatherDataBySearch(location: String): WeatherDetailResponse =
        weatherApiService.getWeatherDataBySearch(location)

    suspend fun getWeatherLocation(location: UserLocation): WeatherDetailResponse =
        weatherApiService.getWeatherByLocation(
            location = location.location,
            latitude = location.latitude ?: 0.0,
            longtitude = location.longtitude ?: 0.0
        )

    suspend fun getWeatherForecastData(location: UserLocation): WeatherForecastResponse =
        weatherApiService.getWeatherForecastData(
            location = location.location,
            latitude = location.latitude ?: 0.0,
            longtitude = location.longtitude ?: 0.0
        )

}