package org.example.mixedwashdummy.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.mixedwashdummy.HomeHeaderData
import org.example.mixedwashdummy.util.edgePadding
import org.example.mixedwashdummy.util.gradient

@Composable
fun HomeScreenHeader(
    headerData: List<HomeHeaderData>,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    // todo: fix padding values and sizes for the header
    val item = headerData[1]    // TODO: find ways to show diff. items at diff. times
    Box {
        Box(
            modifier = modifier.fillMaxWidth()
                .gradient(
                    colorStops = arrayOf(
                        Pair(0f, item.gradientLight),
                        Pair(1f, item.gradientDark)
                    )
                )
        )

        Column(
            modifier = Modifier.edgePadding(
                extraHorizontal = 16.dp,
                extraVertical = 16.dp
            )
        ) {
            HomeTopBar(
                addressKey = "Home",
                address = "560095, Bengaluru",
                onExpand = {},
                onNotificationClick = {},
                onFAQsClick = {},
                textColor = item.textColor
            )

            HeaderContent(
                dataItem = item,
                onButtonClick = onButtonClick
            )
        }
    }
}