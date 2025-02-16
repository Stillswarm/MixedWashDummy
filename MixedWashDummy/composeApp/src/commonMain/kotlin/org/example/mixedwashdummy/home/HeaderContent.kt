package org.example.mixedwashdummy.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        Box(modifier = Modifier.height(276.dp)) {
            AsyncImageLoader(
                imageUrl = dataItem.imageUrl,
                modifier = Modifier.height(160.dp).width(200.dp)
                    .align(Alignment.BottomStart).offset(y = 6.dp),
                contentDescription = dataItem.heading,
            )
        }

        Column(
            modifier = Modifier.width(189.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AppText(
                text = dataItem.heading,
                color = dataItem.textColor,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
            )

            AppText(
                text = dataItem.description,
                fontSize = 12.sp,
                lineHeight = 18.sp,
                color = dataItem.textColor
            )

            AppOutlinedButton(
                contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp),
                onClick = onButtonClick,
                shape = RoundedCornerShape(8.dp),
                borderColor = dataItem.textColor,
                buttonTitle = dataItem.buttonText,
                titleColor = dataItem.textColor,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                lineHeight = 18.sp
            )
        }
    }
}