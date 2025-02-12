package org.example.mixedwashdummy.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import mixedwashdummy.composeapp.generated.resources.Res
import mixedwashdummy.composeapp.generated.resources.image1
import org.example.mixedwashdummy.theme.Gray100
import org.example.mixedwashdummy.theme.Gray400
import org.example.mixedwashdummy.theme.Gray700
import org.example.mixedwashdummy.theme.Gray800
import org.example.mixedwashdummy.theme.Gray900
import org.example.mixedwashdummy.util.dropShadow
import org.example.mixedwashdummy.util.gradient
import org.jetbrains.compose.resources.painterResource

@Composable
fun OfferCard(
    details: String,
    imageUrl: String,
    buttonLabel: String,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Card(shape = RoundedCornerShape(12.dp),
        modifier = Modifier.padding(bottom = 8.dp)
            .dropShadow(shape = RoundedCornerShape(12.dp), color = Gray400, offsetY = 16.dp)
    ) {
        Box(
            modifier = Modifier.gradient(gradientLight = Gray800, gradientDark = Gray900, order = 2)
                .padding(16.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = details,
                        color = Gray100
                    )

                    Button(
                        onClick = onButtonClick,
                        shape = RoundedCornerShape(6.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Gray100)
                    ) {
                        Text(text = buttonLabel, color = Gray700)
                    }
                }

                Image(
                    painter = painterResource(Res.drawable.image1),
                    modifier = Modifier.height(72.dp).width(77.65.dp),
                    contentScale = ContentScale.Fit,
                    contentDescription = null
                )
                // TODO: Replace with actual image
            }

        }
    }
}