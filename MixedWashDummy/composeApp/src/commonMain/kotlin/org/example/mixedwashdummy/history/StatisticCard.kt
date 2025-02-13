package org.example.mixedwashdummy.history

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import org.example.mixedwashdummy.common.AppText
import org.example.mixedwashdummy.theme.Gray200
import org.example.mixedwashdummy.theme.Gray400
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun StatisticCard(
    value: Int,
    metric: String,
    unit: String,
    icon: DrawableResource,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.width(130.dp).height(110.dp),
        shape = RoundedCornerShape(12.dp),
        backgroundColor = Gray200
    ) {

        Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {

            AppText(
                text = value.toString(),
                style = MaterialTheme.typography.h4
            )

            Spacer(Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                    Image(
                        painter = painterResource(icon),
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        colorFilter = ColorFilter.tint(color = Gray400)
                    )

                    AppText(
                        text = "$metric \n• $unit",
                        color = Gray400,
                        style = MaterialTheme.typography.caption
                    )
            }
        }
    }
}