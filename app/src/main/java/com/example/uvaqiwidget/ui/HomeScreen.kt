package com.example.uvaqiwidget.ui

import com.example.uvaqiwidget.utils.getAqiDescription
import com.example.uvaqiwidget.utils.getUvDescription
import com.example.uvaqiwidget.ui.state.WeatherUiState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.uvaqiwidget.viewmodel.WeatherViewModelFactory
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.example.uvaqiwidget.viewmodel.WeatherViewModel
import com.example.uvaqiwidget.ui.components.AqiCard
import com.example.uvaqiwidget.ui.components.UvCard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    val viewModel: WeatherViewModel = viewModel(
        factory = WeatherViewModelFactory(context)
    )

    val uiState = viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadUvIndex()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),

        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "UV & AQI Consensus",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        when (val state = uiState.value) {

            WeatherUiState.Loading -> {

                Text(
                    text = "Loading..."
                )
            }

            is WeatherUiState.Success -> {

                UvCard(
                    uvIndex = state.weatherData.uvIndex.toInt(),
                    description = getUvDescription(
                        state.weatherData.uvIndex.toInt()
                    )
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                AqiCard(
                    aqi = state.weatherData.aqi?.toInt() ?: 0,
                    description = getAqiDescription(
                        state.weatherData.aqi?.toInt() ?: 0
                    )
                )
            }

            is WeatherUiState.Error -> {

                Text(
                    text = state.message,
                    color = MaterialTheme.colorScheme.error
                )
            }
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = {
                viewModel.loadUvIndex()
            }
        ) {

            Text(
                text = "Обновить"
            )
        }
    }
}