package com.masstersoft.weathernordic.model

import com.google.gson.annotations.SerializedName

data class WeatherForFiveDays(
    var clouds: ForecastClouds,
    var wind: ForecastWind,
    @SerializedName("name") var cityName: String,
    var list: MutableList<ForecastMain>)