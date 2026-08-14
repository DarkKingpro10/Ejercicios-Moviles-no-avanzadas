package edu.ufg.mr100823.ejercicio9

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import edu.ufg.mr100823.R
import kotlin.random.Random

class Ejercicio9Activity : AppCompatActivity() {

    private var numeroGenerado: Int = 0
    private lateinit var etNumeroIngresado: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio9)

        etNumeroIngresado = findViewById(R.id.etNumeroIngresado)

        generarYMostrarNumero()
    }

    private fun generarYMostrarNumero() {
        numeroGenerado = Random.nextInt(1, 1001)
        
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Número Generado")
        builder.setMessage("El número aleatorio es: $numeroGenerado")
        builder.setPositiveButton("Entendido") { dialog, _ ->
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }

    fun controlarNumero(view: View) {
        val textoIngresado = etNumeroIngresado.text.toString()
        if (textoIngresado.isNotEmpty()) {
            val numeroIngresado = textoIngresado.toInt()
            if (numeroIngresado == numeroGenerado) {
                Toast.makeText(this, "¡Acertó!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "No acertó. El número era $numeroGenerado", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Por favor, ingrese un número", Toast.LENGTH_SHORT).show()
        }
    }

    fun generarOtroNumero(view: View) {
        etNumeroIngresado.text.clear()
        generarYMostrarNumero()
    }
}