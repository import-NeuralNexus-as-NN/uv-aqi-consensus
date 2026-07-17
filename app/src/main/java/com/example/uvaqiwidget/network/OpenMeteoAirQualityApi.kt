package com.example.uvaqiwidget.network

import retrofit2.http.GET
import retrofit2.http.Query


interface OpenMeteoAirQualityApi {

    @GET("v1/air-quality")
    suspend fun getAirQuality(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("hourly") hourly: String = "european_aqi"
    ): AirQualityResponse
}