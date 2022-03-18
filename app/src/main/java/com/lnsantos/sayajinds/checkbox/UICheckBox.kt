package com.lnsantos.sayajinds.checkbox

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxColors
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.lnsantos.sayajinds.color.SayajinColor

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
private fun preview(){
    var state by remember { mutableStateOf(true) }

    UICheckBoxText(
        scale = 4f,
        onState = { },
        enabled = mutableStateOf(state),
        text = "Accept contract"
    )
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun UICheckBoxText(
    scale: Float = 1f,
    text: String = String(),
    fontSize: Float = 16f,
    fontColor: Color = SayajinColor.getColor().WhiteBrand100,
    fontWeight: FontWeight = FontWeight.Bold,
    onState:(Boolean) -> Unit,
    startState: Boolean = false,
    enabled: MutableState<Boolean> = mutableStateOf(false),
    checkedColor: Color = SayajinColor.getColor().YellowBrand100,
    uncheckedColor: Color = Color.Red,
    checkmarkColor: Color = SayajinColor.getColor().RedBrand100
){

    var state by remember { mutableStateOf(startState) }

    Row(modifier = Modifier.fillMaxWidth()) {
        Checkbox(
            checked = state,
            onCheckedChange = {
                state = it
                onState(it)
            },
            modifier = Modifier.scale(scale),
            enabled = enabled.value,
            colors = CheckboxDefaults.colors(
                checkedColor = checkedColor,
                uncheckedColor = uncheckedColor,
                checkmarkColor = if (enabled.value) checkmarkColor else SayajinColor.getColor().GrayBrand100,
                disabledColor = SayajinColor.getColor().GrayBrand200
            )
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = text,
            fontSize = TextUnit(fontSize, TextUnitType.Sp),
            fontStyle = FontStyle.Normal,
            color = fontColor,
            fontWeight = fontWeight
        )
    }

}