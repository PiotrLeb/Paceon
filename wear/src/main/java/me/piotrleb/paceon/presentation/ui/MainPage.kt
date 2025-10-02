package me.piotrleb.paceon.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import me.piotrleb.paceon.presentation.viewmodel.onButtonClick

@Composable
fun MainPage(navController: NavController) {

    LaunchedEffect(Unit) {
        delay(600)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF100F0F)),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = { onButtonClick(navController) },
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB51F1F)),
            contentPadding = ButtonDefaults.ContentPadding,
            modifier = Modifier.size(120.dp)
        ) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Start",
                tint = Color.White,
                modifier = Modifier.size(90.dp)
            )
        }
    }
}
