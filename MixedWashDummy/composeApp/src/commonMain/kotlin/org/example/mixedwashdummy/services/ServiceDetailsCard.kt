package org.example.mixedwashdummy.services

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mixedwashdummy.composeapp.generated.resources.Res
import mixedwashdummy.composeapp.generated.resources.ic_history
import org.example.mixedwashdummy.ServiceItem
import org.example.mixedwashdummy.common.AppOutlinedButton
import org.example.mixedwashdummy.common.AppText
import org.example.mixedwashdummy.common.AsyncImageLoader
import org.example.mixedwashdummy.theme.Gray100
import org.example.mixedwashdummy.theme.Gray50
import org.example.mixedwashdummy.theme.Gray500
import org.example.mixedwashdummy.theme.Gray800
import org.example.mixedwashdummy.theme.dividerBlack
import org.jetbrains.compose.resources.vectorResource


@Composable
fun ServiceDetailsCard(
    serviceItem: ServiceItem,
    onEvent: (ServicesScreenEvent) -> Unit,
    mixedMode: Boolean,
    modifier: Modifier = Modifier,
    isOpted: Boolean,
) {
    Box(
        modifier = modifier.clip(RoundedCornerShape(18.dp)).background(Gray100)
    ) {

        // side image
        AsyncImageLoader(
            imageUrl = serviceItem.imageUrl,
            modifier = Modifier.size(180.dp).align(Alignment.TopEnd).offset(x = 100.dp, y = 50.dp)
        )

        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 32.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column(
                modifier = Modifier.width(181.dp),
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {

                // title
                AppText(
                    text = serviceItem.title,
                    fontWeight = FontWeight.Medium,
                    fontSize = 24.sp,
                    lineHeight = 31.2.sp
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    // duration
                    Icon(
                        imageVector = vectorResource(Res.drawable.ic_history),
                        contentDescription = null
                    )

                    AppText(
                        text = "${serviceItem.deliveryTimeMinInHrs} hrs",
                        fontSize = 14.sp,
                        lineHeight = 16.8.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                // description
                AppText(
                    text = serviceItem.description,
                    color = Gray500,
                    fontSize = 14.sp,
                    lineHeight = 16.8.sp,
                )

                // pricing
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    AppText(
                        text = "pricing",
                        color = Gray500,
                        fontSize = 12.sp,
                        lineHeight = 16.8.sp
                    )

                    // price per pair

                    if (serviceItem.pricePerPair != null) {
                        AppText(
                            text = "₹${serviceItem.pricePerPair} /pair",
                            color = Gray800,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            lineHeight = 16.8.sp
                        )
                    }

                    // price per kg
                    if (serviceItem.pricePerKg != null) {
                        AppText(
                            text = "₹${serviceItem.pricePerKg} /kg",
                            color = Gray800,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            lineHeight = 16.8.sp
                        )
                    }

                    if (serviceItem.minCartMixedInKg != null) {
                        AppText(
                            text = "minimum cart",
                            color = Gray500,
                            fontSize = 12.sp,
                            lineHeight = 16.8.sp
                        )

                        AppText(
                            text = "₹${
                                    if (mixedMode) serviceItem.minCartMixedInKg.times((serviceItem.pricePerKg ?: 1)) 
                                    else serviceItem.minCartSegregatedInKg?.times((serviceItem.pricePerKg ?: 1))} " +
                                    "(${if (mixedMode) serviceItem.minCartMixedInKg else serviceItem.minCartSegregatedInKg}kg)",
                            color = Gray800,
                            fontSize = 14.sp,
                            lineHeight = 14.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }

            // mixed and segregated
            if (serviceItem.minCartMixedInKg != null) {
                Column(modifier = Modifier.width(200.dp)) {
                    AppText(
                        text = if (mixedMode) "your whites and colored items will be washed together and tumble dried"
                        else "your whites & colored clothes are segregated and washed separately",
                        lineHeight = 16.8.sp,
                        fontSize = 12.sp,
                    )


                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        AppOutlinedButton(
                            buttonTitle = "Mixed",
                            onClick = { onEvent(ServicesScreenEvent.ToggleMixedMode) },
                            shape = RoundedCornerShape(12.dp),
                            borderColor = if (mixedMode) Gray800 else Color.Unspecified,
                            letterSpacing = (-0.02).sp,
                            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            lineHeight = 14.sp
                        )

                        AppOutlinedButton(
                            buttonTitle = "Segregated",
                            borderColor = if (!mixedMode) Gray800 else Color.Unspecified,
                            letterSpacing = (-0.02).sp,
                            onClick = { onEvent(ServicesScreenEvent.ToggleMixedMode) },
                            shape = RoundedCornerShape(12.dp),
                            contentPadding = PaddingValues(vertical = 10.dp, horizontal = 16.dp),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            lineHeight = 14.sp
                        )
                    }
                }
            }

            // add / remove
            Button(
                onClick = { onEvent(ServicesScreenEvent.ToggleOptedService(serviceItem.id)) },
                shape = RoundedCornerShape(6.dp),
                border = BorderStroke(1.dp, Gray800),
                colors = ButtonDefaults.buttonColors(backgroundColor = if (isOpted) Gray50 else Gray800),
                contentPadding = PaddingValues(horizontal = 14.dp, vertical = 8.dp)
            ) {
                Row(
                    modifier = Modifier.background(if (!isOpted) Gray800 else Color.Unspecified)
                        .padding(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        imageVector = if (isOpted) Icons.Outlined.Delete else Icons.Default.Add,
                        contentDescription = null,
                        tint = if (isOpted) Gray800 else Gray100,
                        modifier = Modifier.size(18.dp)
                    )

                    Text(
                        text = if (isOpted) "Remove Item" else "Add Item",
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp,
                        color = if (isOpted) Gray800 else Gray100
                    )
                }
            }

            Divider(color = dividerBlack, thickness = 1.5.dp)

            // details
            AppText(
                text = "Details",
                fontWeight = FontWeight.Medium,
                lineHeight = 24.sp,
                fontSize = 16.sp,
                color = Gray500
            )

            DetailsList(
                keys = listOf("Delivery time", "Wash temperature", "Detergent", "Drying"),
                values = listOf(
                    "24 hrs",
                    "30° - 35°C",
                    "Eco Friendly",
                    "Tumble Dry"
                )
            )
        }

        Box(
            modifier = Modifier.height(52.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Gray50,
                        )
                    )
                )
        )
    }
}

@Composable
fun DetailsList(keys: List<String>, values: List<String>) {
    val data = keys zip values
    Column(modifier = Modifier.fillMaxWidth()) {
        for ((key, value) in data) {
            Column {
                DetailParameter(key = key, value = value)

                Divider(color = dividerBlack, thickness = 1.5.dp)
            }
        }
    }
}

@Composable
fun DetailParameter(key: String, value: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth().padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AppText(
            text = key,
            color = Gray800,
            fontSize = 12.sp,
            lineHeight = 16.sp
        )

        AppText(
            text = value,
            color = Gray800,
            style = MaterialTheme.typography.subtitle1,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}