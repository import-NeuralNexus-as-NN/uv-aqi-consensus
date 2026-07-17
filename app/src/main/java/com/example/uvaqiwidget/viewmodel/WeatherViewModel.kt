package com.example.uvaqiwidget.viewmodel

import com.example.uvaqiwidget.ui.state.WeatherUiState
import android.util.Log
import com.example.uvaqiwidget.location.LocationHelper
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.lifecycle.viewModelScope
import com.example.uvaqiwidget.repository.WeatherRepository
import kotlinx.coroutines.launch


class WeatherViewModel(
    private val repository: WeatherRepository = WeatherRepository(),
    private val locationHelper: LocationHelper
) : ViewModel() {


    private val _uiState =
        MutableStateFlow<WeatherUiState>(
            WeatherUiState.Loading
        )

    val uiState = _uiState.asStateFlow()


    fun loadUvIndex() {

        locationHelper.getCurrentLocation { latitude, longitude ->

            viewModelScope.launch {

                try {

                    val uv = repository.getCurrentUv(
                        latitude = latitude,
                        longitude = longitude
                    )

                    _uiState.value =
                        WeatherUiState.Success(uv)

                } catch (e: Exception) {

                    Log.e(
                        "WEATHER_ERROR",
                        "error: ${e.message}",
                        e
                    )

                    _uiState.value =
                        WeatherUiState.Error(
                            e.message ?: "Unknown error"
                        )
                }
            }
        }
    }
}
