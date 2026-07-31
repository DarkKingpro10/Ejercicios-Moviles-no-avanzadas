package edu.ufg.mr100823.ejercicio8_1

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import edu.ufg.mr100823.R

class Ejercicio8_1Activity : AppCompatActivity() {

    private lateinit var etTelefono: EditText
    private lateinit var tvEstadoLlamada: TextView
    private val CALL_PERMISSION_REQUEST_CODE = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio8_1)
        
        etTelefono = findViewById(R.id.etTelefono)
        tvEstadoLlamada = findViewById(R.id.tvEstadoLlamada)
    }

    fun onTelefonoClick(view: View) {
        val phoneNumber = etTelefono.text.toString()
        if (phoneNumber.isNotEmpty()) {
            checkPermissionAndCall(phoneNumber)
        } else {
            Toast.makeText(this, "Por favor, ingresa un número de teléfono", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkPermissionAndCall(phoneNumber: String) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), CALL_PERMISSION_REQUEST_CODE)
        } else {
            makeCall(phoneNumber)
        }
    }

    private fun makeCall(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:$phoneNumber")
        try {
            startActivity(intent)
            tvEstadoLlamada.text = "Llamando a $phoneNumber..."
        } catch (e: SecurityException) {
            tvEstadoLlamada.text = "Error: Permiso denegado"
            e.printStackTrace()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CALL_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                val phoneNumber = etTelefono.text.toString()
                makeCall(phoneNumber)
            } else {
                Toast.makeText(this, "Permiso de llamada denegado", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
