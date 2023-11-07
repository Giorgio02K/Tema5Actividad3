package com.jordichorro.tema5actividad3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnTransferencia = findViewById<Button>(R.id.btn3)

        // Establece un listener para el botón
        btnTransferencia.setOnClickListener {
            // Crea un Intent para abrir la actividad TransferActivity
            val intent = Intent(this, TransferActivity::class.java)
            // Inicia la actividad LoginActivity
            startActivity(intent)
        }
    }
}