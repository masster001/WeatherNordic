package com.masstersoft.weathernordic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    //https://api.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=58c3cdec0969373fd82d01a13c7de5bc&units=metric
}
