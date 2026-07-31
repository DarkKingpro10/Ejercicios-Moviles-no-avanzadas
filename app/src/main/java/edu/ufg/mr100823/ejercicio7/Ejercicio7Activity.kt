package edu.ufg.mr100823.ejercicio7

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.ufg.mr100823.R

class Ejercicio7Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio7)

        val tvInfoPoblacion = findViewById<TextView>(R.id.tvInfoPoblacion)
        val lvPaises = findViewById<ListView>(R.id.lvPaises)

        val datosPaises = mapOf(
            "Antigua y Barbuda" to "94,298",
            "Argentina" to "46.2 millones",
            "Bahamas" to "412,623",
            "Barbados" to "282,100",
            "Belice" to "410,825",
            "Bolivia" to "12.3 millones",
            "Brasil" to "216.4 millones",
            "Canadá" to "40.1 millones",
            "Chile" to "19.6 millones",
            "Colombia" to "52.3 millones",
            "Costa Rica" to "5.2 millones",
            "Cuba" to "11 millones",
            "Dominica" to "72,800",
            "Ecuador" to "18.1 millones",
            "El Salvador" to "6.3 millones",
            "Estados Unidos" to "336 millones",
            "Granada" to "126,000",
            "Guatemala" to "18.1 millones",
            "Guyana" to "800,000",
            "Haití" to "11.7 millones",
            "Honduras" to "10.6 millones",
            "Jamaica" to "2.8 millones",
            "México" to "128.4 millones",
            "Nicaragua" to "7 millones",
            "Panamá" to "4.4 millones",
            "Paraguay" to "6.8 millones",
            "Perú" to "34.3 millones",
            "Puerto Rico" to "3.2 millones",
            "República Dominicana" to "11.3 millones",
            "San Cristóbal y Nieves" to "47,700",
            "San Vicente y las Granadinas" to "104,000",
            "Santa Lucía" to "180,000",
            "Suriname" to "623,000",
            "Trinidad y Tobago" to "1.5 millones",
            "Uruguay" to "3.4 millones",
            "Venezuela" to "28.8 millones"
        )

        val paises = datosPaises.keys.sorted().toTypedArray()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, paises)
        lvPaises.adapter = adapter

        lvPaises.setOnItemClickListener { _, _, position, _ ->
            val paisSeleccionado = paises[position]
            val poblacion = datosPaises[paisSeleccionado]
            val mensaje = "Poblacion de $paisSeleccionado de $poblacion"
            
            tvInfoPoblacion.text = mensaje
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        }
    }
}