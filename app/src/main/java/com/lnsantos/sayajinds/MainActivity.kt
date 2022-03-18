package com.lnsantos.sayajinds

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.lnsantos.sayajinds.button.UIButton
import com.lnsantos.sayajinds.button.options.UIButtonImage
import com.lnsantos.sayajinds.button.options.UIButtonLoading
import com.lnsantos.sayajinds.button.options.UIButtonStyle
import com.lnsantos.sayajinds.checkbox.UICheckBoxText
import com.lnsantos.sayajinds.color.SayajinColor
import com.lnsantos.sayajinds.color.SayajinModeColor
import com.lnsantos.sayajinds.ui.theme.SayajinColors
import com.lnsantos.sayajinds.ui.theme.SayajinDSTheme

internal class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SayajinDSTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = SayajinColor.UI.BackgroundScreen
                ) {
                    Column() {
                        DefaultPreview(ctx = this@MainActivity)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalUnitApi::class)
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun DefaultPreview(ctx: Context?) {
    var enabledButton by remember { mutableStateOf(true) }
    var enabledLoading by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.background(SayajinColor.UI.BackgroundScreen)
    ) {
        Text(
            text = "Sayajin Design System",
            fontSize = TextUnit(26f, TextUnitType.Sp),
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                color = SayajinColor.getColor().YellowBrand100
            ),
            modifier = Modifier
                .padding(24.dp)
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center
        )
        Column(
            Modifier
                .padding(12.dp)
                .background(Color.Transparent)
        ) {

            Row {
                UIButton(
                    style = UIButtonStyle.Simples(
                        backgroundColor = SayajinColor.UI.BackgroundMainStyle,
                        text = "Loading ${
                            if (enabledLoading) "[ON]" else "[OFF]"
                        } ",
                        textColor = SayajinColor.UI.WhiteBrand100,
                        enabled = true,
                        rippleColor = SayajinColor.UI.YellowBrand100
                    ),
                    onClickCallback = {
                        enabledLoading = !enabledLoading
                    },
                    modifier = Modifier.width(200.dp)
                )

                Spacer(modifier = Modifier.size(16.dp))

                UIButton(
                    style = UIButtonStyle.Simples(
                        backgroundColor = SayajinColor.UI.BackgroundMainStyle,
                        text = "isDisable  ${
                            if (enabledButton) "[ON]" else "[OFF]"
                        } ",
                        textColor = SayajinColor.UI.WhiteBrand100,
                        enabled = true,
                        rippleColor = SayajinColor.UI.YellowBrand100
                    ),
                    onClickCallback = {
                        enabledButton = !enabledButton
                    },
                    modifier = Modifier.width(200.dp)
                )
            }
            Spacer(modifier = Modifier.size(16.dp))
            Row(modifier = Modifier.background(Color.Transparent)) {
                UIButton(
                    style = UIButtonStyle.Simples(
                        backgroundColor = SayajinColor.UI.BackgroundMainStyle,
                        text = "Change color ${
                            if (SayajinModeColor.isDarkMode.value) "[ON]" else "[OFF]"
                        } ",
                        textColor = SayajinColor.UI.WhiteBrand100,
                        enabled = true,
                        rippleColor = SayajinColor.UI.YellowBrand100
                    ),
                    onClickCallback = {
                        SayajinModeColor.changeMode()
                    },
                    modifier = Modifier.width(200.dp)
                )

            }

            Spacer(modifier = Modifier.size(16.dp))

            UIButton(
                style = UIButtonStyle.Simples(
                    backgroundColor = SayajinColor.getColor().BackgroundExempleStyle,
                    text = "Simple loading",
                    textColor = SayajinColor.getColor().WhiteBrand100,
                    enabled = enabledButton,
                    loadingSettings = UIButtonLoading(
                        color = SayajinColor.getColor().RedBrand100,
                        enableLoading = enabledLoading
                    )
                ),
                onClickCallback = {
                    ctx?.let {
                        Toast.makeText(it, "Loading", Toast.LENGTH_LONG).show()
                    }

                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(16.dp))

            UIButton(
                style = UIButtonStyle.Outline(
                    text = "Outline loading",
                    textColor = SayajinColor.getColor().RedBrand100,
                    enabled = enabledButton,
                    loadingSettings = UIButtonLoading(
                        color = SayajinColor.getColor().YellowBrand100,
                        enableLoading = enabledLoading
                    ),
                    interactionColor = SayajinColor.getColor().YellowBrand100,
                    borderColor = SayajinColor.getColor().YellowBrand100
                ),
                onClickCallback = {

                    ctx?.let {
                        Toast.makeText(it, "Outline", Toast.LENGTH_LONG).show()
                    }

                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.size(16.dp))

            UIButton(
                style = UIButtonStyle.Outline(
                    text = "Icon",
                    textColor = SayajinColor.getColor().BackgroundScreen,
                    enabled = enabledButton,
                    loadingSettings = UIButtonLoading(
                        color = SayajinColor.getColor().BackgroundScreen,
                        enableLoading = enabledLoading
                    ),
                    interactionColor = SayajinColor.getColor().BackgroundMainStyle,
                    borderColor = SayajinColor.getColor().RedBrand100,
                    imagem = UIButtonImage(
                        icon = android.R.drawable.ic_input_add
                    )
                ),
                onClickCallback = {

                    ctx?.let {
                        Toast.makeText(it, "Outline", Toast.LENGTH_LONG).show()
                    }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
            )

            Spacer(modifier = Modifier.size(16.dp))
            UIButton(
                style = UIButtonStyle.Simples(
                    backgroundColor = SayajinColor.getColor().RedBrand100,
                    text = "Simple Icon loading",
                    textColor = SayajinColor.getColor().YellowBrand100,
                    enabled = enabledButton,
                    loadingSettings = UIButtonLoading(
                        color = SayajinColor.getColor().RedBrand200,
                        enableLoading = enabledLoading
                    ),
                    imagem = UIButtonImage(
                        icon = android.R.drawable.ic_dialog_map
                    )
                ),
                onClickCallback = {
                    ctx?.let {
                        Toast.makeText(it, "Loading", Toast.LENGTH_LONG).show()
                    }

                },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = "CheckBox",
                fontSize = TextUnit(18f, TextUnitType.Sp),
                fontWeight = FontWeight.Bold,
                style = TextStyle(
                    color = SayajinColor.getColor().WhiteBrand100
                ),
                modifier = Modifier
                    .padding(24.dp)
                    .align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center
            )
            Column(
                Modifier.background(Color(0xFFECA6E9))
            ) {
                UICheckBoxText(
                    onState = { },
                    enabled = mutableStateOf(value = true),
                    uncheckedColor = SayajinColor.getColor().BlueBrand100,
                    scale = 1f,
                    text = "Accept contract",
                    fontColor = SayajinColor.getColor().RedBrand100
                )
                UICheckBoxText(
                    onState = { },
                    enabled = mutableStateOf(value = true),
                    uncheckedColor = SayajinColor.getColor().YellowBrand100,
                    checkedColor = SayajinColor.getColor().RedBrand100,
                    checkmarkColor = SayajinColor.getColor().WhiteBrand100,
                    scale = 1f,
                    text = "Accept contract",
                    fontColor = SayajinColor.getColor().WhiteBrand100
                )
                UICheckBoxText(
                    onState = { },
                    enabled = mutableStateOf(value = true),
                    uncheckedColor = SayajinColor.getColor().BackgroundScreen,
                    scale = 1f,
                    text = "Accept contract",
                    fontColor = SayajinColor.getColor().RedBrand100,
                    checkedColor = SayajinColor.getColor().RedBrand200,
                    checkmarkColor = SayajinColor.getColor().YellowBrand300,
                    fontWeight = FontWeight.Light
                )
                UICheckBoxText(
                    onState = { },
                    enabled = mutableStateOf(value = true),
                    uncheckedColor = SayajinColor.getColor().BlueBrand100,
                    scale = 1f,
                    text = "Accept contract",
                    fontColor = SayajinColor.getColor().YellowBrand300,
                    checkedColor = SayajinColor.getColor().YellowBrand100,
                    checkmarkColor = SayajinColor.getColor().YellowBrand300,
                    fontWeight = FontWeight.W100,
                    fontSize = 24f
                )
            }

        }
    }

}