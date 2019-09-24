package com.masstersoft.weathernordic

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.masstersoft.weathernordic.api.Constants
import com.masstersoft.weathernordic.model.DatabaseWeather
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

        val db: DatabaseWeather = App.instance!!.database!!

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
                    db.weatherDao().clearCurrentWeather()
                    response.body()!!.list.forEach { db.weatherDao().insertCurrentWeather(it) }
                    adapter = WeatherAdapter(ArrayList(db.weatherDao().getCurrentWeatherList()))
                    itemList.adapter = adapter
                }
            })
    }

}
