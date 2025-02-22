package org.example.mixedwashdummy.ui.services

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mixedwashdummy.composeapp.generated.resources.Res
import mixedwashdummy.composeapp.generated.resources.ic_success
import org.example.mixedwashdummy.ui.common.AppButton
import org.example.mixedwashdummy.ui.common.AppText
import org.example.mixedwashdummy.ui.common.UnderlineBox
import org.example.mixedwashdummy.ui.theme.Gray100
import org.example.mixedwashdummy.ui.theme.Gray50
import org.example.mixedwashdummy.ui.theme.Gray500
import org.example.mixedwashdummy.ui.theme.Gray800
import org.example.mixedwashdummy.ui.theme.Gray900
import org.example.mixedwashdummy.ui.theme.Green
import org.jetbrains.compose.resources.vectorResource

@Composable
fun ServicesFooter(
    selectedItemsSize: Int,
    price: Float,
    onProceed: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().background(Gray50)
                .padding(start = 22.dp, top = 22.dp, end = 16.dp, bottom = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = vectorResource(Res.drawable.ic_success),
                        contentDescription = null,
                        tint = Green
                    )

                    Column {
                        AppText(
                            text = "20% OFF 'FLAT20' applied",
                            lineHeight = 12.sp,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Gray800,
                        )

                        UnderlineBox(lineColor = Gray500) {
                            AppText(
                                text = "modify",
                                color = Gray500,
                                lineHeight = 14.sp,
                                fontSize = 12.sp
                            )
                        }
                    }
                }

                Spacer(Modifier.height(12.dp))

                Row {
                    AppText(
                        text = "$selectedItemsSize items | ₹$price",
                        color = Gray900,
                        fontSize = 14.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Icon(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            AppButton(
                onClick = onProceed,
                buttonTitle = "Proceed",
                shape = RoundedCornerShape(6.dp),
                contentPadding = PaddingValues(horizontal = 26.dp, 12.dp),
                backgroundColor = Gray900,
                titleColor = Gray100,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}