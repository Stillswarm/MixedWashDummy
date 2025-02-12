package org.example.mixedwashdummy.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import mixedwashdummy.composeapp.generated.resources.Res
import mixedwashdummy.composeapp.generated.resources.image1
import org.example.mixedwashdummy.theme.Gray100
import org.example.mixedwashdummy.theme.Gray700
import org.jetbrains.compose.resources.painterResource

@Composable
fun GettingStartedSection(
    onCall: () -> Unit,
    onExplore: () -> Unit,
    modifier: Modifier = Modifier,
    textColor: Color = Gray700,
) {
    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Row {
            Image(
                painter = painterResource(Res.drawable.image1),
                modifier = Modifier.width(106.dp).height(110.dp),
                contentDescription = null
            )

            Column(
                modifier = Modifier.padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Getting Started?",
                    color = textColor,
                    style = MaterialTheme.typography.h6,
                )

                Text(
                    text = "See how MixedWash works and learn more about our services.",
                    color = textColor,
                )

                Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    OutlinedButton(
                        onClick = onCall,
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(2.dp, Gray700)
                    ) {
                        Text(text = "Call Us", color = Gray700)
                    }

                    Button(
                        onClick = onExplore,
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Gray700)
                    ) {
                        Text(text = "Explore", color = Gray100)
                    }
                }
            }
        }
    }
}