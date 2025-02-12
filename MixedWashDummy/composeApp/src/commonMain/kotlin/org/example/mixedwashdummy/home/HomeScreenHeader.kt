package org.example.mixedwashdummy.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.example.mixedwashdummy.common.GradientBox

@Composable
fun HomeScreenHeader(
    imageUrl: String,
    title: String,
    description: String,
    gradientDark: Color,
    gradientLight: Color,
    buttonTitle: String,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box {
        GradientBox(
            modifier = Modifier.matchParentSize(),
            gradientLight = gradientLight,
            gradientDark = gradientDark
        )

        Column {
            HomeTopBar(
                addressKey = "Home",
                address = "560095, Bengaluru",
                onExpand = {},
                onNotificationClick = {},
                onFAQsClick = {}
            )

            HeaderContent(
                title = title,
                imageUrl = imageUrl,
                description = description,
                buttonTitle = buttonTitle,
                onButtonClick = onButtonClick
            )
        }
    }
}