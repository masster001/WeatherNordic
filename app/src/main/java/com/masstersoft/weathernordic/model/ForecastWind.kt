package com.masstersoft.weathernordic.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class ForecastWind(
    var speed: Float,
    @SerializedName("deg") var degree: Float
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}