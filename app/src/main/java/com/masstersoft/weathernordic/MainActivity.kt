package com.masstersoft.weathernordic

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.masstersoft.weathernordic.api.Constants
import com.masstersoft.weathernordic.model.CurrentWeather
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        App.api
            .getCurrentWeather(35.02, 139.01)
            .enqueue(object : Callback<CurrentWeather> {

                override fun onFailure(call: Call<CurrentWeather>, t: Throwable) {
                    Log.d(Constants.TAG, t.toString())
                }

                override fun onResponse(
                    call: Call<CurrentWeather>,
                    response: Response<CurrentWeather>
                ) {
                    Log.d(Constants.TAG, response.body().toString())
                }
            })


        object : AsyncTask<Any, Any, Response<CurrentWeather>>() {
            override fun doInBackground(vararg p0: Any?): Response<CurrentWeather> {
                return App.api
                    .getCurrentWeather(34.0, 34.9)
                    .execute()
            }

            override fun onPostExecute(result: Response<CurrentWeather>) {
                Log.d(Constants.TAG, result.toString())
            }
        }.execute()

//        Log.d(Constants.TAG,
//            App.api
//                .getCurrentWeather(34.0,34.9)
//                .execute()
//                .body()
//                .toString())
    }

}
