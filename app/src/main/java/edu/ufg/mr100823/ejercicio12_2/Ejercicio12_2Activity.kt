package edu.ufg.mr100823.ejercicio12_2

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import edu.ufg.mr100823.R
import edu.ufg.mr100823.ejercicio12.WebViewActivity

class Ejercicio12_2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio12_2)

        val lvSitios = findViewById<ListView>(R.id.lvSitios)

        val sitios = arrayOf(
            "https://ufg.edu.sv/",
            "https://www.laprensagrafica.com/",
            "https://www.youtube.com",
            "https://stackoverflow.com",
            "https://www.instagram.com/",
            "https://www.elsalvador.com/",
            "https://www.diarioelsalvador.com/",
            "https://github.com/",
            "https://developer.android.com/",
            "https://kotlinlang.org/",
            "https://www.reddit.com/r/programming/",
            "https://news.ycombinator.com/",
            "https://www.w3schools.com/",
            "https://www.freecodecamp.org/",
            "https://www.udemy.com/",
            "https://www.coursera.org/",
            "https://www.google.com",
            "https://dev.to/",
            "https://medium.com/",
            "https://diario.elmundo.sv/"
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, sitios)
        lvSitios.adapter = adapter

        lvSitios.setOnItemClickListener { _, _, position, _ ->
            val urlSeleccionada = sitios[position]
            val intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra("URL", urlSeleccionada)
            startActivity(intent)
        }
    }
}