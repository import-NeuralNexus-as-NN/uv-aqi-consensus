package com.example.uvaqiwidget.location

import android.annotation.SuppressLint
import android.content.Context
import com.google.android.gms.location.*

class LocationHelper(
    context: Context
) {

    private val fusedLocationClient =
        LocationServices.getFusedLocationProviderClient(context)


    @SuppressLint("MissingPermission")
    fun getCurrentLocation(
        onResult: (latitude: Double, longitude: Double) -> Unit
    ) {

        val locationRequest =
            LocationRequest.Builder(
                Priority.PRIORITY_HIGH_ACCURACY,
                1000
            )
                .setMaxUpdates(1)
                .build()


        val callback = object : LocationCallback() {

            override fun onLocationResult(
                result: LocationResult
            ) {

                val location = result.lastLocation

                if (location != null) {

                    onResult(
                        location.latitude,
                        location.longitude
                    )
                }
            }
        }


        fusedLocationClient.requestLocationUpdates(
            locationRequest,
            callback,
            null
        )
    }
}