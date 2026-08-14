package edu.ufg.mr100823.ejercicio12_3

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import edu.ufg.mr100823.R
import edu.ufg.mr100823.ejercicio12.WebViewActivity

class Ejercicio12_3Activity : AppCompatActivity() {

    private lateinit var etBusqueda: EditText
    private lateinit var lvHistorial: ListView
    private val historial = mutableListOf<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio12_3)

        etBusqueda = findViewById(R.id.etBusqueda)
        lvHistorial = findViewById(R.id.lvHistorial)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, historial)
        lvHistorial.adapter = adapter

        lvHistorial.setOnItemClickListener { _, _, position, _ ->
            val url = historial[position]
            abrirSitio(url)
        }
    }

    fun navegarYGuardar(view: View) {
        var url = etBusqueda.text.toString().trim()
        if (url.isNotEmpty()) {
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://$url"
            }
            
            // Agregar al historial si no existe ya al inicio (para evitar duplicados seguidos)
            if (historial.isEmpty() || historial[0] != url) {
                historial.add(0, url)
                adapter.notifyDataSetChanged()
            }
            
            etBusqueda.text.clear()
            abrirSitio(url)
        }
    }

    private fun abrirSitio(url: String) {
        val intent = Intent(this, WebViewActivity::class.java)
        intent.putExtra("URL", url)
        startActivity(intent)
    }
}