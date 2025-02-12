package org.example.mixedwashdummy.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.mixedwashdummy.common.OrderStatusCard
import org.example.mixedwashdummy.theme.Gray100
import org.example.mixedwashdummy.theme.Gray200

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        HomeScreenHeader(
            imageUrl = "...",
            title = "Laundry piling up?",
            description = "Get laundry at your door-step in 24 hours",
            gradientDark = Gray200,
            gradientLight = Gray100,
            buttonTitle = "Order Pickup",
            onButtonClick = {}
        )

        OrderStatusCard(
            orderId = "#1022153",
            title = "Wash and Fold",
            subtitle = "Heavy Wash",
            description = "Your order is currently being washed at our facility",
            onDetailsClick = { },
            imageUrl = "",
        )

        OfferCard(
            details = "Flat 20% OFF with coupon code WELCOME20 on your first order",
            imageUrl = "",
            buttonLabel = "Add to Cart",
            onButtonClick = { }
        )

        ServicesSection(onSeeAll = {})

        GettingStartedSection(
            onExplore = {},
            onCall = {}
        )
    }
}