package org.example.mixedwashdummy

import androidx.compose.ui.graphics.Color
import mixedwashdummy.composeapp.generated.resources.Res
import mixedwashdummy.composeapp.generated.resources.ic_hourglass
import mixedwashdummy.composeapp.generated.resources.ic_washing_machine
import mixedwashdummy.composeapp.generated.resources.ic_water_drop
import mixedwashdummy.composeapp.generated.resources.onboarding_image1
import mixedwashdummy.composeapp.generated.resources.onboarding_image2
import mixedwashdummy.composeapp.generated.resources.onboarding_image3
import org.example.mixedwashdummy.models.HomeHeaderData
import org.example.mixedwashdummy.models.InsightMetric
import org.example.mixedwashdummy.models.OrderHistoryData
import org.example.mixedwashdummy.models.ServiceItem
import org.example.mixedwashdummy.models.ServiceVariant
import org.example.mixedwashdummy.models.ServiceVariantName
import org.example.mixedwashdummy.ui.theme.Gray400
import org.example.mixedwashdummy.ui.theme.Gray500
import org.example.mixedwashdummy.ui.theme.Gray600
import org.example.mixedwashdummy.ui.theme.Gray700
import org.example.mixedwashdummy.ui.theme.Gray900
import org.jetbrains.compose.resources.DrawableResource

object DummyData {

    val mixedWashAndFoldItem = ServiceVariant(
        variantName = ServiceVariantName.Mixed,
        description = "your whites and colored items will be washed together and tumble dried",
        minCart = 4
    )

    val mixedWashAndIronItem = ServiceVariant(
        variantName = ServiceVariantName.Mixed,
        description = "your whites and colored items will be washed together and tumble dried",
        minCart = 3,
    )

    val segregatedWashAndFoldItem = ServiceVariant(
        variantName = ServiceVariantName.Segregated,
        description = "your whites and colored clothes are segregated and washed separately",
        minCart = 8
    )

    val segregatedWashAndIronItem = ServiceVariant(
        variantName = ServiceVariantName.Segregated,
        description = "your whites and colored clothes are segregated and washed separately",
        minCart = 6
    )

    val washAndIronServiceItem = ServiceItem(
        id = 0,
        title = "Wash & Iron",
        description = "best for shirts, t-shirts, trousers, and office wears",
        imageUrl = "sku_wash_and_iron",
        inclusions = "You could include everyday laundry items like shirts, trousers, t-shirts, leggings, regular wear kurtis and other items which can be machine washed and tumble dried.",
        exclusions = "blazers, doormats, sarees, blouses, shoes, chappals, heavily embroidered items, blankets and other bulky items. Also, do not include DRY CLEAN ONLY items and items that are not suitable for tumble dryer.",
        deliveryTimeMinInHrs = 24,
        deliveryTimeMaxInHrs = 24,
        unit = "kg",
        variants = listOf(mixedWashAndIronItem, segregatedWashAndIronItem),
        pricing = 105f,
    )

    val washAndFoldServiceItem = ServiceItem(
        id = 1,
        title = "Wash & Fold",
        description = "best for shirts, t-shirts, trousers, inner-wears & regular daily wears",
        imageUrl = "sku_wash_and_fold",
        inclusions = "You could include everyday laundry items like Shirts, Trousers, T-Shirts, Innerwear, Leggings, Regular wear kurtis and other items which can be machine washed and tumble dried. Apart from regular clothes you could also include a Bedsheet and 2-3 pillow covers in a 4 kg load",
        exclusions = "Blazers, Doormats, Sarees, Blouses, shoes, chappals, heavily embroidered items, blankets and other bulky items. Also, do not include DRY CLEAN ONLY items and items that are not suitable for tumble dryer.",
        deliveryTimeMinInHrs = 24,
        deliveryTimeMaxInHrs = 24,
        variants = listOf(mixedWashAndFoldItem, segregatedWashAndFoldItem),
        unit = "kg",
        pricing = 95f
    )

    val dryClean = ServiceItem(
        id = 2,
        title = "Dry Clean",
        description = "best for stained items and delicate garments",
        imageUrl = "sku_dry_clean",
        inclusions = "todo",
        exclusions = "todo",
        deliveryTimeMinInHrs = 24,
        deliveryTimeMaxInHrs = 48,
        cartItems = listOf(),
        unit = "kg",
    )

    val heavyWash = ServiceItem(
        id = 3,
        title = "Heavy Wash",
        description = "best for blankets, towels, bedsheets & fabric mats",
        imageUrl = "sku_heavy_wash",
        inclusions = "Bed Sheets, Blankets, Pillow Covers, Towels, Curtains and other bulky items.",
        exclusions = "Blazers, Doormats, Sarees, Blouses, shoes, chappals, heavily embroidered items. Also, do not include DRY CLEAN ONLY items and items that are not suitable for tumble dryer.",
        deliveryTimeMinInHrs = 24,
        deliveryTimeMaxInHrs = 48,
        unit = "kg",
        pricing = 140f
    )

    val shoeCleanServiceItem = ServiceItem(
        id = 4,
        title = "Shoe Clean",
        description = "best for sneakers, sports and casual shoes",
        imageUrl = "sku_shoe_clean",
        inclusions = "Sneakers, Loafers, Sandals, Flip flops and Sports Shoes",
        exclusions = "Any leather footwear",
        deliveryTimeMinInHrs = 72,
        deliveryTimeMaxInHrs = 72,
        pricing = 350f,
        unit = "pair"
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
            serviceItems = listOf(
                washAndIronServiceItem,
                dryClean,
                heavyWash,
                washAndFoldServiceItem
            ),
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

/*
    fix colors and card in services ui ✔
    should contain List<cartItems> -> specifics, -> gender
    screen sends the cartItem id -> viewmodel checks which service it belongs to
    data class OnCartItemSelected(val cartItemId: Int, val isAdded: Boolean) // find better names

    use float for prices

    parameters from the details section go in the schema

    variant
    pricing goes into its own object
    edge cases
    offer
    imageUrl param should get the whole url
    dry cleaning

    OrderHistoryScreen
    state should be represented as an enum

    derived state

    ----------------------

    1. diff data type for prices not required, as price is bundles with the "CartItem" object
    we only require the unit type (kg/pair),

    2. what are the cartItems for heavy wash and shoe clean??
 */


data class OnboardingData(
    val title: String,
    val subtitle: String,
    val imageResource: DrawableResource
)