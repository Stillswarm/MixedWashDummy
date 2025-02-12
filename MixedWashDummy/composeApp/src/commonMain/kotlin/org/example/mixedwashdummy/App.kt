package org.example.mixedwashdummy

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.mixedwashdummy.home.HomeScreen
import org.example.mixedwashdummy.theme.Gray100
import org.example.mixedwashdummy.theme.Gray200
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        HomeScreen(
            modifier = Modifier.background(Gray100).statusBarsPadding()
                .navigationBarsPadding()
                .padding(16.dp)
        )
    }
}