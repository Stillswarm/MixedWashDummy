package org.example.mixedwashdummy.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalRuler
import org.example.mixedwashdummy.common.LocationSlab
import org.example.mixedwashdummy.theme.Gray700
import org.example.mixedwashdummy.theme.dividerBlack

@Composable
fun HomeTopBar(
    addressKey: String,
    address: String,
    onExpand: () -> Unit,
    onNotificationClick: () -> Unit,
    onFAQsClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LocationSlab(
            addressKey = addressKey,
            address = address,
            onExpand = onExpand
        )

        Row {
            IconButton(onClick = onFAQsClick) {
                Text(text = "FAQs", color = Gray700)
            }

            VerticalRuler()

            IconButton(onClick = onNotificationClick) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notifications",
                    tint = Gray700
                )
            }
        }
    }
}