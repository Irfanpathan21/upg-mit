package com.uianp308p.q19datapassing

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.uianp308p.q19datapassing.R

class Q19DataPassingActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q19_data_passing_1)

        val etName = findViewById<EditText>(R.id.etName)
        val etAge = findViewById<EditText>(R.id.etAge)
        val etCity = findViewById<EditText>(R.id.etCity)
        val btnSubmit = findViewById<Button>(R.id.btnSubmitData)

        btnSubmit.setOnClickListener {
            val name = etName.text.toString().trim()
            val ageStr = etAge.text.toString().trim()
            val city = etCity.text.toString().trim()

            if (name.isEmpty() || ageStr.isEmpty() || city.isEmpty()) {
                AlertDialog.Builder(this)
                    .setTitle(R.string.dialog_error_title)
                    .setMessage(R.string.q19_err_fields)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton(R.string.dialog_ok, null)
                    .show()
                return@setOnClickListener
            }

            val age = ageStr.toIntOrNull() ?: 0
            val intent = Intent(this, Q19DataPassingActivity2::class.java).apply {
                putExtra("EXTRA_NAME", name)
                putExtra("EXTRA_AGE", age)
                putExtra("EXTRA_CITY", city)
            }
            startActivity(intent)
        }
    }
}
