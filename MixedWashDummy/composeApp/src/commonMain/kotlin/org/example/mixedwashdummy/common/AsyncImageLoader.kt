package org.example.mixedwashdummy.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil3.compose.AsyncImage

const val BASE_URL = "https://assets-aac.pages.dev/assets/"
@Composable
fun AsyncImageLoader(imageUrl: String, modifier: Modifier = Modifier) {
    AsyncImage(
        modifier = modifier,
        model = "$BASE_URL$imageUrl.png",
        contentDescription = null,
        onError = { println(it.result.throwable.printStackTrace()) }
    )
}