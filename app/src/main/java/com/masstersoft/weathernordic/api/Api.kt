package com.masstersoft.weathernordic.api

import com.masstersoft.weathernordic.model.CurrentWeather
import com.masstersoft.weathernordic.model.WeatherForFiveDays
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface Api {

    @GET("weather")
    fun getCurrentWeather(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,

        @Query("appid") apiKey: String = Constants.API_KEY,
        @Query("units") units: String = Constants.UNITS
    ): Call<CurrentWeather>

    @GET("weather")
    fun getCurrentWeather(
        @Query("q") query: String,

        @Query("appid") apiKey: String = Constants.API_KEY,
        @Query("units") units: String = Constants.UNITS
    ): Call<CurrentWeather>

    @GET("forecast")
    fun getForecastForFiveDays(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,

        @Query("appid") apiKey: String = Constants.API_KEY,
        @Query("units") units: String = Constants.UNITS
    ): Call<WeatherForFiveDays>

    @GET("forecast")
    fun getForecastForFiveDays(
        @Query("q") query: String,

        @Query("appid") apiKey: String = Constants.API_KEY,
        @Query("units") units: String = Constants.UNITS
    ): Call<WeatherForFiveDays>
}