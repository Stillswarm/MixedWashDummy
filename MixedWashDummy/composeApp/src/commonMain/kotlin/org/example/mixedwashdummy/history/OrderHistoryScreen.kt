package org.example.mixedwashdummy.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import mixedwashdummy.composeapp.generated.resources.Res
import mixedwashdummy.composeapp.generated.resources.hangar_order_icon
import mixedwashdummy.composeapp.generated.resources.insights_icon
import org.example.mixedwashdummy.InsightMetric
import org.example.mixedwashdummy.common.TitleWithIcon
import org.example.mixedwashdummy.theme.dividerBlack
import org.example.mixedwashdummy.util.edgePadding

@Composable
fun OrderHistoryScreen(insightMetrics: List<InsightMetric>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize().edgePadding().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            TitleWithIcon(title = "Insights", icon = Res.drawable.insights_icon)
        }

        item {
            LazyRow {
                items(insightMetrics) {
                    StatisticCard(
                        value = 29,
                        metric = it.metric,
                        unit = it.unit,
                        icon = it.icon,
                        modifier = Modifier.padding((8.dp)),
                    )

                }
            }
        }

        item {
            TitleWithIcon(title = "Orders", icon = Res.drawable.hangar_order_icon)
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