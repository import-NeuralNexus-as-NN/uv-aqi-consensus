package com.example.uvaqiwidget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.uvaqiwidget.ui.theme.UVAQIWidgetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            UVAQIWidgetTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    HomeScreen(
                        modifier = Modifier.padding(innerPadding)
                    )

                }
            }
        }
    }
}


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {

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


        Card {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "☀ UV Index",
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "7",
                    style = MaterialTheme.typography.displayLarge
                )

                Text(
                    text = "Высокий уровень"
                )
            }
        }


        Spacer(
            modifier = Modifier.height(16.dp)
        )


        Card {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "🌫 AQI",
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = "35",
                    style = MaterialTheme.typography.displayLarge
                )

                Text(
                    text = "Хорошее качество воздуха"
                )
            }
        }


        Spacer(
            modifier = Modifier.height(24.dp)
        )


        Button(
            onClick = {
                // позже здесь будет обновление данных
            }
        ) {

            Text(
                text = "Обновить"
            )

        }
    }
}