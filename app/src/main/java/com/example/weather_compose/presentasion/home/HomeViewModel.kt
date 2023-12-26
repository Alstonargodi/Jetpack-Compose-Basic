package com.example.weather_compose.presentasion.home

import androidx.lifecycle.ViewModel
import com.example.weather_compose.remote.repository.WeatherRepository
import com.example.weather_compose.remote.utils.FetchResult
import kotlinx.coroutines.flow.MutableStateFlow

class HomeViewModel(
    private val repository: WeatherRepository
): ViewModel(){
    private val searchCity: MutableStateFlow<String> = MutableStateFlow("")

    var weatherDetailState: FetchResult by muta

}