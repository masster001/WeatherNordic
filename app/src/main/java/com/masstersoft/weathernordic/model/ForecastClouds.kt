package com.masstersoft.weathernordic.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class ForecastClouds(
    @SerializedName("all") val clouds: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
