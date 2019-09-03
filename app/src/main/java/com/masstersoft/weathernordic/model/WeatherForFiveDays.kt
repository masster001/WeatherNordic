package com.masstersoft.weathernordic.model

import com.google.gson.annotations.SerializedName


data class WeatherForFiveDays(
    var list: ArrayList<CurrentWeather>,
    @SerializedName("name") var cityName: String
)