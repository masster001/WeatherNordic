package com.masstersoft.weathernordic.model

import com.google.gson.annotations.SerializedName

data class ForecastClouds(
    @SerializedName("all") val clouds: Int
)
