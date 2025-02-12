package org.example.mixedwashdummy.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mixedwashdummy.composeapp.generated.resources.Res
import mixedwashdummy.composeapp.generated.resources.image1
import org.example.mixedwashdummy.theme.Gray700
import org.jetbrains.compose.resources.painterResource

@Composable
fun HeaderContent(
    title: String,
    imageUrl: String,
    description: String,
    buttonTitle: String,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    textColor: Color = Gray700
) {
    Row(modifier = modifier.fillMaxWidth()) {
//        AsyncImageLoader(
//            imageUrl = imageUrl,
//            contentDescription = title
//        )
        // TODO: Replace with actual image
        Image(
            painter = painterResource(Res.drawable.image1),
            contentDescription = null,
            modifier = Modifier.height(160.dp).width(200.dp)
        )

        Column {
            Text(
                text = title,
                fontSize = 24.sp,
                color = textColor
            )

            Text(
                text = description,
                fontSize = 12.sp,
                color = textColor
            )

            OutlinedButton(
                onClick = onButtonClick,
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(2.dp, Gray700)
            ) {
                Text(
                    text = buttonTitle,
                    color = textColor,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
