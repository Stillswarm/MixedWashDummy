package org.example.mixedwashdummy.history

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.example.mixedwashdummy.common.AppOutlinedButton
import org.example.mixedwashdummy.common.AppText
import org.example.mixedwashdummy.common.IndicationChip
import org.example.mixedwashdummy.theme.Gray100
import org.example.mixedwashdummy.theme.Gray800
import org.example.mixedwashdummy.theme.Green
import org.example.mixedwashdummy.theme.Yellow

/**
 * @param status 0 - Processing, 1 - Delivered, 2 - Cancelled, else - Unknown
 *
 * TODO: find better names for title1, title2, title3
 */
@Composable
fun OrderSummaryCard(
    orderId: String,
    title1: String,
    title2: String,
    title3: String,
    status: Int,
    cost: Int?,
    onDetails: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.fillMaxWidth().padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                IndicationChip(
                    text = orderId,
                    textColor = Gray100,
                    backgroundColor = Gray800,
                    borderColor = Gray100,
                )

                IndicationChip(
                    text = when (status) {
                        0 -> "Processing"
                        1 -> "Delivered"
                        2 -> "Cancelled"
                        else -> "Unknown"
                    },
                    textColor = when (status) {
                        0 -> Yellow
                        1 -> Gray100
                        2 -> Gray800
                        else -> Color.Transparent
                    },
                    backgroundColor = when (status) {
                        0 -> Gray100
                        1 -> Green
                        2 -> Gray100
                        else -> Color.Transparent
                    },
                    borderColor = when (status) {
                        // TODO: change the "Processing" color to Brown
                        0 -> Yellow
                        2 -> Gray800
                        else -> Color.Transparent
                    },
                )
            }

            AppText(
                text = "₹${cost ?: "-"}",
                style = MaterialTheme.typography.h5
            )
        }

        AppText(
            text = "$title1 • $title2 • $title3",
            modifier = Modifier.fillMaxWidth(0.75f),
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.W500,
            color = Gray800
        )

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Row {
                TimeTracker(
                    action = "Ordered",
                    date = "13 Dec",
                    time = "3 pm",
                    textColor = Gray800
                )

                TimeTracker(
                    action = "Est. Delivery",
                    date = "14 Dec",
                    time = "3 pm",
                    textColor = Gray800,
                )
            }

            AppOutlinedButton(
                onClick = onDetails,
                buttonTitle = "Details"
            )
        }
    }
}

@Composable
fun TimeTracker(
    action: String,
    date: String,
    time: String,
    textColor: Color,
) {
    Column(modifier = Modifier.padding(8.dp)) {
        AppText(
            text = action,
            color = textColor,
            style = MaterialTheme.typography.subtitle1
        )

        AppText(
            text = "$date • $time",
            color = textColor,
            style = MaterialTheme.typography.subtitle1
        )
    }
}