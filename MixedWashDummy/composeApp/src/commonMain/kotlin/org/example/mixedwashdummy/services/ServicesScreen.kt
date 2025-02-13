package org.example.mixedwashdummy.services

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.mixedwashdummy.common.AppButton
import org.example.mixedwashdummy.util.edgePadding

@Composable
fun ServicesScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize()
            .edgePadding(extraHorizontal = 16.dp, extraVertical = 16.dp)
    ) {
        Row {
            Column {
                for (i in (1..5)) {
                    ServiceTab(
                        title = "Wash & Fold",
                        imageUrl = "sku_shoe_clean",
                        isTaken = i <= 2,
                        isSelected = i == 2
                    )
                }
            }

            ServiceDetailsCard(
                serviceTitle = "Wash & Fold",
                serviceDescription = "best for shirts, t-shirts, trousers, inner-wears & regular daily wears",
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

        AppButton(onClick = {}, buttonTitle = "Proceed", modifier = Modifier.align(Alignment.BottomEnd))
    }
}
