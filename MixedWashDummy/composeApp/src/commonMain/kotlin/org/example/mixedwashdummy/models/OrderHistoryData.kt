package org.example.mixedwashdummy.models

import org.jetbrains.compose.resources.DrawableResource

// TODO: timestamp
data class OrderHistoryData(
    val orderId: Long,
    val serviceItems: List<ServiceItem>,
    val orderedTimestamp: Long,
    val deliveryTimestamp: Long?,   // null if the order was cancelled
    val price: Int,
)

data class InsightMetric(
    val metric: String,
    val unit: String,
    val icon: DrawableResource
)
