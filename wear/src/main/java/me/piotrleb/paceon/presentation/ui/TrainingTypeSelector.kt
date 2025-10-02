package me.piotrleb.paceon.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import kotlinx.coroutines.delay
import kotlin.math.absoluteValue

@Composable
fun TrainingTypeSelector() {

    LaunchedEffect(Unit) {
        delay(600)
    }

    val pagerState = rememberPagerState(initialPage = 0, pageCount = { 5 })
    val gradients = listOf(
        Brush.linearGradient(listOf(Color(0xFF3D8F07), Color(0xFF142F02))),
        Brush.linearGradient(listOf(Color(0xFF984CDE), Color(0xFF371159))),
        Brush.linearGradient(listOf(Color(0xFF07378F), Color(0xFF021029))),
        Brush.linearGradient(listOf(Color(0xFFFFCC00), Color(0xFF352B05))),
        Brush.linearGradient(listOf(Color(0xFF8F0710), Color(0xFF290205)))
    )


    val text = listOf("Easy", "Long", "Tempo", "Interval", "Race")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF100F0F)),
        contentAlignment = Alignment.Center
    ) {
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(44.dp),
            pageSpacing = (-15).dp,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            val pageOffset = ((pagerState.currentPage - page) + pagerState.currentPageOffsetFraction).absoluteValue
            val zIndex = 1f - pageOffset

            Button(
                onClick = {},
                shape = CircleShape,
                contentPadding = ButtonDefaults.ContentPadding,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                modifier = Modifier
                    .zIndex(zIndex)
                    .size(200.dp)
                    .shadow(
                        elevation = 5.dp,
                        shape = CircleShape,
                        ambientColor = Color(0xFFb6bab7)
                    )
                    .background(brush = gradients[page])
            ) {
                Text(
                    text = text[page],
                    fontSize = 25.sp
                )
            }
        }
    }
}