package edu.ufg.mr100823.ejercicio14_1

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.ufg.mr100823.R
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class Ejercicio14_1Activity : AppCompatActivity() {

    private lateinit var etNotas: EditText
    private val fileName = "notas.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio14_1)

        etNotas = findViewById(R.id.etNotas)
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)

        // Cargar nota guardada si existe
        cargarNota()

        btnGuardar.setOnClickListener {
            guardarNota()
        }
    }

    private fun guardarNota() {
        val texto = etNotas.text.toString()
        try {
            val file = openFileOutput(fileName, Context.MODE_PRIVATE)
            val osw = OutputStreamWriter(file)
            osw.write(texto)
            osw.flush()
            osw.close()
            Toast.makeText(this, "Nota guardada correctamente", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this, "Error al guardar la nota", Toast.LENGTH_SHORT).show()
        }
    }

    private fun cargarNota() {
        if (fileList().contains(fileName)) {
            try {
                val file = openFileInput(fileName)
                val isr = InputStreamReader(file)
                val br = BufferedReader(isr)
                val lineas = br.readText()
                br.close()
                isr.close()
                etNotas.setText(lineas)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}