package com.masstersoft.weathernordic.api

import com.masstersoft.weathernordic.model.CurrentWeather
import com.masstersoft.weathernordic.model.ForecastMain
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface Api {

    @GET("weather")
    fun getCurrentWeather(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,

        @Query("appid") apiKey: String,
        @Query("units") units: String
    ): Call<CurrentWeather>
}