package com.masstersoft.weathernordic.model

import com.google.gson.annotations.SerializedName

data class CurrentWeather(
    var main: ForecastMain,
    var wind: ForecastWind,
    var clouds: ForecastClouds,
    @SerializedName("name") var cityName: String
)





