package edu.ufg.mr100823.ejercicio11

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import edu.ufg.mr100823.R

class Ejercicio11Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio11)
    }

    fun irADetalle(view: View) {
        val intent = Intent(this, Programador11Activity::class.java)
        startActivity(intent)
    }
}