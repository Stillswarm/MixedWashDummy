package org.example.mixedwashdummy.ui.history

import org.example.mixedwashdummy.models.InsightMetric
import org.example.mixedwashdummy.models.OrderHistoryData

data class OrderHistoryState(
    val orders: List<OrderHistoryData>,
    val insights: List<InsightMetric>,
)

sealed interface OrderHistoryEvent {

}