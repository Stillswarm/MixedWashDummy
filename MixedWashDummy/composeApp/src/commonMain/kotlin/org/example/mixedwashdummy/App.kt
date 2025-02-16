package org.example.mixedwashdummy

import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.example.mixedwashdummy.history.OrderHistoryScreen
import org.example.mixedwashdummy.theme.Gray50
import org.example.mixedwashdummy.theme.Poppins
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val customTypography = MaterialTheme.typography.let {
        it.copy(
            h1 = it.h1.copy(fontFamily = Poppins()),
            h2 = it.h2.copy(fontFamily = Poppins()),
            h3 = it.h3.copy(fontFamily = Poppins()),
            h4 = it.h4.copy(fontFamily = Poppins()),
            h5 = it.h5.copy(fontFamily = Poppins()),
            h6 = it.h6.copy(fontFamily = Poppins()),
            subtitle1 = it.subtitle1.copy(fontFamily = Poppins()),
            subtitle2 = it.subtitle2.copy(fontFamily = Poppins()),
            body1 = it.body1.copy(fontFamily = Poppins()),
            body2 = it.body2.copy(fontFamily = Poppins()),
            button = it.button.copy(fontFamily = Poppins()),
            caption = it.caption.copy(fontFamily = Poppins()),
            overline = it.overline.copy(fontFamily = Poppins())
        )
    }
    MaterialTheme(
        typography = customTypography
    ) {
        OrderHistoryScreen(
//            services = DummyData.services,
//            current = 1,
            insightMetrics = DummyData.insightMetrics,
            modifier = Modifier.background(Gray50)
        )
    }
}