package org.example.mixedwashdummy

import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.example.mixedwashdummy.history.OrderHistoryScreen
import org.example.mixedwashdummy.theme.Gray50
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        OrderHistoryScreen(
//            services = DummyData.services,
//            current = 1,
            insightMetrics = DummyData.insightMetrics,
            modifier = Modifier.background(Gray50)
        )
    }
}