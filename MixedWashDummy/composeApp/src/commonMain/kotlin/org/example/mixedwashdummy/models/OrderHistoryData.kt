package org.example.mixedwashdummy.models

import org.jetbrains.compose.resources.DrawableResource

data class OrderHistoryData(
    val orderId: Long,
    val serviceItems: List<ServiceItem>,
    val orderedTimestamp: Long,
    val deliveryTimestamp: Long?,   // null if the order was cancelled
    val orderDeliveryStatus: OrderDeliveryStatus,
    val price: Int,
)

data class InsightMetric(
    val metric: String,
    val unit: String,
    val icon: DrawableResource
)
