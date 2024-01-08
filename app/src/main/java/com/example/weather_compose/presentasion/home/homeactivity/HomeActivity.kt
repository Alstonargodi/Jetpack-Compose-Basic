package com.example.weather_compose.presentasion.home.homeactivity

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.weather_compose.R
import com.example.weather_compose.presentasion.customicon.iconutils.Weather
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
): Weather{
    when(description){
         description.contains("sunny",true).toString() ->{ return Weather.Sunny }
        "Mostly Clear"->{ return Weather.MostlyClear }
        description.contains("cloud",true).toString()->{
            return Weather.HeavyRain
        }
        "Cloudy Rain"->{ return Weather.CloudyRain}
        "Heavy Rain"->{ return Weather.HeavyRain}
        "Snowy"->{ return Weather.Snowy}
        "Storm"->{ return Weather.Storm}
        else->{ return Weather.MostlyClear }
    }
}