package org.example.mixedwashdummy.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mixedwashdummy.composeapp.generated.resources.Res
import mixedwashdummy.composeapp.generated.resources.image1
import org.example.mixedwashdummy.ui.common.AppButton
import org.example.mixedwashdummy.ui.common.AppOutlinedButton
import org.example.mixedwashdummy.ui.theme.Gray100
import org.example.mixedwashdummy.ui.theme.Gray700
import org.example.mixedwashdummy.ui.theme.Gray800
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
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp, vertical = 18.dp)
        ) {
            Image(
                painter = painterResource(Res.drawable.image1),
                modifier = Modifier.width(106.dp).height(110.dp),
                contentScale = ContentScale.Fit,
                contentDescription = null
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Getting Started?",
                    color = textColor,
                    lineHeight = 16.sp,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )

                Text(
                    text = "See how MixedWash works and learn more about our services.",
                    color = textColor,
                    lineHeight = 16.sp,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light
                )

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    AppOutlinedButton(
                        buttonTitle = "Call Us",
                        contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp),
                        shape = RoundedCornerShape(6.dp),
                        onClick = onCall,
                        borderColor = Gray700,
                        fontSize = 12.sp

                    )

                    AppButton(
                        buttonTitle = "Explore",
                        fontWeight = FontWeight.Medium,
                        titleColor = Gray100,
                        fontSize = 12.sp,
                        onClick = onExplore,
                        backgroundColor = Gray800,
                        contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp),
                        shape = RoundedCornerShape(6.dp),
                    )
                }
            }
        }
    }
}