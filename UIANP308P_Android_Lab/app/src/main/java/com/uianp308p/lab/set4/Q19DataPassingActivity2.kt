package com.uianp308p.lab.set4

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.uianp308p.lab.R

class Q19DataPassingActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q19_data_passing_2)

        val tvName = findViewById<TextView>(R.id.tvReceivedName)
        val tvAge = findViewById<TextView>(R.id.tvReceivedAge)
        val tvCity = findViewById<TextView>(R.id.tvReceivedCity)
        val tvClassification = findViewById<TextView>(R.id.tvClassification)
        val btnBack = findViewById<Button>(R.id.btnBack)

        val name = intent.getStringExtra("EXTRA_NAME") ?: "Unknown"
        val age = intent.getIntExtra("EXTRA_AGE", 0)
        val city = intent.getStringExtra("EXTRA_CITY") ?: "Unknown"

        tvName.text = "Name: $name"
        tvAge.text = "Age: $age years"
        tvCity.text = "City: $city"

        if (age >= 18) {
            tvClassification.text = getString(R.string.q19_adult)
            tvClassification.setBackgroundColor(Color.parseColor("#2E7D32")) // Success green
        } else {
            tvClassification.text = getString(R.string.q19_minor)
            tvClassification.setBackgroundColor(Color.parseColor("#F57C00")) // Orange warning
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}
