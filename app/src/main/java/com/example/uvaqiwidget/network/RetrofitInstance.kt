package com.example.uvaqiwidget.network

import kotlinx.serialization.json.Json
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType


object RetrofitInstance {

    private const val BASE_URL = "https://api.open-meteo.com/"


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


    val api: OpenMeteoApi =
        retrofit.create(OpenMeteoApi::class.java)
}