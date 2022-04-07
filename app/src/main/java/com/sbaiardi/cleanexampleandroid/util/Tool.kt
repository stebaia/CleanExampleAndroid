package com.sbaiardi.cleanexampleandroid.util



import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

object Tool {
    fun generateRandomColor(): Color {
        val rndInt = Random.nextInt(5)
        return when(rndInt){
            1 -> Color.Green
            2 -> Color.Magenta
            3 -> Color.Blue
            4-> Color.Red
            5 -> Color.Cyan
            else -> Color.White
        }
    }
}