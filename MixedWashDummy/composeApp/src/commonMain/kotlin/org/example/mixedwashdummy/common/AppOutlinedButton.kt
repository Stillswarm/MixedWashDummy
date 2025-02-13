package org.example.mixedwashdummy.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.example.mixedwashdummy.theme.Gray800

@Composable
fun AppOutlinedButton(
    onClick: () -> Unit,
    buttonTitle: String,
    shape: Shape = RoundedCornerShape(8.dp),
    borderColor: Color = Gray800,
    titleColor: Color = Gray800,
    textStyle: TextStyle = MaterialTheme.typography.button,
    fontWeight: FontWeight = FontWeight.Normal,
) {
    TextButton(
        onClick = onClick,
        shape = shape,
        border = BorderStroke(1.dp, borderColor),
    ) {
        AppText(
            text = buttonTitle,
            color = titleColor,
            style = textStyle,
            fontWeight = fontWeight,
        )
    }
}