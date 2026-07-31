package edu.ufg.mr100823.ejercicio8

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.ufg.mr100823.R

class Ejercicio8Activity : AppCompatActivity() {

    private lateinit var etTelefono: EditText
    private lateinit var tvEstadoLlamada: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio8)
        
        //etTelefono = findViewById(R.id.etTelefono)
        tvEstadoLlamada = findViewById(R.id.tvEstadoLlamada)
    }

    fun onTelefonoClick(view: View) {
        tvEstadoLlamada.text = "Llamando al número de teléfono..."
    }
}