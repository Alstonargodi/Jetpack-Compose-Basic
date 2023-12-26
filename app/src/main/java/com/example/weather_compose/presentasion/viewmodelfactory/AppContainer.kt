package com.example.weather_compose.presentasion.viewmodelfactory

import com.example.weather_compose.remote.weatherapiservice.WeatherApiService
import com.example.weather_compose.remote.repository.WeatherRepository
import com.example.weather_compose.remote.weatherapiconfig.WeatherApiConfig.weatherApiService

interface AppContainer {
    val remoteRepository : WeatherRepository
}

class DefaultAppContainer : AppContainer {

    override val remoteRepository: WeatherRepository by lazy{
        WeatherRepository(weatherApiService)
    }
}