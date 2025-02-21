package org.example.mixedwashdummy.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.datetime.Clock
import mixedwashdummy.composeapp.generated.resources.Res
import mixedwashdummy.composeapp.generated.resources.hangar_order_icon
import mixedwashdummy.composeapp.generated.resources.insights_icon
import org.example.mixedwashdummy.common.TitleWithIcon
import org.example.mixedwashdummy.theme.dividerBlack
import org.example.mixedwashdummy.util.DateTimeUtils

@Composable
fun OrderHistoryScreen(state: OrderHistoryState, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            TitleWithIcon(title = "Insights", icon = Res.drawable.insights_icon)
        }

        item {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                items(state.insights) {
                    StatisticCard(
                        value = 29,
                        metric = it.metric,
                        unit = it.unit,
                        icon = it.icon,
                    )

                }
            }
        }

        item {
            TitleWithIcon(title = "Orders", icon = Res.drawable.hangar_order_icon)
        }

        items(state.orders) { order ->
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                OrderSummaryCard(
                    orderId = order.orderId,
                    titles = order.serviceItems.map { it.title },
                    ordered = DateTimeUtils.formatTimestamp(order.orderedTimestamp),
                    delivery = if (order.deliveryTimestamp != null) DateTimeUtils.formatTimestamp(
                        order.deliveryTimestamp
                    ) else null,
                    status = if (order.deliveryTimestamp == null) 2
                                else if (order.deliveryTimestamp > Clock.System.now().toEpochMilliseconds()) 0
                                else 1,
                    cost = order.price,
                    onDetails = {},
                )

                Divider(color = dividerBlack)
            }
        }
    }
}