package com.masstersoft.weathernordic.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class ForecastMain(
    var temp: Float,
    var pressure: Float,
    var humidity: Float,
    @SerializedName("temp_min") var minTemp: Float,
    @SerializedName("temp_max") var maxTemp: Float
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

