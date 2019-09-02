package com.masstersoft.weathernordic.model

import com.google.gson.annotations.SerializedName

data class ForecastWind(
    var speed: Float,
    @SerializedName("deg") var degree: Float
)