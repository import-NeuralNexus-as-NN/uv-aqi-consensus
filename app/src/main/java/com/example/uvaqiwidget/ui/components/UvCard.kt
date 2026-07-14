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
fun UvCard(
    uvIndex: Int = 7
) {
    Card {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Text(
                text = "☀ UV Index",
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = uvIndex.toString(),
                style = MaterialTheme.typography.displayLarge
            )

            Text(
                text = "Высокий уровень"
            )
        }
    }
}