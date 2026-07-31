package edu.ufg.mr100823

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.ufg.mr100823.adapter.EjercicioAdapter
import edu.ufg.mr100823.ejercicio1.Ejercicio1Activity
import edu.ufg.mr100823.ejercicio2.Ejercicio2Activity
import edu.ufg.mr100823.ejercicio3.Ejercicio3Activity
import edu.ufg.mr100823.ejercicio4.Ejercicio4Activity
import edu.ufg.mr100823.ejercicio7.Ejercicio7Activity
import edu.ufg.mr100823.ejercicio8.Ejercicio8Activity
import edu.ufg.mr100823.ejercicio8_1.Ejercicio8_1Activity
import edu.ufg.mr100823.ejercicio8_2.Ejercicio8_2Activity
import edu.ufg.mr100823.model.Ejercicio

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvEjercicios = findViewById<RecyclerView>(R.id.rvEjercicios)
        val listaEjercicios = mutableListOf<Ejercicio>()

        // Registro de ejercicios según el Pipeline y reordenación solicitada
        listaEjercicios.add(Ejercicio("Ejercicio 3", "Suma simple de dos números", Ejercicio1Activity::class.java))
        listaEjercicios.add(Ejercicio("Ejercicio 4", "Suma y Resta con CheckBoxes", Ejercicio3Activity::class.java))
        listaEjercicios.add(Ejercicio("Ejercicio 5", "Suma y Resta con RadioButtons", Ejercicio2Activity::class.java))
        listaEjercicios.add(Ejercicio("Ejercicio 6", "Calculadora con Spinner", Ejercicio4Activity::class.java))
        listaEjercicios.add(Ejercicio("Ejercicio 7", "Población de América y el Caribe", Ejercicio7Activity::class.java))
        listaEjercicios.add(Ejercicio("Ejercicio 8", "Acción con ImageButton (Teléfono)", Ejercicio8Activity::class.java))
        listaEjercicios.add(Ejercicio("Ejercicio 8.1", "Llamada con permisos y EditText", Ejercicio8_1Activity::class.java))
        listaEjercicios.add(Ejercicio("Ejercicio 8.2", "Marcador (Dial) con EditText", Ejercicio8_2Activity::class.java))

        rvEjercicios.layoutManager = LinearLayoutManager(this)
        rvEjercicios.adapter = EjercicioAdapter(listaEjercicios)
    }
}