package org.example.mixedwashdummy

import androidx.compose.ui.graphics.Color
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import mixedwashdummy.composeapp.generated.resources.Res
import mixedwashdummy.composeapp.generated.resources.ic_hourglass
import mixedwashdummy.composeapp.generated.resources.ic_washing_machine
import mixedwashdummy.composeapp.generated.resources.ic_water_drop
import mixedwashdummy.composeapp.generated.resources.onboarding_image1
import mixedwashdummy.composeapp.generated.resources.onboarding_image2
import mixedwashdummy.composeapp.generated.resources.onboarding_image3
import org.example.mixedwashdummy.theme.Gray400
import org.example.mixedwashdummy.theme.Gray500
import org.example.mixedwashdummy.theme.Gray600
import org.example.mixedwashdummy.theme.Gray700
import org.example.mixedwashdummy.theme.Gray900
import org.jetbrains.compose.resources.DrawableResource

object DummyData {
    val washAndIronServiceItem = ServiceItem(
        id = 0,
        title = "Wash & Iron",
        description = "best for shirts, t-shirts, trousers, and office wears",
        imageUrl = "sku_wash_and_iron",
        minCartMixedInKg = 3,
        minCartSegregatedInKg = 6,
        pricePerKg = 150,
        inclusions = "You could include everyday laundry items like shirts, trousers, t-shirts, leggings, regular wear kurtis and other items which can be machine washed and tumble dried.",
        exclusions = "blazers, doormats, sarees, blouses, shoes, chappals, heavily embroidered items, blankets and other bulky items. Also, do not include DRY CLEAN ONLY items and items that are not suitable for tumble dryer.",
        deliveryTimeMinInHrs = 24,
        deliveryTimeMaxInHrs = 24
    )

    val washAndFoldServiceItem = ServiceItem(
        id = 1,
        title = "Wash & Fold",
        description = "best for shirts, t-shirts, trousers, inner-wears & regular daily wears",
        imageUrl = "sku_wash_and_fold",
        minCartMixedInKg = 4,
        minCartSegregatedInKg = 8,
        pricePerKg = 95,
        inclusions = "You could include everyday laundry items like Shirts, Trousers, T-Shirts, Innerwear, Leggings, Regular wear kurtis and other items which can be machine washed and tumble dried. Apart from regular clothes you could also include a Bedsheet and 2-3 pillow covers in a 4 kg load",
        exclusions = "Blazers, Doormats, Sarees, Blouses, shoes, chappals, heavily embroidered items, blankets and other bulky items. Also, do not include DRY CLEAN ONLY items and items that are not suitable for tumble dryer.",
        deliveryTimeMinInHrs = 24,
        deliveryTimeMaxInHrs = 24
    )

    val dryClean = ServiceItem(
        id = 2,
        title = "Dry Clean",
        description = "best for stained items and delicate garments",
        imageUrl = "sku_dry_clean",
        minCartMixedInKg = null,
        minCartSegregatedInKg = null,
        pricePerKg = 100,
        inclusions = "todo",
        exclusions = "todo",
        deliveryTimeMinInHrs = 24,
        deliveryTimeMaxInHrs = 48
    )

    val heavyWash = ServiceItem(
        id = 3,
        title = "Heavy Wash",
        description = "best for blankets, towels, bedsheets & fabric mats",
        imageUrl = "sku_heavy_wash",
        minCartMixedInKg = 4,
        minCartSegregatedInKg = 8,
        pricePerKg = 140,
        inclusions = "Bed Sheets, Blankets, Pillow Covers, Towels, Curtains and other bulky items.",
        exclusions = "Blazers, Doormats, Sarees, Blouses, shoes, chappals, heavily embroidered items. Also, do not include DRY CLEAN ONLY items and items that are not suitable for tumble dryer.",
        deliveryTimeMinInHrs = 24,
        deliveryTimeMaxInHrs = 48
    )

    val shoeCleanServiceItem = ServiceItem(
        id = 4,
        title = "Shoe Clean",
        description = "best for sneakers, sports and casual shoes",
        imageUrl = "sku_shoe_clean",
        minCartMixedInKg = null,
        minCartSegregatedInKg = null,
        pricePerPair = 350,
        pricePerKg = null,
        inclusions = "Sneakers, Loafers, Sandals, Flip flops and Sports Shoes",
        exclusions = "Any leather footwear",
        deliveryTimeMinInHrs = 72,
        deliveryTimeMaxInHrs = 72
    )

    val services = listOf(
        washAndIronServiceItem,
        washAndFoldServiceItem,
        dryClean,
        heavyWash,
        shoeCleanServiceItem,
    )

