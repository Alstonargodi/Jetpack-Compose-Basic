package com.example.weather_compose.presentasion.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import com.example.weather_compose.presentasion.viewmodelfactory.AppViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = AppViewModelProvider.factory
    )
){

    CoroutineScope(Dispatchers.Default).launch{
        withContext(Dispatchers.Main){
            viewModel.apply {
                getDetailWeather("surabaya")
            }
        }
    }

    Text(text = "tes")
    HomeActivity(
        fetchResult = viewModel.weatherDetailState
    ){

    }
}