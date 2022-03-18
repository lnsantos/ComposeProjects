package com.lnsantos.sayajinds.button.factory

import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.lnsantos.sayajinds.button.options.UIButtonSettings
import com.lnsantos.sayajinds.button.options.UIButtonStyle
import com.lnsantos.sayajinds.etx.isColorDisable
import com.lnsantos.sayajinds.ui.theme.SayajinColors

internal object UIButtonFactory {

    @Composable
    operator fun invoke(style: UIButtonStyle) : UIButtonSettings {
        return when(style){
            is UIButtonStyle.Simples -> createSimpleSetting(style)
            is UIButtonStyle.Outline -> createOutlineSetting(style)
        }
    }

    @Composable
    private fun createOutlineSetting(style: UIButtonStyle.Outline) = UIButtonSettings(
        type = style,
        text = style.text,
        textColor = style.textColor.isColorDisable(style.enabled, SayajinColors.GrayBrand200),
        buttonEnabled = style.enabled,
        rippleColor = Color.Unspecified,
        loadingSettings = style.loadingSettings,
        interactionColor = style.interactionColor,
        borderColor = style.borderColor.isColorDisable(style.enabled, Color.Transparent),
        backgroundColor = ButtonDefaults.outlinedButtonColors(Color.Transparent,Color.Transparent,Color.Transparent),
        image = style.imagem
    )

    @Composable
    private fun createSimpleSetting(style: UIButtonStyle.Simples) = UIButtonSettings(
        type = style,
        text = style.text,
        backgroundColor = ButtonDefaults.buttonColors(
            backgroundColor = style.backgroundColor,
            disabledBackgroundColor = style.backgroundColor.isColorDisable(style.enabled, SayajinColors.GrayBrand100)
        ),
        textColor = style.textColor.isColorDisable(style.enabled, SayajinColors.GrayBrand200),
        buttonEnabled = style.enabled,
        rippleColor = style.rippleColor.isColorDisable(style.enabled, Color.Unspecified),
        loadingSettings = style.loadingSettings,
        image = style.imagem
    )

}