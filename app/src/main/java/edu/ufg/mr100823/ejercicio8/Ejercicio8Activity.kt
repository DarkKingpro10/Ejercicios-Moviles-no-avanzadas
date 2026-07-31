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
        
        etTelefono = findViewById(R.id.etTelefono)
        tvEstadoLlamada = findViewById(R.id.tvEstadoLlamada)
    }

    fun onTelefonoClick(view: View) {
        val numero = etTelefono.text.toString()
        when {
            numero.isEmpty() -> {
                tvEstadoLlamada.text = "Por favor, ingresa un número"
            }
            numero.length < 8 -> {
                tvEstadoLlamada.text = "El número debe tener 8 dígitos"
            }
            else -> {
                // El XML ya limita a un máximo de 8 con maxLength="8"
                tvEstadoLlamada.text = "Llamando al $numero..."
            }
        }
    }
}