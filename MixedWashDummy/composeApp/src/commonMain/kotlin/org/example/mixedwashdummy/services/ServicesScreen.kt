package org.example.mixedwashdummy.services

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
fun ServicesScreen(services: List<Service>, current: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize()
            .edgePadding()
    ) {
        Row {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                itemsIndexed(services) { index, item ->
                    ServiceTab(
                        service = item,
                        isTaken = index <= 2,
                        isSelected = index == current,
                        modifier = Modifier.padding(horizontal = 16.dp),
                    )
                }
            }

            ServiceDetailsCard(
                service = services[current],
                expTime = 24,
                pricing = 95,
                minCart = 395,
                washTempMin = 30,
                washTempMax = 35,
                detergent = "Eco Friendly",
                drying = "Tumble Dry",
                onSelect = {},
                onAdd = {},
                onRemove = {},
                modifier = Modifier.weight(1f)
            )
        }

        ServicesFooter(modifier = Modifier.align(Alignment.BottomCenter))
    }
}
