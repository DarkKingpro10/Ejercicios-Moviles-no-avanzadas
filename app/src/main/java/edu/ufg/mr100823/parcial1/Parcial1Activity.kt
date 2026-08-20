package edu.ufg.mr100823.parcial1

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.ufg.mr100823.R

data class Contacto(
    val id: String,
    val nombre: String,
    val numero: String,
    val fotoUri: Uri?
)

class Parcial1Activity : AppCompatActivity() {

    private lateinit var rvContactos: RecyclerView
    private lateinit var svContactos: SearchView
    private lateinit var adapter: ContactoAdapter
    private val REQUEST_READ_CONTACTS = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcial1)

        val toolbar = findViewById<Toolbar>(R.id.toolbarParcial)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener { finish() }

        rvContactos = findViewById(R.id.rvContactos)
        svContactos = findViewById(R.id.svContactos)
        rvContactos.layoutManager = LinearLayoutManager(this)

        checkPermission()
    }

    private fun checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_CONTACTS),
                REQUEST_READ_CONTACTS
            )
        } else {
            cargarContactos()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_READ_CONTACTS) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                cargarContactos()
            } else {
                Toast.makeText(this, "Permiso denegado para leer contactos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun cargarContactos() {
        val lista = mutableListOf<Contacto>()
        val vistos = mutableSetOf<String>() // Para evitar duplicados exactos (Nombre + Numero)
        
        val contentResolver = contentResolver
        val cursor = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
        )

        cursor?.use {
            val idIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID)
            val nameIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
            val numberIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
            val photoIndex = it.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_THUMBNAIL_URI)

            if (idIndex != -1 && nameIndex != -1 && numberIndex != -1 && photoIndex != -1) {
                while (it.moveToNext()) {
                    val id = it.getString(idIndex) ?: ""
                    val nombre = it.getString(nameIndex) ?: "Sin nombre"
                    var numero = it.getString(numberIndex) ?: ""
                    
                    // Limpiar el número para evitar duplicados por formato (espacios, guiones)
                    val numeroLimpio = numero.replace("\\s".toRegex(), "").replace("-", "")
                    val llave = "$nombre|$numeroLimpio"

                    if (!vistos.contains(llave)) {
                        val fotoUriStr = it.getString(photoIndex)
                        val fotoUri = if (fotoUriStr != null) Uri.parse(fotoUriStr) else null

                        lista.add(Contacto(id, nombre, numero, fotoUri))
                        vistos.add(llave)
                    }
                }
            }
        }

        adapter = ContactoAdapter(lista) { numero ->
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:$numero")
            startActivity(intent)
        }
        rvContactos.adapter = adapter

        svContactos.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean = false
            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter(newText ?: "")
                return true
            }
        })
    }
}
