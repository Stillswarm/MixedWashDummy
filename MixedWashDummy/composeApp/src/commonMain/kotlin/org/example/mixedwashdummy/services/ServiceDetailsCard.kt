package org.example.mixedwashdummy.services

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.example.mixedwashdummy.Service
import org.example.mixedwashdummy.common.AppText
import org.example.mixedwashdummy.theme.Gray100
import org.example.mixedwashdummy.theme.Gray500
import org.example.mixedwashdummy.theme.Gray800
import org.example.mixedwashdummy.theme.dividerBlack

@OptIn(ExperimentalMaterialApi::class)
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
    Card(
        modifier = modifier.fillMaxWidth().offset(x = 28.dp),
        shape = RoundedCornerShape(18.dp),
        backgroundColor = Gray100,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(0.75f).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)

        ) {
            AppText(
                text = service.title, style = MaterialTheme.typography.h4
            )

            Row {
                Icon(
                    imageVector = Icons.Outlined.AddCircle,
                    contentDescription = null
                )

                AppText(
                    text = "$expTime hrs"
                )
            }

            AppText(
                text = service.description, color = Gray500
            )

            Column {
                AppText(
                    text = "pricing", color = Gray500
                )

                AppText(
                    text = "₹$pricing /kg", color = Gray800
                )
            }

            Column {
                AppText(
                    text = "minimum cart", color = Gray500
                )

                AppText(
                    text = "₹$minCart (4kg)", color = Gray800
                )
            }

            AppText(
                text = "your whites and colored items will be washed together and tumble dried",
                style = MaterialTheme.typography.subtitle1
            )

            Row {
                TextButton(
                    onClick = {}, shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(2.dp, Gray800)
                ) {
                    AppText(
                        modifier = Modifier.padding(4.dp),
                        text = "Mixed",
                        style = MaterialTheme.typography.button,
                        fontWeight = FontWeight.W500
                    )
                }

                TextButton(
                    onClick = {}, shape = RoundedCornerShape(12.dp)
                ) {
                    AppText(
                        modifier = Modifier.padding(4.dp),
                        text = "Segregated",
                        style = MaterialTheme.typography.button,
                        fontWeight = FontWeight.W500
                    )
                }
            }

            TextButton(
                onClick = {},
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(2.dp, Gray800)
            ) {
                Row(
                    modifier = Modifier.padding(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Delete,
                        contentDescription = null,
                        tint = Gray800
                    )

                    AppText(text = "Remove Item", style = MaterialTheme.typography.button)
                }
            }

            Divider(color = dividerBlack, thickness = 1.5.dp)

            AppText(
                text = "Details",
                color = Gray500
            )

            DetailsList(
                keys = listOf("Delivery time", "Wash temperature", detergent, drying),
                values = listOf(
                    "24 hrs",
                    "$washTempMin° - $washTempMax°C",
                    "Eco Friendly",
                    "Tumble Dry"
                )
            )
        }
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
            style = MaterialTheme.typography.subtitle1
        )

        AppText(
            text = value,
            color = Gray800,
            style = MaterialTheme.typography.subtitle1
        )
    }
}