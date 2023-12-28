package com.example.weather_compose.presentasion.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.weather_compose.remote.repository.WeatherRepository
import com.example.weather_compose.remote.utils.FetchResult
import com.example.weather_compose.remote.utils.FetchResultForecast
import com.example.weather_compose.remote.utils.HttpErrorMessage
import com.example.weather_compose.remote.utils.UserLocation
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.HttpException
import java.io.IOException

class HomeViewModel(
    private val repository: WeatherRepository
): ViewModel(){
    private val searchCity: MutableStateFlow<String> = MutableStateFlow("")

    var weatherDetailState: FetchResult by mutableStateOf(
        FetchResult.Loading
    )
        private set

    var weatherForecastState : FetchResultForecast by mutableStateOf(FetchResultForecast.Loading)
        private set

    suspend fun getDetailWeather(location : String){
        weatherDetailState = FetchResult.Loading
        weatherDetailState = try {
            FetchResult.Success(repository.getWeatherDataBySearch(location))
        } catch (e : IOException){
            FetchResult.Error(e.message.toString())
        }catch (e : HttpException){
            FetchResult.Error(HttpErrorMessage(e.code()))
        }
    }

    suspend fun getForecastData(location: UserLocation){
        weatherForecastState = FetchResultForecast.Loading
        weatherForecastState = try{
            FetchResultForecast.Success(repository.getWeatherForecastData(location))
        }catch (e : IOException){
            FetchResultForecast.Error(e.message.toString())
        }catch (e : HttpException){
            FetchResultForecast.Error(HttpErrorMessage(e.code()))
        }
    }

    fun searchTextOnChange(location: String){
        searchCity.value = location
    }

}