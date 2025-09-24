package me.piotrleb.paceon.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TrainingHistoryPage() {
    Column( modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF100F0F))
        .padding(35.dp, 0.dp)
        .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .padding(0.dp, 35.dp,0.dp,0.dp)
                .height(40.dp*20 + 8.dp *20 + 40.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)

        ) {
            repeat(20){
                TrainingCard()
            }
        }
    }
}