package edu.ufg.mr100823.ejercicio11

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import edu.ufg.mr100823.R

class Programador11Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_programador_11)
    }

    fun cerrarActividad(view: View) {
        finish()
    }
}