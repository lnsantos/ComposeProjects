package com.lnsantos.sayajinds

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lnsantos.sayajinds.button.UIButton
import com.lnsantos.sayajinds.button.options.UIButtonLoading
import com.lnsantos.sayajinds.button.options.UIButtonStyle
import com.lnsantos.sayajinds.ui.theme.SayajinColors
import com.lnsantos.sayajinds.ui.theme.SayajinDSTheme

internal class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SayajinDSTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DefaultPreview(ctx = this)
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DefaultPreview(ctx: Context?) {
    var enabledButton by remember { mutableStateOf(true) }
    var enabledLoading by remember { mutableStateOf(false) }

    Column(
        Modifier.padding(12.dp)
    ) {

        UIButton(
            style = UIButtonStyle.Simples(
                backgroundColor = SayajinColors.YellowBrand300,
                text = "Loading  $enabledLoading",
                textColor = SayajinColors.Purple700,
                enabled = true,
                rippleColor = SayajinColors.YellowBrand100
            ),
            onClickCallback = {
                enabledLoading = !enabledLoading
            }
        )

        Spacer(modifier = Modifier.size(16.dp))

        UIButton(
            style = UIButtonStyle.Simples(
                backgroundColor = SayajinColors.YellowBrand300,
                text = "isDisable  $enabledButton",
                textColor = SayajinColors.Purple700,
                enabled = true,
                rippleColor = SayajinColors.YellowBrand100
            ),
            onClickCallback = {
                enabledButton = !enabledButton
            }
        )

        Spacer(modifier = Modifier.size(16.dp))

        UIButton(
            style = UIButtonStyle.Simples(
                backgroundColor = SayajinColors.YellowBrand300,
                text = "Simple loading",
                enabled = enabledButton,
                loadingSettings = UIButtonLoading(
                    color = Color.Black,
                    enableLoading = enabledLoading
                )
            ),
            onClickCallback = {
                ctx?.let {
                    Toast.makeText(it,"Loading", Toast.LENGTH_LONG).show()
                }

            }
        )
        Spacer(modifier = Modifier.size(16.dp))

        UIButton(
            style = UIButtonStyle.Outline(
                text = "Simple loading",
                enabled = enabledButton,
                loadingSettings = UIButtonLoading(
                    color = Color.Black,
                    enableLoading = enabledLoading
                ),
                interactionColor = SayajinColors.Purple700,
                borderColor = Color.Black
            ),
            onClickCallback = {

                ctx?.let {
                    Toast.makeText(it,"Outline", Toast.LENGTH_LONG).show()
                }

            }
        )
    }

}