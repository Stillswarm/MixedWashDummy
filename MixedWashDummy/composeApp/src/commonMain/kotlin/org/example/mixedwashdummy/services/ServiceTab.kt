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
import androidx.compose.material.Badge
import androidx.compose.material.BadgedBox
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.example.mixedwashdummy.common.AppText
import org.example.mixedwashdummy.common.AsyncImageLoader
import org.example.mixedwashdummy.theme.Gray100
import org.example.mixedwashdummy.theme.Gray300
import org.example.mixedwashdummy.theme.Gray50
import org.example.mixedwashdummy.theme.Gray700
import org.example.mixedwashdummy.theme.Gray900
import org.example.mixedwashdummy.theme.Green

// TODO: Improve the service badge

@Composable
fun ServiceTab(
    title: String,
    imageUrl: String,
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
            BadgedBox(
                badge = {
                    if (isTaken) {
                        Badge(
                            contentColor = if (isSelected) Gray700 else Gray50,
                            backgroundColor = if (isSelected) Gray50 else Green,
                            modifier = Modifier.clip(CircleShape)
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Done,
                                contentDescription = null,
                                modifier = Modifier.size(24.dp).padding(4.dp)
                            )
                        }
                    }
                }
            ) {
                Box(
                    modifier = Modifier.clip(CircleShape)
                        .background(if (isSelected) Gray700 else Gray100),
                    contentAlignment = Alignment.Center
                ) {

//                    Image(
//                        painter = painterResource(Res.drawable.image1),
//                        modifier = Modifier.padding(14.dp),
//                        contentDescription = null,
//                        contentScale = ContentScale.Fit
//                    )
                    AsyncImageLoader(
                        imageUrl = imageUrl,
                        modifier = Modifier.padding(14.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            AppText(
                text = title,
                color = if (isSelected) Gray300 else Gray700,
            )
        }
    }
}
