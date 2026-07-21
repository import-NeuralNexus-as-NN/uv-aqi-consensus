package com.example.uvaqiwidget.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.uvaqiwidget.location.LocationHelper


class WeatherViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {


    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        if (modelClass.isAssignableFrom(WeatherViewModel::class.java)) {

            return WeatherViewModel(
                locationHelper = LocationHelper(context)
            ) as T

        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}