package org.example.mixedwashdummy.services

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.example.mixedwashdummy.Service
import org.example.mixedwashdummy.common.AppButton
import org.example.mixedwashdummy.common.AppText
import org.example.mixedwashdummy.theme.Gray100
import org.example.mixedwashdummy.theme.Gray900
import org.example.mixedwashdummy.util.edgePadding

@Composable
fun ServicesScreen(services: List<Service>, current: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize()
            .edgePadding(extraHorizontal = 16.dp, extraVertical = 16.dp)
    ) {
        Row {
            LazyColumn {
                itemsIndexed(services) { index, item ->
                    ServiceTab(
                        service = item,
                        isTaken = index <= 2,
                        isSelected = index == current
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

        Column(modifier = Modifier.align(BottomCenter).fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                AppText(
                    text = "2 items | ₹502.00",
                    color = Gray900,
                    fontWeight = FontWeight.SemiBold
                )

                AppButton(
                    onClick = {},
                    buttonTitle = "Proceed",
                    backgroundColor = Gray900,
                    titleColor = Gray100,
                    contentPadding = 8.dp
                )
            }
        }
    }
}
