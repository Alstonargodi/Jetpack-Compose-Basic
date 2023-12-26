package com.example.weather_compose.presentasion.weatherapp

import android.app.Application
import com.example.weather_compose.presentasion.viewmodelfactory.AppContainer
import com.example.weather_compose.presentasion.viewmodelfactory.DefaultAppContainer

class WeatherApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}