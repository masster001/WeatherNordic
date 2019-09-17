package com.masstersoft.weathernordic.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface WeatherDao {
    @Query("SELECT * FROM CurrentWeather")
    fun getAll(): List<CurrentWeather>

    @Insert
    fun insert(currentWeather: CurrentWeather)

    @Delete
    fun delete(currentWeather: CurrentWeather)

    @Query("SELECT * FROM ForecastMain")
    fun getForecastMain(): List<ForecastMain>

    @Insert
    fun inserForcast(forcastMain: ForecastMain)

    @Delete
    fun deleteForcast(forcastMain: ForecastMain)
}