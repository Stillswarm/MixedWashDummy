package org.example.mixedwashdummy.common

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import org.example.mixedwashdummy.theme.Gray700

@Composable
fun AppText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Gray700,
    style: TextStyle = MaterialTheme.typography.h6,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontWeight: FontWeight = FontWeight.Normal,
    lineHeight: TextUnit = 18.sp,
    letterSpacing: TextUnit = TextUnit.Unspecified
) {
    Text(
        text = text,
        color = color,
        style = style,
        modifier = modifier,
        fontWeight = fontWeight,
        fontSize = fontSize,
        lineHeight = lineHeight,
        letterSpacing = letterSpacing
    )
}