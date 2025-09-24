package me.piotrleb.paceon.presentation.viewmodel

import androidx.navigation.NavController

fun onButtonClick(navController: NavController) {
    navController.navigate("TrainingTypeSelector")
}