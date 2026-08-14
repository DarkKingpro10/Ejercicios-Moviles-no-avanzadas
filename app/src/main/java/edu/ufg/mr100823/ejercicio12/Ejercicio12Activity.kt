package edu.ufg.mr100823.ejercicio12

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import edu.ufg.mr100823.R

class Ejercicio12Activity : AppCompatActivity() {

    private lateinit var etUrl: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio12)
        etUrl = findViewById(R.id.etUrl)
    }

    fun navegarAlSitio(view: View) {
        var url = etUrl.text.toString().trim()
        if (url.isNotEmpty()) {
            if (!url.startsWith("http://") && !url.startsWith("https://")) {
                url = "https://$url"
            }
            val intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra("URL", url)
            startActivity(intent)
        }
    }
}