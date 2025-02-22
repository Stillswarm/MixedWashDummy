package org.example.mixedwashdummy.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mixedwashdummy.composeapp.generated.resources.Res
import mixedwashdummy.composeapp.generated.resources.emphasized_bullet
import mixedwashdummy.composeapp.generated.resources.unemphasized_bullet
import org.example.mixedwashdummy.OnboardingData
import org.example.mixedwashdummy.ui.common.AppButton
import org.example.mixedwashdummy.ui.common.AppText
import org.example.mixedwashdummy.ui.common.UnderlineBox
import org.example.mixedwashdummy.ui.theme.BlueDark
import org.example.mixedwashdummy.ui.theme.BlueDarker
import org.example.mixedwashdummy.ui.theme.Gray100
import org.example.mixedwashdummy.ui.theme.Gray400
import org.example.mixedwashdummy.ui.theme.Gray800
import org.example.mixedwashdummy.ui.theme.Yellow
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.vectorResource

@Composable
fun OnboardingScreen(
    onboardingData: List<OnboardingData>,
    modifier: Modifier = Modifier
) {
    var visibleIndex by remember {
        mutableIntStateOf(0)
    }
    Box(
        modifier = modifier.fillMaxSize().padding(vertical = 42.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            Image(
                painter = painterResource(onboardingData[visibleIndex].imageResource),
                modifier = Modifier.width(356.dp).height(300.dp),
                contentDescription = "image"
            )

            Column(
                modifier = Modifier.fillMaxWidth().padding(25.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AppText(
                    text = onboardingData[visibleIndex].title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    lineHeight = 28.sp,
                    textAlign = TextAlign.Center,
                    color = BlueDarker
                )

                Spacer(Modifier.height(24.dp))

                AppText(
                    text = onboardingData[visibleIndex].subtitle,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 24.sp,
                    textAlign = TextAlign.Center
                )
            }

            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(9.dp)
            ) {
                for (i in 0..2) {
                    Icon(
                        imageVector = vectorResource(
                            if (i == visibleIndex) Res.drawable.emphasized_bullet
                            else Res.drawable.unemphasized_bullet,
                        ),
                        contentDescription = null,
                        tint = if (i == visibleIndex) Yellow else Gray400
                    )
                }
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = if (visibleIndex == 2) Arrangement.Center else Arrangement.SpaceBetween,
            modifier = Modifier.align(Alignment.BottomCenter).fillMaxWidth()
                .padding(horizontal = 23.dp)
        ) {
            if (visibleIndex != 2) {
                UnderlineBox(
                    lineColor = Gray800,
                    modifier = Modifier.weight(1f)
                ) {
                    AppText(text = "Skip", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                }
            }

            AppButton(
                onClick = { if (visibleIndex < 2) ++visibleIndex else visibleIndex = 0 },
                buttonTitle = if (visibleIndex == 2) "Log-in" else "Next",
                backgroundColor = BlueDark,
                lineHeight = 20.sp,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                contentPadding = PaddingValues(horizontal = 41.5.dp, vertical = 15.dp),
                titleColor = Gray100,
                modifier = if (visibleIndex == 2) Modifier.fillMaxWidth() else Modifier.wrapContentWidth(),
            )
        }
    }
}