package org.example.mixedwashdummy.services

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.mixedwashdummy.Service
import org.example.mixedwashdummy.util.edgePadding

@Composable
fun ServicesScreen(
    services: List<Service>,
    state: ServicesScreenState,
    onEvent: (ServicesScreenEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize()
            .edgePadding()
    ) {
        Row {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                itemsIndexed(services) { index, item ->
                    ServiceTab(
                        service = item,
                        isOpted = state.optedServices.contains(index),
                        isCurrent = index == state.currentService,
                        onClick = { onEvent(ServicesScreenEvent.ToggleCurrentService(index)) },
                        modifier = Modifier.padding(horizontal = 16.dp),
                    )
                }
            }

            ServiceDetailsCard(
                service = services[state.currentService],
                onEvent = onEvent,
                mixedMode = state.mixedMode,
                modifier = Modifier.weight(1f),
                isOpted = state.optedServices.contains(state.currentService)
            )
        }

        ServicesFooter(modifier = Modifier.align(Alignment.BottomCenter))
    }
}
