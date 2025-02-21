package org.example.mixedwashdummy.services

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.example.mixedwashdummy.ServiceItem
import org.example.mixedwashdummy.common.AppText
import org.example.mixedwashdummy.common.AsyncImageLoader
import org.example.mixedwashdummy.theme.Gray100
import org.example.mixedwashdummy.theme.Gray300
import org.example.mixedwashdummy.theme.Gray50
import org.example.mixedwashdummy.theme.Gray700
import org.example.mixedwashdummy.theme.Gray900
import org.example.mixedwashdummy.theme.Green

@Composable
fun ServiceTab(
    serviceItem: ServiceItem,
    isOpted: Boolean,
    isCurrent: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.width(100.dp).clip(RoundedCornerShape(12.dp))
            .background(if (isCurrent) Gray900 else Gray50)
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier.padding(6.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box {
                Box(
                    modifier = Modifier.clip(CircleShape)
                        .background(if (isCurrent) Gray700 else Gray100),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImageLoader(
                        imageUrl = serviceItem.imageUrl,
                        modifier = Modifier.padding(14.dp)
                    )
                }

                if (isOpted) {

                    Box(
                        modifier = Modifier.clip(CircleShape)
                            .background(if (isCurrent) Gray900 else Gray50)
                            .align(Alignment.BottomEnd)
                    ) {
                        Box(modifier = Modifier.padding(4.dp).clip(CircleShape).background(Green)) {
                            Icon(
                                imageVector = Icons.Outlined.Done,
                                contentDescription = null,
                                tint = Gray50,
                                modifier = Modifier.padding(2.dp).size(16.dp).clip(CircleShape)
                            )
                        }
                    }
                }
            }

            AppText(
                text = serviceItem.title,
                color = if (isCurrent) Gray300 else Gray700,
                lineHeight = 16.sp,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
