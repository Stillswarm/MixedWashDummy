package org.example.mixedwashdummy.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.mixedwashdummy.common.TitleWithIcon
import org.example.mixedwashdummy.theme.dividerBlack
import org.example.mixedwashdummy.util.edgePadding

@Composable
fun OrderHistoryScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize().edgePadding().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            TitleWithIcon(title = "Insights")
        }

        item {
            LazyRow {
                items(10) {
                    StatisticCard(
                        value = 29,
                        metric = "time saved",
                        unit = "hrs",
                        modifier = Modifier.padding((8.dp)),
                    )

                }
            }
        }

        item {
            TitleWithIcon(title = "Orders")
        }

        items(10) {
            Column {
                /*
                    the status currently takes a random value between [0, 2]
                 */
                OrderSummaryCard(
                    orderId = "1022154",
                    title1 = "Wash & Fold",
                    title2 = "Dry Cleaning",
                    title3 = "Shoe Wash",
                    status = (0..2).random(),
                    cost = 1024,
                    onDetails = {},
                )

                Spacer(Modifier.height(12.dp))

                Divider(color = dividerBlack)

                Spacer(Modifier.height(12.dp))
            }


        }
    }
}