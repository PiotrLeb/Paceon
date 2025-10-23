package me.piotrleb.paceon.presentation.data

import android.Manifest
import android.content.Context
import android.location.LocationManager
import android.util.Log
import androidx.annotation.RequiresPermission
import com.google.android.gms.location.LocationServices

class Location(){
    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
     fun getLocation(context: Context) {
        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val isGpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        val isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

        if (!isGpsEnabled && isNetworkEnabled) {
            throw LocationClient.LocationException("GPS is disabled")
        }

        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: android.location.Location? ->
                location?.let {
                    val latitude = it.latitude
                    val longitude = it.longitude
                    val speed = it.speed
                    Log.d("Wygrana kurwa", "($latitude)")
                    Log.d("Wygrana kurwa", "($longitude)")
                    Log.d("Wygrana kurwa", "($speed)")
                }
            }
    }
}