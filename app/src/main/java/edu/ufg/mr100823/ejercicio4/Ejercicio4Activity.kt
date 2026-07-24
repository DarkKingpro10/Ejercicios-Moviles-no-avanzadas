package edu.ufg.mr100823.ejercicio4

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.ufg.mr100823.R

class Ejercicio4Activity : AppCompatActivity() {

    private lateinit var etNumero1: EditText
    private lateinit var etNumero2: EditText
    private lateinit var spOperaciones: Spinner
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio4)

        etNumero1 = findViewById(R.id.etNumero1)
        etNumero2 = findViewById(R.id.etNumero2)
        spOperaciones = findViewById(R.id.spOperaciones)
        tvResultado = findViewById(R.id.tvResultado)
    }

    fun calcular(view: View) {
        val n1 = etNumero1.text.toString().toDoubleOrNull() ?: 0.0
        val n2 = etNumero2.text.toString().toDoubleOrNull() ?: 0.0
        val operacion = spOperaciones.selectedItem.toString()
        var resultado = 0.0

        when (operacion) {
            "Sumar" -> resultado = n1 + n2
            "Restar" -> resultado = n1 - n2
            "Multiplicar" -> resultado = n1 * n2
            "Dividir" -> {
                if (n2 != 0.0) {
                    resultado = n1 / n2
                } else {
                    tvResultado.text = "Error: División por cero"
                    return
                }
            }
        }
        tvResultado.text = "Resultado $operacion: $resultado"
    }
}