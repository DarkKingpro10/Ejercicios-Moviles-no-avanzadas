package edu.ufg.mr100823.ejercicio10

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.ufg.mr100823.R

class Ejercicio10Activity : AppCompatActivity() {

    private lateinit var etUsuario: EditText
    private lateinit var etClave: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio10)

        etUsuario = findViewById(R.id.etUsuario)
        etClave = findViewById(R.id.etClave)
    }

    fun verificarCredenciales(view: View) {
        val usuario = etUsuario.text.toString().trim()
        val clave = etClave.text.toString().trim()

        if (usuario.isEmpty() || clave.isEmpty()) {
            Toast.makeText(this, "Debe llenar ambos campos: usuario y clave", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Verificación exitosa", Toast.LENGTH_SHORT).show()
        }
    }
}