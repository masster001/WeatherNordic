package com.masstersoft.weathernordic.recycler

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.masstersoft.weathernordic.R

class TempViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var temp = itemView.findViewById<TextView>(R.id.temp)
    var pressure = itemView.findViewById<TextView>(R.id.pressure)
    var humidity = itemView.findViewById<TextView>(R.id.humidity)
}