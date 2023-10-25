package com.example.examen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.examen.model.Persona


class MainActivity : AppCompatActivity() {

    private val lista = listOf(
        Persona("Marco", "Garcia", "marco", "marco"),
        Persona("Luisa", "Hernández", "luisa", "luisa"),
        Persona("Pedro", "Martínez", "pedro", "pedro"),
        Persona("Ana", "Rodríguez", "ana", "ana")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = findViewById<EditText>(R.id.username)
        val contra = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.loginbutton)

        loginButton.setOnClickListener {
            val username2 = username.text.toString()
            val contra2 = contra.text.toString()

            val user = lista.find { it.username == username2 && it.contraseña == contra2 }

            if (user != null) {
                val intent = Intent(this@MainActivity, BienvenidoActivity::class.java)
                intent.putExtra("USER", user)
                startActivity(intent)
            } else {
                Toast.makeText(this@MainActivity, "ERROR", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
