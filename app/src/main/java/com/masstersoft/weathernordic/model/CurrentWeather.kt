package com.masstersoft.weathernordic.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class CurrentWeather(
    var main: ForecastMain,
    var wind: ForecastWind,
    var clouds: ForecastClouds,
    @SerializedName("name") var cityName: String?
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}





