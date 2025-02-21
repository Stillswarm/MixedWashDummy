package org.example.mixedwashdummy.history

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.example.mixedwashdummy.DummyData

class OrderHistoryViewModel {

    private val initialState = OrderHistoryState(
        orders = DummyData.orderHistoryMock,
        insights = DummyData.insightMetrics
    )

    private var _uiState = MutableStateFlow<OrderHistoryState>(initialState)
    val uiState: StateFlow<OrderHistoryState> = _uiState.asStateFlow()

    fun onEvent(orderHistoryEvent: OrderHistoryEvent) {

    }
}