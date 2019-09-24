package com.masstersoft.weathernordic.model.converters

import androidx.room.TypeConverter
import com.masstersoft.weathernordic.model.ForecastClouds

class ForecastCloudsConverter {
    @TypeConverter
    fun fromForecastClouds(forecastClouds: ForecastClouds) = forecastClouds.clouds

    @TypeConverter
    fun toForecastClouds(clouds: Int): ForecastClouds = ForecastClouds(clouds)
}