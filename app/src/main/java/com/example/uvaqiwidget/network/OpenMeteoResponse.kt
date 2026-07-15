package com.example.uvaqiwidget.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class OpenMeteoResponse(
    val hourly: HourlyData
)


@Serializable
data class HourlyData(
    val time: List<String>,

    @SerialName("uv_index")
    val uvIndex: List<Double>
)