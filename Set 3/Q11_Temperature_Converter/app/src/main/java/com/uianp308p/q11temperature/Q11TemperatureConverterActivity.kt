package com.uianp308p.q11temperature

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.uianp308p.q11temperature.R

class Q11TemperatureConverterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q11_temperature_converter)

        val etTempInput = findViewById<EditText>(R.id.etTempInput)
        val rgConversion = findViewById<RadioGroup>(R.id.rgConversion)
        val rbCtoF = findViewById<RadioButton>(R.id.rbCtoF)
        val rbFtoC = findViewById<RadioButton>(R.id.rbFtoC)
        val btnConvert = findViewById<Button>(R.id.btnConvert)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnConvert.setOnClickListener {
            val inputStr = etTempInput.text.toString().trim()
            val selectedRadioId = rgConversion.checkedRadioButtonId

            // Validation
            if (inputStr.isEmpty() || selectedRadioId == -1) {
                AlertDialog.Builder(this)
                    .setTitle(R.string.dialog_error_title)
                    .setMessage(R.string.q11_error_empty)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton(R.string.dialog_ok, null)
                    .show()
                return@setOnClickListener
            }

            val tempVal = inputStr.toDoubleOrNull()
            if (tempVal == null) {
                AlertDialog.Builder(this)
                    .setTitle(R.string.dialog_error_title)
                    .setMessage("Invalid numerical input")
                    .setPositiveButton(R.string.dialog_ok, null)
                    .show()
                return@setOnClickListener
            }

            if (selectedRadioId == R.id.rbCtoF) {
                val fahrenheit = (tempVal * 9.0 / 5.0) + 32.0
                tvResult.text = String.format("%.2f °C = %.2f °F", tempVal, fahrenheit)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.color_c_to_f))
            } else if (selectedRadioId == R.id.rbFtoC) {
                val celsius = (tempVal - 32.0) * 5.0 / 9.0
                tvResult.text = String.format("%.2f °F = %.2f °C", tempVal, celsius)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.color_f_to_c))
            }
        }
    }
}
