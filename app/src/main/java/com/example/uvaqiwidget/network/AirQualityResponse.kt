package com.example.uvaqiwidget.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class AirQualityResponse(
    val hourly: AirQualityHourly
)


@Serializable
data class AirQualityHourly(
    val time: List<String>,

    @SerialName("european_aqi")
    val europeanAqi: List<Double?>
)