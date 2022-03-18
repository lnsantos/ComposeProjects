package com.lnsantos.sayajinds.color

import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import com.lnsantos.sayajinds.color.strategy.SayajinLightColor
import com.lnsantos.sayajinds.color.strategy.SayajinNightColor

@Stable
class SayajinColor private constructor() {

    companion object {

        @Stable
        val UI : SayajinThemeColor = mutableStateOf(
            when (SayajinModeColor.getMode().value) {
                true -> SayajinLightColor()
                else -> SayajinNightColor()
            }
        ).value

        @Stable
        fun getColor() = when (SayajinModeColor.getMode().value) {
            true -> SayajinLightColor()
            else -> SayajinNightColor()
        }

    }

}