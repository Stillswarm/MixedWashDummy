package org.example.mixedwashdummy.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.example.mixedwashdummy.util.edgePadding
import org.example.mixedwashdummy.util.gradient

@Composable
fun HomeScreenHeader(
    imageUrl: String,
    title: String,
    description: String,
    gradientDark: Color,
    gradientLight: Color,
    textColor: Color,
    topBarContentColor: Color,
    buttonTitle: String,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box {

        Box(
            modifier = modifier.matchParentSize().fillMaxHeight(0.9f)
                .gradient(gradientDark, gradientLight)
        )

        Column(modifier = Modifier.edgePadding(extraHorizontal = 12.dp, extraVertical = 12.dp)) {
            HomeTopBar(
                addressKey = "Home",
                address = "560095, Bengaluru",
                onExpand = {},
                onNotificationClick = {},
                onFAQsClick = {},
                textColor = topBarContentColor,
            )

            Spacer(Modifier.height(12.dp))

            HeaderContent(
                title = title,
                imageUrl = imageUrl,
                textColor = textColor,
                description = description,
                buttonTitle = buttonTitle,
                onButtonClick = onButtonClick
            )
        }
    }
}