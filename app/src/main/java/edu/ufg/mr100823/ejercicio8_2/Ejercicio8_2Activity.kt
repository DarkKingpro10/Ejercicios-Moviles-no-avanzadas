package edu.ufg.mr100823.ejercicio8_2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.ufg.mr100823.R

class Ejercicio8_2Activity : AppCompatActivity() {

    private lateinit var etTelefonoDial: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio8_2)
        
        etTelefonoDial = findViewById(R.id.etTelefonoDial)
    }

    fun onDialClick(view: View) {
        val phoneNumber = etTelefonoDial.text.toString()
        if (phoneNumber.isNotEmpty()) {
            openDialer(phoneNumber)
        } else {
            Toast.makeText(this, "Por favor, ingresa un número de teléfono", Toast.LENGTH_SHORT).show()
        }
    }

    private fun openDialer(phoneNumber: String) {
        // ACTION_DIAL no requiere permisos especiales en el manifiesto ni en tiempo de ejecución
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$phoneNumber")
        startActivity(intent)
    }
}
