package com.example.weather_compose.presentasion.viewmodelfactory

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.weather_compose.presentasion.home.HomeViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import com.example.weather_compose.presentasion.weatherapp.WeatherApplication

object AppViewModelProvider {
    val factory : ViewModelProvider.Factory = viewModelFactory {
        //init repository
        initializer {
            val application = (this[APPLICATION_KEY] as WeatherApplication)
            HomeViewModel(
                application.container.remoteRepository
            )
        }
    }
}