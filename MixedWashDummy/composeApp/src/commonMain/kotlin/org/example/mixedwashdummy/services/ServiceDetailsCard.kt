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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
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
import org.example.mixedwashdummy.Service
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
    service: Service,
    expTime: Int, /* expected time */
    pricing: Int,
    minCart: Int,
    washTempMin: Int,
    washTempMax: Int,
    detergent: String,
    drying: String,
    onSelect: () -> Unit,
    onAdd: () -> Unit,
    onRemove: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.clip(RoundedCornerShape(18.dp)).background(Gray100)
    ) {
        AsyncImageLoader(
            imageUrl = service.imageUrl,
            modifier = Modifier.size(180.dp).align(Alignment.TopEnd).offset(x = 100.dp, y = 50.dp)
        )

        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Column(
                modifier = Modifier.width(181.dp),
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {
                AppText(
                    text = service.title,
                    fontWeight = FontWeight.Medium,
                    fontSize = 24.sp,
                    lineHeight = 31.2.sp
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        imageVector = vectorResource(Res.drawable.ic_history),
                        contentDescription = null
                    )

                    AppText(
                        text = "$expTime hrs",
                        fontSize = 14.sp,
                        lineHeight = 16.8.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                AppText(
                    text = service.description,
                    color = Gray500,
                    fontSize = 14.sp,
                    lineHeight = 16.8.sp,
                )

                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    AppText(
                        text = "pricing",
                        color = Gray500,
                        fontSize = 12.sp,
                        lineHeight = 16.8.sp
                    )

                    AppText(
                        text = "₹$pricing /kg",
                        color = Gray800,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        lineHeight = 16.8.sp
                    )

                    AppText(
                        text = "minimum cart",
                        color = Gray500,
                        fontSize = 12.sp,
                        lineHeight = 16.8.sp
                    )

                    AppText(
                        text = "₹$minCart (4kg)",
                        color = Gray800,
                        fontSize = 14.sp,
                        lineHeight = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Column(modifier = Modifier.width(190.dp)) {
                AppText(
                    text = "your whites and colored items will be washed together and tumble dried",
                    lineHeight = 16.8.sp,
                    fontSize = 12.sp,
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AppOutlinedButton(
                        buttonTitle = "Mixed",
                        onClick = {}, shape = RoundedCornerShape(12.dp),
                        borderColor = Gray800,
                        letterSpacing = (-0.02).sp,
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        lineHeight = 14.sp
                    )

                    AppOutlinedButton(
                        buttonTitle = "Segregated",
                        borderColor = Color.Unspecified,
                        letterSpacing = (-0.02).sp,
                        onClick = {}, shape = RoundedCornerShape(12.dp),
                        contentPadding = PaddingValues(vertical = 10.dp, horizontal = 16.dp),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        lineHeight = 14.sp
                    )
                }
            }

            TextButton(
                onClick = {},
                shape = RoundedCornerShape(6.dp),
                border = BorderStroke(1.dp, Gray800),
                contentPadding = PaddingValues(horizontal = 14.dp, vertical = 8.dp)
            ) {
                Row(
                    modifier = Modifier.padding(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = null,
                        tint = Gray800,
                        modifier = Modifier.size(18.dp)
                    )

                    AppText(
                        text = "Remove Item",
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp
                    )
                }
            }

            Divider(color = dividerBlack, thickness = 1.5.dp)

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
                    "$washTempMin° - $washTempMax°C",
                    detergent,
                    drying
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