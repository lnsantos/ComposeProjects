package com.lnsantos.sayajinds.button.options

import androidx.compose.material.ButtonColors
import androidx.compose.ui.graphics.Color

internal data class UIButtonSettings(
    val type: UIButtonStyle,
    val text: String = "",
    val backgroundColor: ButtonColors,
    val textColor: Color,
    val buttonEnabled: Boolean,
    val rippleColor: Color,
    val loadingSettings: UIButtonLoading?,
    val interactionColor: Color = Color.Unspecified,
    val borderColor: Color = Color.Unspecified,
    val isBorderDouble: Boolean = false,
    val image: UIButtonImage? = null

)
