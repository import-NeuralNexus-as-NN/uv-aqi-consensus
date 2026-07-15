package com.example.uvaqiwidget.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.lifecycle.viewModelScope
import com.example.uvaqiwidget.repository.WeatherRepository
import kotlinx.coroutines.launch


class WeatherViewModel(
    private val repository: WeatherRepository = WeatherRepository()
) : ViewModel() {


    private val _uvIndex = MutableStateFlow(0.0)

    val uvIndex = _uvIndex.asStateFlow()


    fun loadUvIndex() {

        viewModelScope.launch {

            _uvIndex.value = repository.getCurrentUv(
                latitude = 52.52,
                longitude = 13.41
            )
        }
    }
}