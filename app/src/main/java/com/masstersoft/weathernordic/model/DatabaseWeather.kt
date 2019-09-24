package com.masstersoft.weathernordic.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.masstersoft.weathernordic.model.converters.ForecastCloudsConverter
import com.masstersoft.weathernordic.model.converters.ForecastMainConverter
import com.masstersoft.weathernordic.model.converters.ForecastWindConverter

@Database(
    entities = arrayOf(
        CurrentWeather::class,
        ForecastMain::class,
        ForecastClouds::class,
        ForecastWind::class
    ), version = 1
)
@TypeConverters(
    ForecastMainConverter::class,
    ForecastWindConverter::class,
    ForecastCloudsConverter::class
)
abstract class DatabaseWeather : RoomDatabase() {

    abstract fun weatherDao(): WeatherDao

    companion object {
        @Volatile
        private var INSTANCE: DatabaseWeather? = null

        fun getDatabase(context: Context): DatabaseWeather {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseWeather::class.java,
                    "DataBase_Weather"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}