package edu.ufg.mr100823.ejercicio2

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.ufg.mr100823.R

class Ejercicio2Activity : AppCompatActivity() {

    private lateinit var etNumero1: EditText
    private lateinit var etNumero2: EditText
    private lateinit var rbSumar: RadioButton
    private lateinit var rbRestar: RadioButton
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2)

        etNumero1 = findViewById(R.id.etNumero1)
        etNumero2 = findViewById(R.id.etNumero2)
        rbSumar = findViewById(R.id.rbSumar)
        rbRestar = findViewById(R.id.rbRestar)
        tvResultado = findViewById(R.id.tvResultado)
    }

    fun calcular(view: View) {
        val n1 = etNumero1.text.toString().toDoubleOrNull() ?: 0.0
        val n2 = etNumero2.text.toString().toDoubleOrNull() ?: 0.0
        var resultado = 0.0

        if (rbSumar.isChecked) {
            resultado = n1 + n2
            tvResultado.text = "Resultado Suma: $resultado"
        } else if (rbRestar.isChecked) {
            resultado = n1 - n2
            tvResultado.text = "Resultado Resta: $resultado"
        } else {
            tvResultado.text = "Por favor seleccione una operación"
        }
    }
}