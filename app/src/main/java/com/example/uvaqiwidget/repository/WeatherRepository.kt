package com.example.uvaqiwidget.repository

import com.example.uvaqiwidget.data.WeatherData
import com.example.uvaqiwidget.network.AirQualityRetrofitInstance
import com.example.uvaqiwidget.network.OpenMeteoApi
import com.example.uvaqiwidget.network.OpenMeteoAirQualityApi
import com.example.uvaqiwidget.network.RetrofitInstance


class WeatherRepository(
    private val api: OpenMeteoApi = RetrofitInstance.api,
    private val airQualityApi: OpenMeteoAirQualityApi = AirQualityRetrofitInstance.api
) {

    suspend fun getCurrentWeather(
        latitude: Double,
        longitude: Double
    ): WeatherData {

        val weatherResponse = api.getForecast(
            latitude = latitude,
            longitude = longitude
        )

        val airQualityResponse = airQualityApi.getAirQuality(
            latitude = latitude,
            longitude = longitude
        )

        return WeatherData(
            uvIndex = weatherResponse.hourly.uvIndex.maxOrNull() ?: 0.0,
            aqi = airQualityResponse.hourly.europeanAqi.firstOrNull()
        )
    }
}