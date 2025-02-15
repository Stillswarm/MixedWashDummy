package org.example.mixedwashdummy.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.mixedwashdummy.DummyData
import org.example.mixedwashdummy.common.OrderStatusCard
import org.example.mixedwashdummy.util.edgePadding

/**
 * Notes:
 * 1. statusBarsPadding and navigationBarsPadding are used to prevent content from overlapping the
 *      systemUI in edge-to-edge
 * 2. the padding values aren't applied to the screen itself as the header color gradient must
 *    fill the entire width and all the height above it.
 * 3. the padding values are separately applied to each of the home screen components
 *      (Are there better ways of doing this?)
 */

val edgePadding = Modifier.edgePadding(extraHorizontal = 16.dp)

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        HomeScreenHeader(
            headerData = DummyData.headerData,
            onButtonClick = {},
        )

        OrderStatusCard(
            orderId = "#1022153",
            title = "Wash & Fold",
            subtitle = "Heavy Wash",
            description = "Your order is currently being washed at our facility",
            onDetailsClick = { },
            imageUrl = "silver_washing_machine",
            modifier = edgePadding
        )

        OfferCard(
            details = "Flat 20% OFF with coupon code WELCOME20 on your first order",
            imageUrl = "basket_overflow_black",
            buttonLabel = "Add to Cart",
            onButtonClick = { },
            modifier = edgePadding
        )

        // TODO: Replace Dummy with actual
        ServicesSection(services = DummyData.services, onSeeAll = {}, modifier = Modifier.edgePadding(extraHorizontal = 16.dp))

        GettingStartedSection(
            onExplore = {},
            onCall = {},
            modifier = edgePadding
        )
    }
}