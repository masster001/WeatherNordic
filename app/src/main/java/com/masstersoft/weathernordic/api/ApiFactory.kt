package com.masstersoft.weathernordic.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiFactory {
    companion object {
        public fun createApi(): Api {
            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.API_BASE_URL) // Базовый URL
                .addConverterFactory(GsonConverterFactory.create()) // Конвертер JSON
                .build()

            return retrofit.create(Api::class.java)
        }
    }
}