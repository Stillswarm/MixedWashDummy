package org.example.mixedwashdummy.util

import androidx.compose.foundation.background
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

/**
 * @param order = 1 if light color goes before dark, 2 otherwise
 */
fun Modifier.gradient(
    gradientDark: Color,
    gradientLight: Color,
    order: Int = 1,
) = this.background(
    brush = Brush.linearGradient(
        colors = if (order == 1)
            listOf(gradientLight, gradientDark)
        else
            listOf(gradientDark, gradientLight)
    )
)
