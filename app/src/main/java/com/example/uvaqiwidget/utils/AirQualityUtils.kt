package com.example.uvaqiwidget.utils


fun getUvDescription(uvIndex: Int): String {

    return when (uvIndex) {

        in 0..2 -> "Низкий"

        in 3..5 -> "Умеренный"

        in 6..7 -> "Высокий"

        in 8..10 -> "Очень высокий"

        else -> "Экстремальный"
    }
}


fun getAqiDescription(aqi: Int): String {

    return when (aqi) {

        in 0..20 -> "Хорошее"

        in 21..40 -> "Удовлетворительное"

        in 41..60 -> "Умеренное"

        in 61..80 -> "Плохое"

        in 81..100 -> "Очень плохое"

        else -> "Крайне плохое"
    }
}