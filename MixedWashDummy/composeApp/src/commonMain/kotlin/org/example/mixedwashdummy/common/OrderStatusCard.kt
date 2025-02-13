package org.example.mixedwashdummy.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import org.example.mixedwashdummy.theme.Gray100
import org.example.mixedwashdummy.theme.Gray300
import org.example.mixedwashdummy.theme.Gray500
import org.example.mixedwashdummy.theme.Gray700
import org.example.mixedwashdummy.theme.dividerBlack
import org.example.mixedwashdummy.util.gradient

@Composable
fun OrderStatusCard(
    orderId: String,
    title: String,
    subtitle: String,
    description: String,
    onDetailsClick: () -> Unit,
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier, shape = RoundedCornerShape(12.dp)) {

        Box(
            modifier = Modifier.fillMaxWidth()
                .gradient(colorStops = arrayOf(Pair(0f, Gray100), Pair(1f, Gray300)))
        ) {

            Column(
                modifier = Modifier.padding(horizontal = 32.dp, vertical = 18.dp)
            ) {
                Text(
                    text = orderId,
                    style = MaterialTheme.typography.subtitle1,
                    color = Gray500
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = "$title • $subtitle",
                            style = MaterialTheme.typography.h6,
                            color = Gray700
                        )

                        Text(
                            text = description,
                            style = MaterialTheme.typography.body1,
                            color = Gray700
                        )

                        Text(
                            text = "View Details",
                            style = MaterialTheme.typography.body1,
                            textDecoration = TextDecoration.Underline,
                            color = Gray700,
                            modifier = Modifier.clickable { onDetailsClick() }
                        )
                    }

                    AsyncImageLoader(
                        imageUrl = imageUrl,
                        contentDescription = null,
                        modifier = Modifier.size(100.dp)
                    )
                }

                Divider(color = dividerBlack, modifier = Modifier.padding(8.dp))

                // TODO : implement progress icons here
                // pickup, process, wash, delivery
            }
        }
    }
}