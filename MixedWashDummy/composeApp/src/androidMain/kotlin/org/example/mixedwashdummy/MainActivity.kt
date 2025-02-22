package org.example.mixedwashdummy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.core.graphics.ColorUtils
import org.example.mixedwashdummy.ui.theme.Gray300

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var isScrolled by remember { mutableStateOf(false) }

            val statusBarColor = if (isScrolled) Gray300.toArgb() else Color.Transparent.toArgb()

            // Determine if the content should be dark or light based on the background color
            val useDarkIcons = isColorLight(statusBarColor)

            enableEdgeToEdge(
                statusBarStyle = if (useDarkIcons) {
                    SystemBarStyle.light(statusBarColor, statusBarColor) // Light status bar with dark icons
                } else {
                    SystemBarStyle.dark(statusBarColor) // Dark status bar with light icons
                }
            )

            App(onScroll = { isScrolled = it })
        }
    }


    // Function to check if a color is light or dark
    private fun isColorLight(color: Int): Boolean {
        return ColorUtils.calculateLuminance(color) > 0.5
    }
}