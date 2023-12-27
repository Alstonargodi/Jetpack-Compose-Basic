package com.example.weather_compose.presentasion.weatherapp

import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.weather_compose.presentasion.navigation.WeatherNavigation
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun WeatherApp(
    navHostController: NavHostController = rememberNavController()
){
    val systemUiController = rememberSystemUiController()
    SideEffect { systemUiController.setSystemBarsColor(color = Color.Black) }
    WeatherNavigation(navHostController)
}