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
import edu.ufg.mr100823.model.Ejercicio

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvEjercicios = findViewById<RecyclerView>(R.id.rvEjercicios)
        val listaEjercicios = mutableListOf<Ejercicio>()

        // Registro de ejercicios según el Pipeline
        listaEjercicios.add(Ejercicio("Ejercicio 1", "Suma simple de dos números", Ejercicio1Activity::class.java))
        listaEjercicios.add(Ejercicio("Ejercicio 2", "Suma y Resta con RadioButtons", Ejercicio2Activity::class.java))
        listaEjercicios.add(Ejercicio("Ejercicio 3", "Suma y Resta con CheckBoxes", Ejercicio3Activity::class.java))
        listaEjercicios.add(Ejercicio("Ejercicio 4", "Calculadora con Spinner", Ejercicio4Activity::class.java))

        rvEjercicios.layoutManager = LinearLayoutManager(this)
        rvEjercicios.adapter = EjercicioAdapter(listaEjercicios)
    }
}