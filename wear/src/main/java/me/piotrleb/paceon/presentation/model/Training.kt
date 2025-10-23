package me.piotrleb.paceon.presentation.model

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import me.piotrleb.paceon.presentation.data.Location

data class Training(
    var isActive: Boolean = false,
    private var type: String,
    private var elapsedTime: Int,
    private var distance: Float,
    private var pace: String,
    private var heartRate: Int,
    private var calories: Int,
    private var avgSpeed: Float,
    private var avgHeartRate: Int,
    private var avgPace: String,
) {
    @SuppressLint("MissingPermission")
    suspend fun startTraining() = coroutineScope {
        launch {
            isActive = true
            displayData()
        }
    }

    fun stopTraining() {
        isActive = false
    }

    fun displayData() {
        // Wywoływanie tych wszystkich funkcji od pobierania danych z czujników i przypisanie do obiektu
        // Lokalizacja + Dystans + Tempo
        // Tętno
        // Kalorie
    }

    fun getType(): String {
        return type
    }

    fun getElapsedTime(): Int {
        return elapsedTime
    }

    fun getDistance(): Float {
        return distance
    }

    fun getPace(): String {
        return pace
    }

    fun getCalories(): Int {
        return calories
    }

    fun getAvgSpeed(): Float {
        return avgSpeed
    }

    fun getAvgHeartRate(): Int {
        return avgHeartRate
    }

    fun getAvgPace(): String {
        return avgPace
    }
}
