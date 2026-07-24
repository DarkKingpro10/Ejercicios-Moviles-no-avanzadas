package edu.ufg.mr100823.model

import android.content.Context
import android.content.Intent

data class Ejercicio(
    val titulo: String,
    val descripcion: String,
    val activityClass: Class<*>
) {
    fun launch(context: Context) {
        val intent = Intent(context, activityClass)
        context.startActivity(intent)
    }
}