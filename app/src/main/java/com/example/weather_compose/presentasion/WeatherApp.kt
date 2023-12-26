package com.example.weather_compose.presentasion

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun WeatherApp(
    navHostController: NavHostController = rememberNavController()
){
    val systemUiController = rememberSystemUiController()
    SideEffect { systemUiController.setSystemBarsColor(color = Color.Black) }
    GithubNavHost(navHostController)
}