package com.example.weather_compose.presentasion.home.homescreen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.weather_compose.presentasion.home.HomeViewModel
import com.example.weather_compose.presentasion.home.homeactivity.HomeActivity
import com.example.weather_compose.presentasion.home.searchbar.TopbarSearch
import com.example.weather_compose.presentasion.viewmodelfactory.AppViewModelProvider
import com.example.weather_compose.remote.utils.UserLocation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = AppViewModelProvider.factory
    ),
){
    searchDefault(
        viewModel = viewModel,
        location = ""
    )

    Scaffold(
      topBar = {
          TopbarSearch(
              search = "",
              placeHolderText = "Location user",
          ) {}
      }
    ){
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            HomeActivity(
                fetchResult = viewModel.weatherDetailState,
                fetchResultForecast = viewModel.weatherForecastState
            ){}
        }
    }
}

fun searchDefault(
    viewModel: HomeViewModel,
    location : String
){
    var current = location
    if (location.isEmpty()) current = "surabaya"

    CoroutineScope(Dispatchers.Default).launch{
        withContext(Dispatchers.Main){
            viewModel.apply {
                getDetailWeather(current)
                try {
                    getForecastData(UserLocation(current))
                }catch (e: Error){
                    Log.d("detailWeather",e.toString())
                }
            }
        }
    }
}