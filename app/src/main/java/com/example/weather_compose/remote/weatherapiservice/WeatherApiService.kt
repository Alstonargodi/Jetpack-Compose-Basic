package com.example.weather_compose.remote.weatherapiservice

import com.example.weather_compose.remote.entity.WeatherDetailResponse
import com.example.weather_compose.remote.entity.WeatherForecastResponse
import com.example.weather_compose.remote.utils.Constant
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("weather")
    suspend fun getWeatherDataBySearch(
        @Query("q") location : String,
        @Query("units") units : String = Constant.weatherUnit,
        @Query("appid") apiKey : String = Constant.weatherApiKey,
        @Query("lang") language : String = "en"
    ): WeatherDetailResponse

    @GET("forecast")
    suspend fun getWeatherForecastData(
        @Query("q") location: String? = null,
        @Query("lat") latitude: Double,
        @Query("lon") longtitude: Double,
        @Query("units") units : String = Constant.weatherUnit,
        @Query("appid") apiKey : String = Constant.weatherApiKey,
        @Query("lang") language : String = "en"
    ): WeatherForecastResponse

    @GET("weather")
    suspend fun getWeatherByLocation(
        @Query("q") location: String? = null,
        @Query("lat") latitude: Double,
        @Query("lon") longtitude: Double,
        @Query("units") units: String = Constant.weatherUnit,
        @Query("appid") apiKey: String = Constant.weatherApiKey,
        @Query("lang") language: String = "en"
    ): WeatherDetailResponse

}