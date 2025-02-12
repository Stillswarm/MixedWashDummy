package org.example.mixedwashdummy.util

import android.graphics.BlurMaskFilter
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.unit.Dp

actual fun applyBlurEffect(
    paint: Paint,
    blur: Float
) {
    paint.asFrameworkPaint().apply {
        maskFilter = BlurMaskFilter(blur, BlurMaskFilter.Blur.NORMAL)
    }
}