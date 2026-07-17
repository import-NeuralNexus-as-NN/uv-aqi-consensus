package com.example.uvaqiwidget.ui.state

sealed interface WeatherUiState {

    data object Loading : WeatherUiState

    data class Success(
        val uvIndex: Double
    ) : WeatherUiState

    data class Error(
        val message: String
    ) : WeatherUiState
}