package me.piotrleb.paceon.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.piotrleb.paceon.presentation.model.Training

class TrainingViewModel : ViewModel(){
    fun start(training: Training){
        viewModelScope.launch {
            training.startTraining()
        }
    }
}