package org.example.mixedwashdummy.services

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.example.mixedwashdummy.DummyData

class ServicesScreenViewModel constructor(

) {

    private val initialState = ServicesScreenState(
        serviceItems = DummyData.services,
        currentService = 0,
        optedServices = mutableSetOf(),
        totalCost = 0,
    )

    private var _uiState = MutableStateFlow<ServicesScreenState>(initialState)
    val uiState: StateFlow<ServicesScreenState> = _uiState.asStateFlow()

    fun onEvent(event: ServicesScreenEvent) {
        when (event) {
            is ServicesScreenEvent.ToggleCurrentService -> {
                toggleCurrentService(event.newService)
            }

            ServicesScreenEvent.ToggleMixedMode -> {
                toggleMixedMode()
            }

            is ServicesScreenEvent.ToggleOptedService -> {
                toggleOptedServices(event.serviceId)
            }
        }
    }

    private fun toggleCurrentService(newServiceId: Int) {
        _uiState.update {
            it.copy(currentService = newServiceId, mixedMode = true)
        }
    }

    private fun toggleMixedMode() {
        _uiState.update {
            it.copy(mixedMode = !it.mixedMode)
        }
    }

    private fun toggleOptedServices(serviceId: Int) {
        var removed = false
        _uiState.update {
            it.copy(
                optedServices = it.optedServices.toMutableSet().apply {
                    if (contains(serviceId)) {
                        remove(serviceId)
                        removed = true
                    } else {
                        add(serviceId)
                    }
                }
            )
        }

        var cost = 0
        val item = _uiState.value.serviceItems[serviceId]
        if (item.pricePerKg != null) {
            cost = item.pricePerKg * (if (_uiState.value.mixedMode) item.minCartMixedInKg ?: 1 else item.minCartSegregatedInKg ?: 1)
        } else if (item.pricePerPair != null) {
            cost = item.pricePerPair
        }

        if (removed) cost *= -1
        updateCost(cost)
    }

    // the parameter add can be positive or negative depending on whether
    // the item is being added or removed
    private fun updateCost(add: Int) {
        _uiState.update {
            it.copy(totalCost = it.totalCost + add)
        }
    }
}