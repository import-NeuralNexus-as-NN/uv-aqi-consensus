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

        val currentHour = java.time.LocalDateTime.now(
            java.time.ZoneOffset.UTC
        )
            .withMinute(0)
            .withSecond(0)
            .withNano(0)

        val currentUvIndex = weatherResponse.hourly.time
            .indexOfFirst { time ->
                time == currentHour.toString()
            }
            .let { index ->
                if (index >= 0) {
                    weatherResponse.hourly.uvIndex[index]
                } else {
                    0.0
                }
            }

        return WeatherData(
            uvIndex = currentUvIndex,

            maxUvToday = weatherResponse.hourly.uvIndex.maxOrNull() ?: 0.0,

            aqi = airQualityResponse.hourly.europeanAqi.firstOrNull()
        )
    }
}