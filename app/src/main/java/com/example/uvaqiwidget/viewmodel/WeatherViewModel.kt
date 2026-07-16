package com.example.uvaqiwidget.viewmodel

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


    private val _uvIndex = MutableStateFlow(0.0)

    val uvIndex = _uvIndex.asStateFlow()


    fun loadUvIndex() {

        locationHelper.getCurrentLocation { latitude, longitude ->

            viewModelScope.launch {

                try {

                    val uv = repository.getCurrentUv(
                        latitude = latitude,
                        longitude = longitude
                    )

                    _uvIndex.value = uv

                } catch (e: Exception) {

                    Log.e(
                        "WEATHER_ERROR",
                        "error: ${e.message}",
                        e
                    )
                }
            }
        }
    }
}
