package com.masstersoft.weathernordic

import android.app.Application
import androidx.room.Room
import com.masstersoft.weathernordic.api.Api
import com.masstersoft.weathernordic.api.ApiFactory
import com.masstersoft.weathernordic.model.DatabaseWeather


class App : Application() {

    var database: DatabaseWeather? = null
        private set

    companion object {
        var api: Api = ApiFactory.createApi()
        var instance: App? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room
            .databaseBuilder(this, DatabaseWeather::class.java, "database")
            .allowMainThreadQueries()
            .build()
    }
}