package me.piotrleb.paceon.presentation.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.piotrleb.paceon.presentation.model.Training

class TrainingSelectorViewModel : ViewModel(){
    fun onButtonClick(trainingType: String){
        viewModelScope.launch {
            var training = Training(
                type = trainingType,
                elapsedTime = 0,
                distance = 0.0f,
                pace = "",
                heartRate = 0,
                calories = 0,
                avgSpeed = 0.0f,
                avgHeartRate = 0,
                avgPace = "",
            )
            TrainingViewModel().start(training)
        }
    }
}