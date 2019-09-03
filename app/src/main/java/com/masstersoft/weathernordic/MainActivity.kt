package com.masstersoft.weathernordic

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
                    parseResponse(response)
                }
            })


//        object : AsyncTask<Any, Any, Response<CurrentWeather>>() {
//            override fun doInBackground(vararg p0: Any?): Response<CurrentWeather> {
//                return App.api
//                    .getCurrentWeather(34.0, 34.9)
//                    .execute()
//            }
//
//            override fun onPostExecute(result: Response<CurrentWeather>) {
//                Log.d(Constants.TAG, result.errorBody().toString())
//            }
//        }.execute()

//        Log.d(Constants.TAG,
//            App.api
//                .getCurrentWeather(34.0,34.9)
//                .execute()
//                .body()
//                .toString())
    }

    fun parseResponse(result: Response<CurrentWeather>) {

//        when (result.code()) {
//            in 200..299 -> Log.d(Constants.TAG, result.toString())
//            else -> Log.d(Constants.TAG, result.errorBody().toString())
//        }
//
//        if(result.isSuccessful){
//            Log.d(Constants.TAG, result.toString())
//        }else{
//            Log.d(Constants.TAG, result.errorBody().toString())
//        }

//        Log.d(
//            Constants.TAG, when (result.code()) {
//                in 200..299 -> result.toString()
//                else -> result.errorBody().toString()
//            }
//        )

        Log.d(Constants.TAG, getResponse(result))

    }

//    fun getResponse(result: Response<CurrentWeather>): String = if (result.isSuccessful) {
//        result.toString()
//    } else {
//        result.errorBody().toString()
//    }

    fun getResponse(result: Response<CurrentWeather>): String =
        when (result.code()) {
            in 200..299 -> result.toString()
            else -> result.errorBody().toString()
        }


}
