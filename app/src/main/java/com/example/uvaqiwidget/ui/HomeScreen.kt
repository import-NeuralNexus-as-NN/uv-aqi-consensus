package com.example.uvaqiwidget.ui

import com.example.uvaqiwidget.data.AirQualityData
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
    val data = AirQualityData(
        uvIndex = 7.0,
        aqi = 35,
        location = "Berlin"
    )

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

        UvCard(
            uvIndex = data.uvIndex.toInt()
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        AqiCard(
            aqi = data.aqi
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = {
                // позже добавим обновление данных
            }
        ) {

            Text(
                text = "Обновить"
            )
        }
    }
}