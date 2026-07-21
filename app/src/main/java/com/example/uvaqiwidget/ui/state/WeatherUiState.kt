package com.example.uvaqiwidget.ui.state

import com.example.uvaqiwidget.data.WeatherData
sealed interface WeatherUiState {

    data object Loading : WeatherUiState

    data class Success(
        val weatherData: WeatherData
    ) : WeatherUiState

    data class Error(
        val message: String
    ) : WeatherUiState
}