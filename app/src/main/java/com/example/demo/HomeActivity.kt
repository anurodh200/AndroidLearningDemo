package com.example.demo

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val email = intent.getStringExtra(signIn.KEY_email)
        val name = intent.getStringExtra(signIn.KEY_name)
        val uniqueID = intent.getStringExtra(signIn.KEY_ID)

        val emailTextView = findViewById<TextView>(R.id.email)
        val welcomeTextView = findViewById<TextView>(R.id.welcomeTxt)
        val uniqueIDTextView = findViewById<TextView>(R.id.ID)

        emailTextView.text = "Email: $email"
        welcomeTextView.text = "Welcome $name"
        uniqueIDTextView.text = "Unique ID: $uniqueID"
    }
}