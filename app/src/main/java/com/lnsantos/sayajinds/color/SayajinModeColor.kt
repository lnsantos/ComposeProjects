package com.lnsantos.sayajinds.color

import androidx.compose.runtime.mutableStateOf

object SayajinModeColor {

    var isDarkMode = mutableStateOf(false)

    fun setModeOption(enableDarkMode: Boolean){
        isDarkMode.value = enableDarkMode
    }

    fun changeMode(){
        isDarkMode.value = !getMode().value
    }

    fun getMode() = isDarkMode

}