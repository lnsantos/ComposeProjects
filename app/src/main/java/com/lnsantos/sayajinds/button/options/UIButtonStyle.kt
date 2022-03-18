package com.lnsantos.sayajinds.button.options

import androidx.compose.ui.graphics.Color
import com.lnsantos.sayajinds.ui.theme.SayajinColors
import java.net.CookieHandler

sealed class UIButtonStyle {

    data class Simples(
        val text: String,
        val backgroundColor: Color,
        val textColor: Color = SayajinColors.WhiteBrand100,
        val rippleColor: Color = Color.Unspecified,
        val enabled: Boolean = true,
        val loadingSettings: UIButtonLoading? = null,
        val imagem: UIButtonImage? = null
    ) : UIButtonStyle()

    data class Outline(
        val text: String,
        val textColor: Color = Color.Black,
        val interactionColor: Color,
        val borderColor: Color,
        val isBorderDouble: Boolean = false,
        val enabled: Boolean = true,
        val loadingSettings: UIButtonLoading? = null,
        val imagem: UIButtonImage? = null
    ) : UIButtonStyle()

}
