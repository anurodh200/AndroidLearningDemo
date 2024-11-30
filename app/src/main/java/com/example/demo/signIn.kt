package com.example.demo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class signIn : AppCompatActivity() {

    companion object{
        const val KEY_name = "com.example.demo.signInActivity.KEY_name"
        const val KEY_email = "com.example.demo.signInActivity.KEY_email"
        const val KEY_ID = "com.example.demo.signInActivity.KEY_ID"
    }

    lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val signInBtn = findViewById<Button>(R.id.btnSignIn)
        val userID = findViewById<TextInputEditText>(R.id.etID)

        signInBtn.setOnClickListener {
            val uniqueId = userID.text.toString()

            if (uniqueId.isNotEmpty()) {
                readData(uniqueId)
            } else {
                Toast.makeText(this, "Please enter User ID", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun readData(uniqueId: String) {
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        databaseReference.child(uniqueId).get().addOnSuccessListener {
            if (it.exists()) {
                val email = it.child("email").value
                val name = it.child("name").value
                val userID = it.child("uniqueId").value
                Toast.makeText(this, "Welcome $name", Toast.LENGTH_SHORT).show()

                // Navigate to the HomeActivity
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra(KEY_email, email.toString())
                intent.putExtra(KEY_name, name.toString())
                intent.putExtra(KEY_ID, userID.toString())
                startActivity(intent)


            } else {
                Toast.makeText(this, "User does not exist", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
        }
    }
}