package edu.ufg.mr100823.ejercicio3

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.ufg.mr100823.R

class Ejercicio3Activity : AppCompatActivity() {

    private lateinit var etNumero1: EditText
    private lateinit var etNumero2: EditText
    private lateinit var cbSumar: CheckBox
    private lateinit var cbRestar: CheckBox
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio3)

        etNumero1 = findViewById(R.id.etNumero1)
        etNumero2 = findViewById(R.id.etNumero2)
        cbSumar = findViewById(R.id.cbSumar)
        cbRestar = findViewById(R.id.cbRestar)
        tvResultado = findViewById(R.id.tvResultado)
    }

    fun calcular(view: View) {
        val n1 = etNumero1.text.toString().toDoubleOrNull() ?: 0.0
        val n2 = etNumero2.text.toString().toDoubleOrNull() ?: 0.0
        val resultados = mutableListOf<String>()

        if (cbSumar.isChecked) {
            resultados.add("Suma: ${n1 + n2}")
        }
        if (cbRestar.isChecked) {
            resultados.add("Resta: ${n1 - n2}")
        }

        if (resultados.isEmpty()) {
            tvResultado.text = "Seleccione una operación"
        } else {
            tvResultado.text = resultados.joinToString("\n")
        }
    }
}