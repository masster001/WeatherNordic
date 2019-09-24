package com.masstersoft.weathernordic.model.converters

import androidx.room.TypeConverter
import com.masstersoft.weathernordic.model.ForecastWind

class ForecastWindConverter {
    @TypeConverter
    fun fromForecastWind(forecastWind: ForecastWind) = "${forecastWind.degree}_${forecastWind.speed}"

    @TypeConverter
    fun toForecastWind(forecastWind: String): ForecastWind {
        val degree = forecastWind.split("_")[0].toFloat()
        val speed = forecastWind.split("_")[1].toFloat()
        return ForecastWind(degree, speed)
    }
}