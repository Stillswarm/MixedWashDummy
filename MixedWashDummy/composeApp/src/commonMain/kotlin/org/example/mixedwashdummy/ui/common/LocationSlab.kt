package org.example.mixedwashdummy.ui.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LocationSlab(
    addressKey: String,
    address: String,
    onExpand: () -> Unit,
    modifier: Modifier = Modifier,
    contentColor: Color = Color.DarkGray
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            imageVector = Icons.Default.LocationOn,
            contentDescription = "Location",
            tint = contentColor,
            modifier = Modifier.size(18.dp),
        )

        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    text = addressKey,
                    color = contentColor,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
                )

                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Expand",
                    tint = contentColor,
                    modifier = Modifier.size(18.dp).clickable {
                        onExpand()
                    }
                )
            }

            Text(
                text = address,
                fontSize = 12.sp,
                lineHeight = 15.sp,
                color = contentColor,
                style = MaterialTheme.typography.subtitle1
            )
        }
    }
}