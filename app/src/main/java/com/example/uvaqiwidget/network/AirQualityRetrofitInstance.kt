package com.example.uvaqiwidget.network

import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory


object AirQualityRetrofitInstance {

    private const val BASE_URL = "https://air-quality-api.open-meteo.com/"


    private val json = Json {
        ignoreUnknownKeys = true
    }


    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(
            json.asConverterFactory(
                "application/json".toMediaType()
            )
        )
        .build()


    val api: OpenMeteoAirQualityApi =
        retrofit.create(OpenMeteoAirQualityApi::class.java)
}