package com.masstersoft.weathernordic

import android.app.Application
import com.masstersoft.weathernordic.api.Api
import com.masstersoft.weathernordic.api.ApiFactory

class App : Application() {
    companion object {
        var api: Api = ApiFactory.createApi()
    }
}