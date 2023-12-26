package com.example.weather_compose.presentasion.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.weather_compose.presentasion.home.HomeDestination
import com.example.weather_compose.presentasion.home.HomeScreen

@Composable
fun WeatherNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = modifier
    ){
        composable(
            route = HomeDestination.route
        ){
            HomeScreen()
        }
    }
}