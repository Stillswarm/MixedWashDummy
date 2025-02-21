package org.example.mixedwashdummy

import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.example.mixedwashdummy.history.OrderHistoryScreen
import org.example.mixedwashdummy.history.OrderHistoryViewModel
import org.example.mixedwashdummy.services.ServicesScreen
import org.example.mixedwashdummy.services.ServicesScreenViewModel
import org.example.mixedwashdummy.theme.Gray50
import org.example.mixedwashdummy.theme.Poppins
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(onScroll: (Boolean) -> Unit) {
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
        val viewModel = remember { OrderHistoryViewModel() }
        val state by viewModel.uiState.collectAsStateWithLifecycle()
        OrderHistoryScreen(
//            onboardingData = DummyData.onboardingData,
//            services = DummyData.services,
//            insightMetrics = DummyData.insightMetrics,
//            onScroll = onScroll,
            state = state,
//            onEvent = viewModel::onEvent,
            modifier = Modifier.background(Gray50)
        )
    }
}