    val headerData = listOf(
        HomeHeaderData(
            "Washing bed sheets got you scared?",
            "sheet_ghost",
            "Don't worry, we have trained experts for that sort of thing",
            "Help me!",
            Gray500,
            Gray700,
            Gray900
        ),
        HomeHeaderData(
            "Laundry piling up?",
            "basket_overflow_white",
            "Get laundry at your door-step in 24 hours",
            "Order Pickup",
            Gray700,
            Color(0xFFEFEFEB),
            Color(0xFFF3F3F3)
        ),
        HomeHeaderData(
            "Sofas are meant to be sat on...",
            "sofa_clothes",
            "We'll return your laundry clean & fresh within 24 hours",
            "Order Pickup",
            Color(0xFF4D5888),
            Color(0xFFE8EBF9),
            Color(0xFFCBD0F6)
        ),
        HomeHeaderData(
            "18°C | Rainy",
            "cloud_clohtes_line",
            "the rain won't stop? neither should your laundry",
            "Order Pickup",
            Color(0xFFD1E2EE),
            Color(0xFFA8B5C0),
            Color(0xFF5E6F7C)
        ),
        HomeHeaderData(
            "Waiting for laundry?",
            "man_alarm_clock",
            "Never again! Get same-day laundry with free delivery",
            "Order Pickup",
            Gray400,
            Gray600,
            Gray900,
            2
        ),
    )

    val insightMetrics = listOf(
        InsightMetric("time saved", "hrs", Res.drawable.ic_hourglass),
        InsightMetric("washed", "kgs", Res.drawable.ic_washing_machine),
        InsightMetric("water saved", "ltr", Res.drawable.ic_water_drop),
    )

    val onboardingData = listOf(
        OnboardingData(
            "Fresh clothes, just a few clicks away",
            "Say goodbye to laundry day stress. Book, track, and relax!",
            Res.drawable.onboarding_image1
        ),
        OnboardingData(
            "24-Hour Turnaround",
            "We value your time. Fresh, clean clothes delivered to your doorstep within 24 hours.",
            Res.drawable.onboarding_image2
        ),
        OnboardingData(
            "Pickup and Delivery at Your Doorstep",
            "Schedule a pickup and we'll handle the rest. Clean clothes delivered, hassle-free",
            Res.drawable.onboarding_image3
        ),
    )

    val orderHistoryMock = listOf(
        OrderHistoryData(
            orderId = 1022154,
            serviceItems = listOf(washAndFoldServiceItem, dryClean, shoeCleanServiceItem),
            orderedTimestamp = 1708464000000L,
            deliveryTimestamp = 1708464000000L,
            price = 1024
        ),
        OrderHistoryData(
            orderId = 1024298,
            serviceItems = listOf(washAndIronServiceItem, dryClean, heavyWash, washAndFoldServiceItem),
            orderedTimestamp = 1708464000000L,
            deliveryTimestamp = null,
            price = 2048
        ),
        OrderHistoryData(
            orderId = 1000245,
            serviceItems = listOf(washAndFoldServiceItem),
            orderedTimestamp = 1708464000000L,
            deliveryTimestamp = 1808464000000L,
            price = 1024
        ),
    )
}

@Serializable
data class ServiceItem(
    val id: Int,
    val title: String,
    val description: String,
    @SerialName("image_url")
    val imageUrl: String,
    @SerialName("min_cart_mixed_kg")
    val minCartMixedInKg: Int?,
    @SerialName("min_cart_segregated_kg")
    val minCartSegregatedInKg: Int?,
    @SerialName("price_per_pair")
    val pricePerPair: Int? = null,
    @SerialName("price_per_kg")
    val pricePerKg: Int?,
    val inclusions: String,
    val exclusions: String,
    @SerialName("delivery_time_min_hrs")
    val deliveryTimeMinInHrs: Int,
    @SerialName("delivery_time_max_hrs")
    val deliveryTimeMaxInHrs: Int,
)

data class HomeHeaderData(
    val heading: String,
    val imageUrl: String,
    val description: String,
    val buttonText: String,
    val textColor: Color,
    val gradientLight: Color,
    val gradientDark: Color,
    val gradientOrder: Int = 1, /* 1 for light-dark, 2 for dark-light */
)

data class InsightMetric(
    val metric: String,
    val unit: String,
    val icon: DrawableResource
)

data class OnboardingData(
    val title: String,
    val subtitle: String,
    val imageResource: DrawableResource
)

// order status is determined from whether the delivery timestamp is past, future or null
data class OrderHistoryData(
    val orderId: Long,
    val serviceItems: List<ServiceItem>,
    val orderedTimestamp: Long,
    val deliveryTimestamp: Long?,   // null if the order was cancelled
    val price: Int,
)