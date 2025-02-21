package org.example.mixedwashdummy.history

import org.example.mixedwashdummy.InsightMetric
import org.example.mixedwashdummy.OrderHistoryData

data class OrderHistoryState(
    val orders: List<OrderHistoryData>,
    val insights: List<InsightMetric>,
)

sealed interface OrderHistoryEvent {

}