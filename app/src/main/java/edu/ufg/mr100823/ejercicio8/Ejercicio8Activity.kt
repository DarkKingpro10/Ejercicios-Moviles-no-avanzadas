package edu.ufg.mr100823.ejercicio8

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.ufg.mr100823.R

class Ejercicio8Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio8)
    }

    fun onTelefonoClick(view: View) {
        Toast.makeText(this, "Llamando al soporte técnico...", Toast.LENGTH_SHORT).show()
    }
}