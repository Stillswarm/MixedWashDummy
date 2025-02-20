package org.example.mixedwashdummy

import androidx.compose.ui.graphics.Color
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
    val services = listOf(
        Service("Wash & Iron", "best for shirts, t-shirts, trousers, inner-wears & regular daily wears", "sku_wash_and_iron"),
        Service("Wash & Fold", "best for shirts, t-shirts, trousers, inner-wears & regular daily wears", "sku_wash_and_fold"),
        Service("Dry Clean", "best for shirts, t-shirts, trousers, inner-wears & regular daily wears", "sku_dry_clean"),
        Service("Heavy Wash", "best for shirts, t-shirts, trousers, inner-wears & regular daily wears", "sku_heavy_wash"),
        Service("Shoe Clean", "best for shirts, t-shirts, trousers, inner-wears & regular daily wears", "sku_shoe_clean"),
    )

    val headerData = listOf(
        HomeHeaderData("Washing bed sheets got you scared?", "sheet_ghost", "Don't worry, we have trained experts for that sort of thing", "Help me!", Gray500, Gray700, Gray900),
        HomeHeaderData("Laundry piling up?", "basket_overflow_white", "Get laundry at your door-step in 24 hours", "Order Pickup", Gray700, Color(0xFFEFEFEB), Color(0xFFF3F3F3)),
        HomeHeaderData("Sofas are meant to be sat on...", "sofa_clothes", "We'll return your laundry clean & fresh within 24 hours", "Order Pickup", Color(0xFF4D5888), Color(0xFFE8EBF9), Color(0xFFCBD0F6)),
        HomeHeaderData("18°C | Rainy", "cloud_clohtes_line", "the rain won't stop? neither should your laundry", "Order Pickup", Color(0xFFD1E2EE), Color(0xFFA8B5C0), Color(0xFF5E6F7C)),
        HomeHeaderData("Waiting for laundry?", "man_alarm_clock", "Never again! Get same-day laundry with free delivery","Order Pickup", Gray400, Gray600, Gray900, 2),
    )

    val insightMetrics = listOf(
        InsightMetric("time saved", "hrs", Res.drawable.ic_hourglass),
        InsightMetric("washed", "kgs", Res.drawable.ic_washing_machine),
        InsightMetric("water saved", "ltr", Res.drawable.ic_water_drop),
    )

    val onboardingData = listOf(
        OnboardingData("Fresh clothes, just a few clicks away", "Say goodbye to laundry day stress. Book, track, and relax!", Res.drawable.onboarding_image1),
        OnboardingData("24-Hour Turnaround", "We value your time. Fresh, clean clothes delivered to your doorstep within 24 hours.", Res.drawable.onboarding_image2),
        OnboardingData("Pickup and Delivery at Your Doorstep", "Schedule a pickup and we'll handle the rest. Clean clothes delivered, hassle-free", Res.drawable.onboarding_image3),
    )
}

data class Service(
    val title: String,
    val description: String,
    val imageUrl: String,
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