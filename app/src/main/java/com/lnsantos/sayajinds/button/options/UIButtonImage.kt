package com.lnsantos.sayajinds.button.options

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

data class UIButtonImage(
    @DrawableRes val icon: Int,
    val modifier: Modifier = Modifier.size(24.dp),
    val scale: ContentScale = ContentScale.Crop,
    val contentDescription: String = String()
)
