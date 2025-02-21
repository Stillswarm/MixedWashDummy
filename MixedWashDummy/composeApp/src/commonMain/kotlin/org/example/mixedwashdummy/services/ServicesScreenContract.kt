package org.example.mixedwashdummy.services

import org.example.mixedwashdummy.Service

data class ServicesScreenState(
    val services: List<Service>,
    val currentService: Int,
    val optedServices: MutableSet<Int>,
    val mixedMode: Boolean = true,  // whether mixed mode is currently shown (the other possible mode is segregated)
    val totalCost: Int,
)

sealed interface ServicesScreenEvent {
    data class ToggleCurrentService(val newService: Int) : ServicesScreenEvent
    data object ToggleMixedMode : ServicesScreenEvent
    data class ToggleOptedService(val serviceId: Int) : ServicesScreenEvent
}

sealed interface ServicesScreenUiEvent {

}