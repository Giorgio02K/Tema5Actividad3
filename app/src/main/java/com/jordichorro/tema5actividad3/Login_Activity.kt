package com.jordichorro.tema5actividad3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Login_Activity : AppCompatActivity() {
    val usuarioPrueba1 = "123456"
    val contrasenyaPrueba1 = "123456"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        //Se obtiene la señal del boton
        val btnEntrar = findViewById<Button>(R.id.btnIniciar)

        btnEntrar.setOnClickListener{
            //Obtener el usuario y la contraseña
            val usuario = findViewById<EditText>(R.id.usuarioInp).text.toString()
            val contrasenya = findViewById<EditText>(R.id.passwordInp).text.toString()

            //Los datos se comprueban en una funcion aparte
            val comprobarDatos = comprobarUsuarioYContrasenya(usuario, contrasenya)

            if (comprobarDatos){
                // Crea un Intent para abrir la actividad LoginActivity
                val intent = Intent(this, MainActivity::class.java)
                // Inicia la actividad LoginActivity
                startActivity(intent)
            }else{
                // Muestra un mensaje de error al usuario.
                Toast.makeText(this, "El usuario o la contraseña no son correctos", Toast.LENGTH_LONG).show()
            }
        }
    }



    fun comprobarUsuarioYContrasenya(usuario: String, contrasenya: String):Boolean{
        if (usuario.equals(usuarioPrueba1) && contrasenya.equals(contrasenyaPrueba1)){
            return true
        }
        return false
    }

}
