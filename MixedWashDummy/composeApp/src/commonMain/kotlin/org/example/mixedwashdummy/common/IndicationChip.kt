package org.example.mixedwashdummy.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun IndicationChip(
    text: String,
    textColor: Color,
    backgroundColor: Color,
    borderColor: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        contentColor = textColor,
        backgroundColor = backgroundColor,
        border = BorderStroke(1.dp, borderColor),
    ) {
        AppText(
            modifier = Modifier.padding(12.dp),
            text = "• $text",
            style = MaterialTheme.typography.button,
            color = textColor,
        )
    }
}