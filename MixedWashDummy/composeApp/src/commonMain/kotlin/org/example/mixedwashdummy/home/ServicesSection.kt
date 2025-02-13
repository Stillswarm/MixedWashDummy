package org.example.mixedwashdummy.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.example.mixedwashdummy.Service
import org.example.mixedwashdummy.common.AsyncImageLoader
import org.example.mixedwashdummy.theme.Gray100
import org.example.mixedwashdummy.theme.Gray300
import org.example.mixedwashdummy.theme.Gray700
import org.example.mixedwashdummy.util.gradient

@Composable
fun ServicesSection(
    services: List<Service>,
    modifier: Modifier = Modifier,
    onSeeAll: () -> Unit,
    textColor: Color = Gray700
) {
    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "Services",
                style = MaterialTheme.typography.h6,
                color = textColor
            )
            Text(text = "See All", color = textColor, modifier = Modifier.clickable { onSeeAll() })
        }

        Spacer(Modifier.height(18.dp))

        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(services) {
                ServiceCard(it, onClick = {})
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ServiceCard(service: Service, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(12.dp),
        onClick = onClick,
        modifier = modifier.gradient(colorStops = arrayOf(Pair(1f, Gray100), Pair(1f, Gray300)))
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AsyncImageLoader(
                imageUrl = service.imageUrl,
                contentDescription = null,
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 20.dp).height(80.17.dp)
                    .width(100.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = service.title,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}