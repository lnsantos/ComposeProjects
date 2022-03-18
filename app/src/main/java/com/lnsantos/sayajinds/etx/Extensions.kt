package com.lnsantos.sayajinds.etx

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.lnsantos.sayajinds.ui.theme.SayajinColors

internal fun Color.isColorDisable(isEnabled: Boolean, disableColor: Color) : Color {
    return if (isEnabled) this else disableColor
}

@Composable
internal fun Color.isColorDisableOutlined(isEnabled: Boolean) = ButtonDefaults.outlinedButtonColors(
    backgroundColor = this.isColorDisable(isEnabled = isEnabled, SayajinColors.GrayBrand100),
    disabledContentColor = Color.Transparent
)

@Composable
internal fun Modifier.applyRippleEffect(onClickCallback: () -> Unit, color: Color){
    this.clickable(
        onClick = onClickCallback,
        interactionSource = remember { MutableInteractionSource() },
        indication = rememberRipple(
            radius = 5.dp,
            color = color
        )
    )
}