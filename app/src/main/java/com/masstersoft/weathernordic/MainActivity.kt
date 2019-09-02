package com.masstersoft.weathernordic

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.masstersoft.weathernordic.api.ApiFactory
import com.masstersoft.weathernordic.model.CurrentWeather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ApiFactory.createApi()
            .getCurrentWeather(35.02, 139.01)
            .enqueue(object : Callback<CurrentWeather> {

                override fun onFailure(call: Call<CurrentWeather>, t: Throwable) {
                    Log.d("Nordic",t.toString())
                }

                override fun onResponse(
                    call: Call<CurrentWeather>,
                    response: Response<CurrentWeather>
                ) {
                    Log.d("Nordic",response.body().toString())
                }
            })
    }

}
