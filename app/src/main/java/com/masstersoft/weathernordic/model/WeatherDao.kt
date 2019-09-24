package com.masstersoft.weathernordic.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface WeatherDao {

    @Insert
    fun insertCurrentWeather(currentWeather: CurrentWeather)

    @Query("SELECT * FROM CurrentWeather")
    fun getCurrentWeatherList(): List<CurrentWeather>

    @Query("DELETE FROM CurrentWeather")
    fun clearCurrentWeather()

    @Query("SELECT * FROM ForecastWind")
    fun getAll(): List<ForecastWind>

    @Insert
    fun insert(currentWeather: ForecastWind)

    @Delete
    fun delete(currentWeather: ForecastWind)

    @Query("SELECT * FROM ForecastMain")
    fun getForecastMain(): List<ForecastMain>

    @Insert
    fun inserForcast(forcastMain: ForecastMain)

    @Delete
    fun deleteForcast(forcastMain: ForecastMain)
}