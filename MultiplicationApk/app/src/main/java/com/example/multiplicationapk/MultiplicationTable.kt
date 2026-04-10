package com.example.multiplicationapk

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MultiplicationTable : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_multiplication_table)

        val bundle: Bundle? = intent.extras
        val tableString: String? = bundle?.getString("tablenumber")
        val tableNumber = tableString!!.toInt()
        val multiplicationTable = findViewById<TextView>(R.id.multiplicationTableTextView)
        var tableDisplay : String = "$tableNumber x table\n\n"
        multiplicationTable.text = tableDisplay

        var counter = 1
        while (counter <= 10){
            val answer = tableNumber * counter
            tableDisplay += "$tableNumber x $counter = ${answer}\n"
            counter++
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}