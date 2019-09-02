package com.masstersoft.weathernordic.model

import com.google.gson.annotations.SerializedName

data class ForecastMain(
    var temp: Float,
    var pressure: Float,
    var humidity: Float,
    @SerializedName("temp_min") var minTemp: Float,
    @SerializedName("temp_max") var maxTemp: Float)

