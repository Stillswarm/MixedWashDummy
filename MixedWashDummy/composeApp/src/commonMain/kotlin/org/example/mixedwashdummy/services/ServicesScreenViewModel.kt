package org.example.mixedwashdummy.services

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.example.mixedwashdummy.DummyData

class ServicesScreenViewModel constructor(

) {

    private val initialState = ServicesScreenState(
        services = DummyData.services,
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
        _uiState.update {
            it.copy(
                optedServices = it.optedServices.toMutableSet().apply {
                    if (contains(serviceId)) remove(serviceId) else add(serviceId)
                }
            )
        }

        println(_uiState.value.optedServices.toString())
    }
}