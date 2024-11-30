package com.example.demo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class signUp : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    private lateinit var etName: TextInputEditText
    private lateinit var etEmail: TextInputEditText
    private lateinit var etPassword: TextInputEditText
    private lateinit var etID: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Initialize TextInputEditText fields
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etID = findViewById(R.id.etID)

        // Button
        val signUpBtn = findViewById<Button>(R.id.btn)

        // Button click listener
        signUpBtn.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            val id = etID.text.toString()

            // Perform actions with these values, e.g., validation or sending to a server
            var user = User(name, email, password)

            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(id).setValue(user).addOnSuccessListener {
                etName.text?.clear()
                etEmail.text?.clear()
                etPassword.text?.clear()
                etID.text?.clear()
                Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Failed Registration", Toast.LENGTH_SHORT).show()
            }
        }

        val signInTxt = findViewById<TextView>(R.id.txtSignIn)
        signInTxt.setOnClickListener {
            val openActivity = android.content.Intent(this, signIn::class.java)
            startActivity(openActivity)
        }
    }
}
