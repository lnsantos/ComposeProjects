package com.lnsantos.sayajinds.button

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.lnsantos.sayajinds.button.factory.UIButtonFactory
import com.lnsantos.sayajinds.button.factory.UIButtonRowFactory
import com.lnsantos.sayajinds.button.options.UIButtonLoading
import com.lnsantos.sayajinds.button.options.UIButtonSettings
import com.lnsantos.sayajinds.button.options.UIButtonStyle
import com.lnsantos.sayajinds.etx.applyRippleEffect
import com.lnsantos.sayajinds.etx.isColorDisable
import com.lnsantos.sayajinds.etx.isColorDisableOutlined
import com.lnsantos.sayajinds.ui.theme.SayajinColors

@Preview(
    showBackground = true,
    name = "Simple design"
)
@Composable
private fun UIButtonSimplePreview() {
    UIButton(
        style = UIButtonStyle.Simples(
            backgroundColor = SayajinColors.YellowBrand300,
            text = "Simple enabled",
            textColor = SayajinColors.Purple700
        ),
        onClickCallback = { }
    )
}

@Preview(
    showBackground = true,
    name = "Simple disable"
)
@Composable
private fun UIButtonSimpleDisablePreview() {
    UIButton(
        style = UIButtonStyle.Simples(
            backgroundColor = SayajinColors.YellowBrand300,
            text = "Simple disabled",
            enabled = false
        ),
        onClickCallback = { }
    )
}

@Preview(
    showBackground = true,
    name = "Simple disable"
)
@Composable
private fun UIButtonSimpleEnabledLoadingPreview() {
    UIButton(
        style = UIButtonStyle.Simples(
            backgroundColor = SayajinColors.YellowBrand300,
            text = "Simple loading",
            enabled = true,
            loadingSettings = UIButtonLoading(
                color = Color.Black,
                enableLoading = true
            )
        ),
        onClickCallback = { }
    )
}

@Composable
fun UIButton(
    onClickCallback: () -> Unit,
    style: UIButtonStyle,
    modifier: Modifier = Modifier
) {
    val settings = UIButtonFactory(style)

    modifier.applyRippleEffect(onClickCallback, settings.rippleColor)
    modifier.fillMaxWidth()
    modifier.animateContentSize(
        animationSpec = tween(
            durationMillis = 300,
            easing = LinearOutSlowInEasing
        ),
        finishedListener = { _, _ ->
            modifier.clip(CircleShape)
        }
    )

    val onClickControl = if (settings.loadingSettings?.enableLoading == true) object : () -> Unit {
        override fun invoke(): Unit {}
    } else onClickCallback

    Surface(
        modifier = Modifier.fillMaxWidth()
    ) {
        when (settings.type) {
            is UIButtonStyle.Simples -> UISimpleButton(
                settings = settings,
                onClickCallback = onClickControl,
                modifier = modifier
            )

            is UIButtonStyle.Outline -> UIOutlineButton(
                settings = settings,
                onClickCallback = onClickControl,
                modifier = modifier
            )
        }
    }

}


internal object UIOutlineButton {

    @Composable
    operator fun invoke(
        settings: UIButtonSettings,
        onClickCallback: () -> Unit,
        modifier: Modifier
    ) {

        var haveFocusBackgroundColor by remember { mutableStateOf(Color.Transparent) }

        modifier.onFocusChanged {
            haveFocusBackgroundColor =
                if (it.hasFocus) settings.interactionColor else Color.Transparent
        }

        OutlinedButton(
            onClick = onClickCallback,
            enabled = settings.buttonEnabled,
            modifier = modifier,
            colors = haveFocusBackgroundColor.isColorDisableOutlined(
                isEnabled = settings.buttonEnabled
            ),
            border = BorderStroke(2.dp, settings.borderColor)
        ) {
            UIButtonRowFactory(this, settings = settings)
        }
    }

}

internal object UISimpleButton {

    @Composable
    operator fun invoke(
        settings: UIButtonSettings,
        onClickCallback: () -> Unit,
        modifier: Modifier
    ) {
        Button(
            onClick = onClickCallback,
            colors = settings.backgroundColor,
            enabled = settings.buttonEnabled,
            modifier = modifier
        ) {
            UIButtonRowFactory(this, settings = settings)
        }
    }

}
