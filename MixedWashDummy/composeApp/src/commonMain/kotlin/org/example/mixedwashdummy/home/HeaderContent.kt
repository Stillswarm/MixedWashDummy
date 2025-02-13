package org.example.mixedwashdummy.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.example.mixedwashdummy.HomeHeaderData
import org.example.mixedwashdummy.common.AppOutlinedButton
import org.example.mixedwashdummy.common.AppText
import org.example.mixedwashdummy.common.AsyncImageLoader

@Composable
fun HeaderContent(
    dataItem: HomeHeaderData,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Row(modifier = modifier.fillMaxWidth()) {
        AsyncImageLoader(
            imageUrl = dataItem.imageUrl,
            contentDescription = dataItem.heading,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.offset(y = 36.dp)
        )

        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            AppText(
                text = dataItem.heading,
                style = MaterialTheme.typography.h5,
                color = dataItem.textColor
            )

            AppText(
                text = dataItem.description,
                style = MaterialTheme.typography.body1,
                color = dataItem.textColor
            )

            AppOutlinedButton(
                onClick = onButtonClick,
                shape = RoundedCornerShape(8.dp),
                borderColor = dataItem.textColor,
                buttonTitle = dataItem.buttonText,
                titleColor = dataItem.textColor,
                fontWeight = FontWeight.Bold
            )
        }
    }
}