package org.example.mixedwashdummy.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import mixedwashdummy.composeapp.generated.resources.Poppins_Bold
import mixedwashdummy.composeapp.generated.resources.Poppins_Medium
import mixedwashdummy.composeapp.generated.resources.Poppins_Regular
import mixedwashdummy.composeapp.generated.resources.Poppins_SemiBold
import mixedwashdummy.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
fun Poppins() = FontFamily(
    Font(resource = Res.font.Poppins_Regular, FontWeight.Normal),
    Font(resource = Res.font.Poppins_SemiBold, FontWeight.SemiBold),
    Font(resource = Res.font.Poppins_Bold, FontWeight.Bold),
    Font(resource = Res.font.Poppins_Medium, FontWeight.Medium)
)