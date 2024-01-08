package com.example.weather_compose.presentasion.home.homeactivity

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.weather_compose.R
import com.example.weather_compose.presentasion.home.detail.ShowDetailWeather
import com.example.weather_compose.presentasion.navigation.NavigationDestination
import com.example.weather_compose.presentasion.utils.ErrorScreen
import com.example.weather_compose.presentasion.utils.LoadingScreen
import com.example.weather_compose.presentasion.weatherapp.WeatherApp
import com.example.weather_compose.remote.utils.FetchResult
import com.example.weather_compose.remote.utils.FetchResultForecast

object HomeDestination : NavigationDestination {
    override val route = "home"
    override val titleRes = R.string.app_name
}

@Composable
fun HomeActivity(
    fetchResult: FetchResult,
    fetchResultForecast: FetchResultForecast,
    onTryAgain: () -> Unit,
){
    when(fetchResult){
        is FetchResult.Loading ->{
            LoadingScreen()
        }
        is FetchResult.Success->{
            when(fetchResultForecast){
                is FetchResultForecast.Loading ->{

                }
                is FetchResultForecast.Success->{
                    //todo switch inisialisasi animasi icon berdasarkan kondisi cuaca
                    WeatherSelect(fetchResult.detail.weather[0].description)
                    ShowDetailWeather(
                        detail = fetchResult.detail,
                        forecastResponse = fetchResultForecast.detail
                    )
                }
                is FetchResultForecast.Error ->{

                }
            }
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

fun WeatherSelect(
    description : String
){

    Log.d("weatherActivity",description)
}