package com.lnsantos.sayajinds.button.factory

import android.widget.ProgressBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.lnsantos.sayajinds.button.options.UIButtonSettings
import com.lnsantos.sayajinds.button.options.UIButtonStyle

internal object UIButtonRowFactory {

    @Composable
    operator fun invoke(scope: RowScope, settings: UIButtonSettings) {
        when(settings.type){
            is UIButtonStyle.Simples -> createSimpleRow(style = settings, scope)
            is UIButtonStyle.Outline -> createOutlineRow(style = settings, scope)
        }
    }

    @Composable
    private fun createOutlineRow(
        style: UIButtonSettings,
        scope: RowScope
    ) {
        UIButtonRowScope(scope = scope){

            style.loadingSettings?.takeIf { it.enableLoading }?.let { uiButtonLoading ->

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        color = uiButtonLoading.color,
                        strokeWidth = 2.dp,
                    )
                }

                return@UIButtonRowScope
            }

            style.image?.let {
                Image(
                    painter = painterResource(id = it.icon),
                    contentDescription = it.contentDescription,
                    contentScale = it.scale,
                    modifier = it.modifier
                )
                Spacer(modifier = Modifier.size(16.dp))
            }

            Text(
                text = style.text,
                color = style.textColor
            )
        }
    }

    @Composable
    private fun createSimpleRow(
        style: UIButtonSettings,
        scope: RowScope
    ) {
        UIButtonRowScope(scope = scope){

            style.loadingSettings?.takeIf { it.enableLoading }?.let { uiButtonLoading ->

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        color = uiButtonLoading.color,
                        strokeWidth = 2.dp,
                    )
                }

                return@UIButtonRowScope
            }

            style.image?.let {
                Image(
                    painter = painterResource(id = it.icon),
                    contentDescription = it.contentDescription,
                    contentScale = it.scale,
                    modifier = it.modifier
                )
                Spacer(modifier = Modifier.size(16.dp))
            }

            Text(
                text = style.text,
                color = style.textColor
            )
        }
    }

    @Composable
    private fun UIButtonRowScope(scope: RowScope, contentCallback: @Composable RowScope.() -> Unit){
        contentCallback(scope)
    }

}