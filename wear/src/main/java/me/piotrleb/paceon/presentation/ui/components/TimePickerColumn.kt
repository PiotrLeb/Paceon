package me.piotrleb.paceon.presentation.ui.components
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TimePicker(
    modifier: Modifier = Modifier,
    initialMinute: Int = 0,
    initialSecond: Int = 0,
    onTimeSelected: (minute: Int, second: Int) -> Unit
) {
    val minutes = (0..10).toList()
    val seconds = (0..59).toList()

    var selectedMinute by remember { mutableStateOf(initialMinute) }
    var selectedSecond by remember { mutableStateOf(initialSecond) }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Picker minut
        NumberPicker(
            numbers = minutes,
            selected = selectedMinute,
            onValueChange = {
                selectedMinute = it
                onTimeSelected(selectedMinute, selectedSecond)
            }
        )

        Spacer(modifier = Modifier.width(8.dp))
        Text(":", color = Color(0xFFFFFFFF), fontSize = 30.sp)
        Spacer(modifier = Modifier.width(8.dp))

        // Picker sekund
        NumberPicker(
            numbers = seconds,
            selected = selectedSecond,
            onValueChange = {
                selectedSecond = it
                onTimeSelected(selectedMinute, selectedSecond)
            }
        )
    }
}

@Composable
private fun NumberPicker(
    numbers: List<Int>,
    selected: Int,
    onValueChange: (Int) -> Unit
) {
    val lazyListState = rememberLazyListState()
    val density = LocalDensity.current

    LaunchedEffect(Unit) {
        lazyListState.scrollToItem(selected)
    }

    LaunchedEffect(lazyListState.isScrollInProgress) {
        if (!lazyListState.isScrollInProgress) {
            val offset = lazyListState.firstVisibleItemScrollOffset
            val currentIndex = lazyListState.firstVisibleItemIndex
            val itemHeightPx = with(density) { 60.dp.toPx() }
            val targetIndex =
                if (offset > itemHeightPx / 2) currentIndex + 1 else currentIndex

            lazyListState.animateScrollToItem(targetIndex.coerceIn(0, numbers.lastIndex))
            onValueChange(numbers[targetIndex.coerceIn(0, numbers.lastIndex)])
        }
    }

    Box(
        modifier = Modifier
            .height(60.dp)
            .width(60.dp),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            state = lazyListState,
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            items(numbers.size) { index ->
                val number = numbers[index]
                val isSelected = number == selected

                Box(
                    modifier = Modifier
                        .height(60.dp)
                        .width(60.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = number.toString().padStart(2, '0'),
                        style = if (isSelected)
                            MaterialTheme.typography.titleLarge.copy(color = Color(0xFF3D8F07))
                        else
                            MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSurfaceVariant),
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        fontSize = 30.sp
                    )
                }
            }
        }
    }
}