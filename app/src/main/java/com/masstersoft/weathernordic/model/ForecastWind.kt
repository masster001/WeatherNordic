package com.masstersoft.weathernordic.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class ForecastWind(
    var speed: Float,
    @SerializedName("deg") var degree: Float
)