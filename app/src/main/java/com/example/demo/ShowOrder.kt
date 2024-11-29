package com.example.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.demo.databinding.ActivityMainBinding
import com.example.demo.databinding.ActivityShowOrderBinding

class ShowOrder : AppCompatActivity() {
    private lateinit var binding: ActivityShowOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using View Binding
        binding = ActivityShowOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val orderOfCustomer = intent.getStringExtra(MainActivity.KEY)

        binding.OrderDetails.text = orderOfCustomer
    }
}