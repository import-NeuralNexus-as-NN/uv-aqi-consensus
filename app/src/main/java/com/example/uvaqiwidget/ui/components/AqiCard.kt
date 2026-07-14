package com.example.uvaqiwidget.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun AqiCard(
    aqi: Int = 35
) {
    Card {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Text(
                text = "🌫 AQI",
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = aqi.toString(),
                style = MaterialTheme.typography.displayLarge
            )

            Text(
                text = "Хорошее качество воздуха"
            )
        }
    }
}