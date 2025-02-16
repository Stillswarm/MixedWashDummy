package org.example.mixedwashdummy.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IndicationChip(
    text: String,
    textColor: Color,
    leadingIcon: Char,
    backgroundColor: Color,
    borderColor: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(6.dp),
        contentColor = textColor,
        backgroundColor = backgroundColor,
        border = BorderStroke(1.dp, borderColor),
    ) {
        AppText(
            modifier = Modifier.padding(6.dp),
            text = "$leadingIcon $text",
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 16.sp,
            color = textColor,
        )
    }
}