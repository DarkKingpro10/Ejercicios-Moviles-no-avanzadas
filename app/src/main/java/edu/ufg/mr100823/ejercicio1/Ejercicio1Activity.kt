package edu.ufg.mr100823.ejercicio1

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.ufg.mr100823.R

class Ejercicio1Activity : AppCompatActivity() {

    private lateinit var etNumero1: EditText
    private lateinit var etNumero2: EditText
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio1)

        etNumero1 = findViewById(R.id.etNumero1)
        etNumero2 = findViewById(R.id.etNumero2)
        tvResultado = findViewById(R.id.tvResultado)
    }

    fun sumar(view: View) {
        val n1 = etNumero1.text.toString().toDoubleOrNull() ?: 0.0
        val n2 = etNumero2.text.toString().toDoubleOrNull() ?: 0.0
        val suma = n1 + n2
        tvResultado.text = "Resultado: $suma"
    }
}