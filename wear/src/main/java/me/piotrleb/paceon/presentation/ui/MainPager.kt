package me.piotrleb.paceon.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainPager(navController: NavController) {
    val pagerState = rememberPagerState( initialPage = 1, pageCount = {3})
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF100F0F))
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize(),
        ) {
                page ->
            Box{
                when (page) {
                    0 -> TrainingHistoryPage()
                    1 -> MainPage(navController)
                    2 -> PacerPage()
                }
            }
        }
    }
}