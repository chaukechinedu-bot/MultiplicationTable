package com.example.multiplicationapk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val multiplyButton = findViewById<Button>(R.id.btnMultiply)
        val tableNumber = findViewById<EditText>(R.id.txtNumber)
        multiplyButton.setOnClickListener {
            
            val intent = Intent(this, MultiplicationTable::class.java)
            intent.putExtra("tableNumber",
                tableNumber.text.toString())
            startActivity(intent)
        }


        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}