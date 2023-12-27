package com.example.weather_compose.presentasion.home.homeactivity

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.weather_compose.R
import com.example.weather_compose.presentasion.navigation.NavigationDestination
import com.example.weather_compose.presentasion.utils.ErrorScreen
import com.example.weather_compose.presentasion.utils.LoadingScreen
import com.example.weather_compose.presentasion.weatherapp.WeatherApp
import com.example.weather_compose.remote.utils.FetchResult

object HomeDestination : NavigationDestination {
    override val route = "home"
    override val titleRes = R.string.app_name
}

@Composable
fun HomeActivity(
    fetchResult: FetchResult,
    modifier: Modifier = Modifier,
    onTryAgain: () -> Unit,
){
    Text(text = "tes")
    when(fetchResult){
        is FetchResult.Loading ->{
            LoadingScreen()
        }
        is FetchResult.Success->{
            Log.d("result test", fetchResult.detail.name)
            //show detail
            Text(
                text = fetchResult.detail.name,
                color = Color.White
            )
        }
        is FetchResult.Error->{
            ErrorScreen(
                fetchResult.error,
                onTryAgain
            )
            Log.d("HomeActivity",fetchResult.error)
        }
    }
}