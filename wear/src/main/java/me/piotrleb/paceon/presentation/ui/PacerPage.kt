package me.piotrleb.paceon.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import me.piotrleb.paceon.presentation.ui.components.TimePicker

@Composable
fun PacerPage() {
    var selectedTime by remember { mutableStateOf("12:00") }
    LaunchedEffect(Unit) {
        delay(600)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp, 0.dp),
    ) {
        Column(
            modifier = Modifier
                .background(Color(0xFF100F0F))
                .height(200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(
                space = 15.dp,
                alignment = Alignment.CenterVertically
            )
        ) {
            Text("Target pace", color = Color(0xFFFFFFFF))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color(0xFF2A2B2E)),
                horizontalArrangement = Arrangement.Center,
            ) {
                TimePicker(
                    modifier = Modifier,
                    initialMinute = 0,
                    initialSecond = 0,
                    onTimeSelected = { minute, second ->
                        selectedTime = "%02d:%02d".format(minute, second)
                    }
                )
            }
        }
    }
}