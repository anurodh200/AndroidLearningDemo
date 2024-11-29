package com.example.demo

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object{
        const val KEY = "com.example.demo.MainActivity.KEY"
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            val orderDetails = binding.et1.text.toString() + " " + binding.et2.text.toString() + " " + binding.et3.text + " " + binding.et4.text

            intent = Intent(this, ShowOrder::class.java)
            intent.putExtra(KEY, orderDetails)
            startActivity(intent)
        }


//        webBtn.setOnClickListener {
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse("https://desibakery.co.in/")
//            startActivity(intent)
//        }

//        cameraBtn.setOnClickListener {
//            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//            startActivity(intent)
//        }

//        btnIntent.setOnClickListener {
//            //Open a new Activity
//            intent = Intent(applicationContext, IntentScreen::class.java)
//            startActivity(intent)
//        }
    }

//    @RequiresApi(Build.VERSION_CODES.O)
//    private fun webViewSetup(webView: WebView?) {
//        webView?.webViewClient = WebViewClient()
//
//        webView?.apply {
//            settings.javaScriptEnabled = true
//            settings.safeBrowsingEnabled = true
//            loadUrl("https://desibakery.co.in/")
//        }
//
//    }

}