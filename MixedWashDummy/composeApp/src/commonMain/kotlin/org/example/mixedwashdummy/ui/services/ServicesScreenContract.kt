package org.example.mixedwashdummy.ui.services

import org.example.mixedwashdummy.models.ServiceItem
import org.example.mixedwashdummy.models.ServiceVariantName

// use an enum for variant
data class ServicesScreenState(
    val serviceItems: List<ServiceItem>,
    val currentServiceId: Int,
    val selectedServices: List<Int>,
    val currentVariantName: ServiceVariantName?,
    val cartEntries: List<CartEntry>,
    val totalCost: Float,
) {
    val currentVariant = serviceItems[currentServiceId].variants?.find { it.variantName == currentVariantName }
    val minCartPrice = serviceItems[currentServiceId].pricing?.times(currentVariant?.minCart ?: 1)
}

sealed interface ServicesScreenEvent {
    data class ToggleCurrentService(val newService: Int) : ServicesScreenEvent
    data class ToggleCurrentVariant(val newVariantName: ServiceVariantName) : ServicesScreenEvent
    data class UpdateCartEntry(val cartEntry: CartEntry) : ServicesScreenEvent
}

sealed interface ServicesScreenUiEvent {

}

data class CartEntry(
    val serviceId: Int,
    val name: String,
    val price: Float,
)