package com.example.examen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.examen.model.Persona

class BienvenidoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        val user = intent.getSerializableExtra("USER") as? Persona
        if (user != null) {
            val welcomeMessage = "Bienvenid@ a la APP"
            val welcomeTextView = findViewById<TextView>(R.id.bienvenidaTextView)
            val usernameTextView = findViewById<TextView>(R.id.usernameTextView)

            welcomeTextView.text = welcomeMessage
            usernameTextView.text = "${user.nombre} ${user.apellidos}"
        }

        val backToLoginButton = findViewById<Button>(R.id.backToLoginButton)
        backToLoginButton.setOnClickListener {
            val intent = Intent(this@BienvenidoActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
