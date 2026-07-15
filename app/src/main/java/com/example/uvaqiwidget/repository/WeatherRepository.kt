package com.example.uvaqiwidget.repository

import com.example.uvaqiwidget.network.OpenMeteoApi
import com.example.uvaqiwidget.network.RetrofitInstance


class WeatherRepository(
    private val api: OpenMeteoApi = RetrofitInstance.api
) {

    suspend fun getCurrentUv(
        latitude: Double,
        longitude: Double
    ): Double {

        val response = api.getForecast(
            latitude = latitude,
            longitude = longitude
        )

        return response.hourly.uvIndex.maxOrNull() ?: 0.0
    }
}