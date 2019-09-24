package com.masstersoft.weathernordic.model.converters

import androidx.room.TypeConverter
import com.masstersoft.weathernordic.model.ForecastMain

class ForecastMainConverter {
    @TypeConverter
    fun fromForecastWind(forecastMain: ForecastMain) = "" +
            "${forecastMain.humidity}_" +
            "${forecastMain.pressure}_" +
            "${forecastMain.maxTemp}_" +
            "${forecastMain.minTemp}_" +
            "${forecastMain.temp}"

    @TypeConverter
    fun toForecastWind(forecastMain: String): ForecastMain {
        val humidity = forecastMain.split("_")[0].toFloat()
        val pressure = forecastMain.split("_")[1].toFloat()
        val maxTemp = forecastMain.split("_")[2].toFloat()
        val minTemp = forecastMain.split("_")[3].toFloat()
        val temp = forecastMain.split("_")[4].toFloat()
        return ForecastMain(temp, pressure, humidity, minTemp, maxTemp)
    }
}