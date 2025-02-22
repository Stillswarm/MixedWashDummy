package org.example.mixedwashdummy.ui.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.mixedwashdummy.ui.common.AppOutlinedButton
import org.example.mixedwashdummy.ui.common.AppText
import org.example.mixedwashdummy.ui.common.IndicationChip
import org.example.mixedwashdummy.ui.theme.Gray100
import org.example.mixedwashdummy.ui.theme.Gray50
import org.example.mixedwashdummy.ui.theme.Gray800
import org.example.mixedwashdummy.ui.theme.Green
import org.example.mixedwashdummy.ui.theme.Yellow

/**
 * @param status 0 - Processing, 1 - Delivered, 2 - Cancelled, else - Unknown
 *
 */
@Composable
fun OrderSummaryCard(
    orderId: Long,
    titles: List<String>,
    ordered: String,
    delivery: String?,
    status: Int,
    cost: Int?,
    onDetails: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 18.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                IndicationChip(
                    text = orderId.toString(),
                    textColor = Gray100,
                    backgroundColor = Gray800,
                    borderColor = Gray800,
                    leadingIcon = '#'
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
                        else -> Color.Unspecified
                    },
                    backgroundColor = when (status) {
                        0 -> Gray50
                        1 -> Green
                        2 -> Gray50
                        else -> Color.Unspecified
                    },
                    borderColor = when (status) {
                        0 -> Yellow
                        1 -> Green
                        2 -> Gray800
                        else -> Color.Unspecified
                    },
                    leadingIcon = '•'
                )
            }

            AppText(
                text = "₹${cost ?: "-"}",
                style = MaterialTheme.typography.h5
            )
        }

        AppText(
            text = titles.joinToString(" • "),
            fontSize = 16.sp,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.fillMaxWidth(0.75f),
            color = Gray800
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(18.dp)) {
                TimeTracker(
                    action = "Ordered",
                    datetime = ordered,
                    textColor = Gray800
                )

                TimeTracker(
                    action = if (status == 1) "Delivered" else "Est. Delivery",
                    datetime = delivery ?: "-",
                    textColor = Gray800,
                )
            }

            AppOutlinedButton(
                onClick = onDetails,
                fontSize = 14.sp,
                contentPadding = PaddingValues(horizontal = 18.dp, vertical = 8.dp),
                fontWeight = FontWeight.Medium,
                buttonTitle = "Details"
            )
        }
    }
}

@Composable
fun TimeTracker(
    action: String,
    datetime: String,
    textColor: Color,
    fontSize: TextUnit = 12.sp,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        AppText(
            text = action,
            color = textColor,
            fontSize = fontSize,
            style = MaterialTheme.typography.subtitle1
        )

        AppText(
            text = datetime,
            color = textColor,
            fontSize = fontSize,
            style = MaterialTheme.typography.subtitle1
        )
    }
}