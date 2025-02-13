package org.example.mixedwashdummy.services

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.example.mixedwashdummy.Service
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
    service: Service,
    isTaken: Boolean,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.width(100.dp).clip(RoundedCornerShape(12.dp))
            .background(if (isSelected) Gray900 else Color.Transparent),
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box {
                Box(
                    modifier = Modifier.clip(CircleShape)
                        .background(if (isSelected) Gray700 else Gray100),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImageLoader(
                        imageUrl = service.imageUrl,
                        modifier = Modifier.padding(14.dp)
                    )
                }

                if (isTaken) {
                    Box(
                        modifier = Modifier.clip(CircleShape)
                            .background(if (isSelected) Gray50 else Green)
                            .align(Alignment.BottomEnd)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Done,
                            contentDescription = null,
                            modifier = Modifier.padding(4.dp).size(16.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            AppText(
                text = service.title,
                color = if (isSelected) Gray300 else Gray700,
            )
        }
    }
}
