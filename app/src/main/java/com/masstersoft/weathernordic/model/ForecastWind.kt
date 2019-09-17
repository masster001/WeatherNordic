package com.masstersoft.weathernordic.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class ForecastWind(
    var speed: Float,
    @SerializedName("deg") var degree: Float
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}