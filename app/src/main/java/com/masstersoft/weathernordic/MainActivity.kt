package com.masstersoft.weathernordic

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.masstersoft.weathernordic.api.Constants
import com.masstersoft.weathernordic.model.CurrentWeather
import com.masstersoft.weathernordic.model.WeatherForFiveDays
import com.masstersoft.weathernordic.recycler.WeatherAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var adapter: WeatherAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = WeatherAdapter(arrayListOf())

        itemList.layoutManager = LinearLayoutManager(this)
        itemList.adapter = adapter

        App.api
            .getForecastForFiveDays("Moscow")
            .enqueue(object : Callback<WeatherForFiveDays> {

                override fun onFailure(call: Call<WeatherForFiveDays>, t: Throwable) {
                    Log.d(Constants.TAG, t.toString())
                }

                override fun onResponse(
                    call: Call<WeatherForFiveDays>,
                    response: Response<WeatherForFiveDays>
                ) {
                    adapter = WeatherAdapter(response.body()!!.list)
                    itemList.adapter = adapter
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

    fun parseList(result: Response<WeatherForFiveDays>) {
        when (result.code()) {
            in 200..299 -> printList(result.body()?.list)
            else -> result.errorBody().toString()
        }
    }

    fun printList(list: ArrayList<CurrentWeather>?) {
        //list?.forEach { Log.d(Constants.TAG, it.toString()) }
        Log.d(Constants.TAG, list.toString())
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
