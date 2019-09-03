package com.masstersoft.weathernordic.model

import com.google.gson.annotations.SerializedName

data class CurrentWeather(
    var main: ForecastMain,
    var wind: ForecastWind,
    @SerializedName("name") var cityName: String
)





