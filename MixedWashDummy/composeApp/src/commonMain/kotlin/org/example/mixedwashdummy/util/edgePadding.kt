package org.example.mixedwashdummy.util

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.edgePadding(extraHorizontal: Dp = 0.dp, extraVertical: Dp = 0.dp) =
    this.statusBarsPadding().navigationBarsPadding()
        .padding(horizontal = extraHorizontal, vertical = extraVertical)