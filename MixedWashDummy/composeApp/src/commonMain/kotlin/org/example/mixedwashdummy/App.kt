package org.example.mixedwashdummy

import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.example.mixedwashdummy.history.OrderHistoryScreen
import org.example.mixedwashdummy.services.ServicesScreen
import org.example.mixedwashdummy.theme.Gray50
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        ServicesScreen(
            modifier = Modifier.background(Gray50)
        )
    }
}