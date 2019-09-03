package com.masstersoft.weathernordic.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.masstersoft.weathernordic.R
import com.masstersoft.weathernordic.model.CurrentWeather

class WeatherAdapter(private val items: ArrayList<CurrentWeather>) :
    RecyclerView.Adapter<TempViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TempViewHolder {
        val v = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.weather_item, parent, false)
        return TempViewHolder(v)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: TempViewHolder, position: Int) {
        val item = items[position]
        holder.temp.text = "Temp = ${item.main.temp}"
        holder.pressure.text = "pressure = ${item.main.pressure}"
        holder.humidity.text = "humidity = ${item.main.humidity}"
    }
}